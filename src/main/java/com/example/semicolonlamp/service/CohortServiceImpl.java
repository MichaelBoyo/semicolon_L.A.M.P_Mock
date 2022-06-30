package com.example.semicolonlamp.service;

import com.example.semicolonlamp.SemicolonException;
import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.models.Cohort;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.repository.CohortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CohortServiceImpl implements CohortService {
    @Autowired
    CohortRepository cohortRepository;

    @Override
    public Cohort addCohort(CohortRequest cohortRequest) {
        var cohort = new Cohort(generateCohortID(), cohortRequest.getCohortName());
        cohortRepository.save(cohort);
        return cohort;
    }

    @Override
    public Cohort getCohort(String cohortNo) {
        Optional<Cohort> cohort = Optional.ofNullable(cohortRepository.findByCohortNumber(cohortNo));
        return cohort.orElseThrow(() -> {
            throw new SemicolonException("cohort not found");
        });
    }


    @Override
    public void addNativeToCohort(Cohort cohort, Native aNative) {
        cohort.getNatives().add(aNative);
        cohortRepository.save(cohort);
    }

    private String generateCohortID() {
        Random random = new Random();
        StringBuilder cohortID = new StringBuilder();
        cohortID.append("coh");
        for (int i = 0; i < 5; i++) {
            cohortID.append(random.nextInt(10));
        }
        return cohortID.toString();
    }
}
