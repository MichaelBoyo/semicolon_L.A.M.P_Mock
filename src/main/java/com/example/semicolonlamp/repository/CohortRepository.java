package com.example.semicolonlamp.repository;

import com.example.semicolonlamp.models.Cohort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CohortRepository extends MongoRepository<Cohort,String> {
    Cohort findByCohortNumber(String cohortNo);
}
