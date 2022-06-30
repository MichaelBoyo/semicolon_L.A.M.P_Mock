package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.models.Cohort;
import com.example.semicolonlamp.models.Native;

public interface CohortService {
    Cohort addCohort(CohortRequest cohortRequest);
    Cohort getCohort(String cohortNo);

    void addNativeToCohort(Cohort cohort, Native aNative);
}
