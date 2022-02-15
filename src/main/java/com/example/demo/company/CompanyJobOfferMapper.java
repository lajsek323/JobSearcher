package com.example.demo.company;



import com.example.demo.joboffer.CompanyJobOfferDto;
import com.example.demo.joboffer.JobOffer;
import org.springframework.stereotype.Service;

@Service
public class CompanyJobOfferMapper {


    CompanyJobOfferDto map(JobOffer jobOffer) {
            CompanyJobOfferDto dto = new CompanyJobOfferDto();
            dto.setId(jobOffer.getId());
            dto.setTitle(jobOffer.getTitle());
            dto.setLocation(jobOffer.getLocation());
            dto.setMinSalary(jobOffer.getMinSalary());
            dto.setMaxSalary(jobOffer.getMaxSalary());
            return dto;
    }

}
