package com.example.demo.JobCategory;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobCategoryController {

    private final JobCategoryService jobCategoryService;

    public JobCategoryController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }


    @GetMapping("/categories")
    List<JobCategoryDto> gettAllCategories(){
        return jobCategoryService.getAllCategories();

    }

    @GetMapping("/categories/{name}")
    List<JobCategoryDto> getJobOffersByNameCategory(@PathVariable String name){

        return jobCategoryService.getJobOffersByNameCategory(name);

    }

}
