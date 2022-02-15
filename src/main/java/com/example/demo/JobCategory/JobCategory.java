package com.example.demo.JobCategory;


import com.example.demo.joboffer.JobOffer;
import com.example.demo.joboffer.JobOfferDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategory;
    @OneToMany(mappedBy = "jobCategory", cascade = CascadeType.REMOVE)
    private Set<JobOffer> jobOfferSet;



}
