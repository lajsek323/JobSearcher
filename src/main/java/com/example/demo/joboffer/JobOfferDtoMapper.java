package com.example.demo.joboffer;


import org.springframework.stereotype.Service;
import com.example.demo.company.CompanyRepository;

@Service
public class JobOfferDtoMapper {

    private final CompanyRepository companyRepository;

    public JobOfferDtoMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public JobOfferDto map(JobOffer jobOffer){

        JobOfferDto dto = new JobOfferDto();
        dto.setId(jobOffer.getId());
        dto.setTitle(jobOffer.getTitle());
        dto.setDescription(jobOffer.getDescription());
        dto.setRequirements(jobOffer.getRequirements());
        dto.setDuties(jobOffer.getDuties());
        dto.setLocation(jobOffer.getLocation());
        dto.setMinSalary(jobOffer.getMinSalary());
        dto.setMaxSalary(jobOffer.getMaxSalary());
        dto.setDateAdded(jobOffer.getDateAdded());
        dto.setCompanyId(jobOffer.getCompany().getId());
        dto.setCompanyName(jobOffer.getCompany().getName());
        dto.setCategoryId(jobOffer.getJobCategory().getId());
        return dto;
    }


    JobOffer map(JobOfferDto dto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setTitle(dto.getTitle());
        jobOffer.setDescription(dto.getDescription());
        jobOffer.setRequirements(dto.getRequirements());
        jobOffer.setDuties(dto.getDuties());
        jobOffer.setLocation(dto.getLocation());
        jobOffer.setMinSalary(dto.getMinSalary());
        jobOffer.setMaxSalary(dto.getMaxSalary());
        companyRepository.findById(dto.getCompanyId())
                .ifPresent(jobOffer::setCompany);
        return jobOffer;
    }




}
