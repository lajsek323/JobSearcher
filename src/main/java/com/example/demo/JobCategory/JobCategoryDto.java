package com.example.demo.JobCategory;

import com.example.demo.joboffer.JobOffer;
import com.example.demo.joboffer.JobOfferDto;
import com.example.demo.joboffer.JobOfferDtoMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class JobCategoryDto {


    private Long id;
    private String nameCategory;
    private Set<JobOfferDto> jobOfferSet;
}
