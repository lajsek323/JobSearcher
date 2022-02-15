package com.example.demo.JobCategory;



import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class JobCategoryService {

    private final JobCategoryDtoMapper jobCategoryDto;
    private final JobCategoryRepository jobCategoryRepository;
    private final JobCategoryDtoMapper jobCategoryDtoMapper;

    public JobCategoryService(JobCategoryDtoMapper jobCategoryDto, JobCategoryRepository jobCategoryRepository, JobCategoryDtoMapper jobCategoryDtoMapper) {
        this.jobCategoryDto = jobCategoryDto;
        this.jobCategoryRepository = jobCategoryRepository;
        this.jobCategoryDtoMapper = jobCategoryDtoMapper;
    }


    public List<JobCategoryDto> getAllCategories(){


        return jobCategoryRepository.findAll().stream().map(jobCategoryDtoMapper::map)
                .collect(Collectors.toList());
    }

    public List<JobCategoryDto> getJobOffersByNameCategory(String name) {


        return jobCategoryRepository.findJobCategoryByNameCategory(name)
                .stream().map(jobCategoryDtoMapper::map)
                .collect(Collectors.toList());
    }
}
