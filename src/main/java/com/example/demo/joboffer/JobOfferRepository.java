package com.example.demo.joboffer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobOfferRepository extends CrudRepository<JobOffer,Long> {

    @Query(
            value = "SELECT * FROM JOB_OFFER u WHERE u.category_id = ?1",
            nativeQuery = true)
    public List<JobOfferDto> getJobOffersByNameCategory(Long id);

    public List<JobOffer> findAll();



}
