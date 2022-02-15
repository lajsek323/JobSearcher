package com.example.demo.JobCategory;

import com.example.demo.joboffer.JobOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobCategoryRepository extends CrudRepository<JobCategory,Long> {


    public List<JobCategory> findAll();

    public List<JobCategory> findJobCategoryByNameCategory(String name);

}
