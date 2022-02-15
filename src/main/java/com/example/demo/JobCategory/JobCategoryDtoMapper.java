package com.example.demo.JobCategory;

import com.example.demo.joboffer.JobOfferDtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JobCategoryDtoMapper {

    private final JobOfferDtoMapper jobOfferDtoMapper;

    public JobCategoryDtoMapper(JobOfferDtoMapper jobOfferDtoMapper) {
        this.jobOfferDtoMapper = jobOfferDtoMapper;
    }

    public JobCategoryDto map(JobCategory jobCategory){

        JobCategoryDto jobCategoryDto = new JobCategoryDto();
        jobCategoryDto.setNameCategory(jobCategory.getNameCategory());
        jobCategoryDto.setId(jobCategory.getId());
        jobCategoryDto.setJobOfferSet(jobCategory.getJobOfferSet().stream()
                .map(jobOfferDtoMapper::map).collect(Collectors.toSet()));

        return jobCategoryDto;

    }

}
