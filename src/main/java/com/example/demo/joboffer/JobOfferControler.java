package com.example.demo.joboffer;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class JobOfferControler {


    private final JobOfferService jobOfferService;


    public JobOfferControler(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }






    @GetMapping("/{id}")
    ResponseEntity<JobOfferDto> getOfferById(@PathVariable Long id){

        return jobOfferService.getOfferById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping("/allOffers/{Cid}")
    public List<JobOfferDto> getCategoriesByNameCategory(@PathVariable Long Cid){
        return jobOfferService.getCategoriesByNameCategory(Cid);
    }

    @GetMapping("")
    public List<JobOfferDto> getAllOffers(){
        return jobOfferService.getAllOffers();
    }



    @PostMapping
    ResponseEntity<JobOfferDto> saveOffer(@RequestBody JobOfferDto jobOfferDto) {
        JobOfferDto savedJobOffer = jobOfferService.saveOffer(jobOfferDto);
        URI savedJobOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedJobOffer.getId())
                .toUri();
        return ResponseEntity.created(savedJobOfferUri).body(savedJobOffer);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateJobOffer(@PathVariable Long id, @RequestBody JobOfferDto jobOffer) {
        return jobOfferService.updateOffer(id, jobOffer)
                .map(offer -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteJobOffer(@PathVariable Long id) {
        jobOfferService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }







}
