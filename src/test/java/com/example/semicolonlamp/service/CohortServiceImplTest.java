package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.models.Cohort;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.repository.CohortRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class CohortServiceImplTest {
    @Mock
    CohortRepository cohortRepository;
    @InjectMocks
    CohortServiceImpl cohortService;
    Cohort cohort;
    @BeforeEach
    void setUp(){
        var cohortRQST = new CohortRequest();
        cohortRQST.setCohortName("luminaries");

        cohort = cohortService.addCohort(cohortRQST);
    }

    @Test
    void addCohort() {
        var cohortArgCaptor = ArgumentCaptor.forClass(Cohort.class);
        verify(cohortRepository).save(cohortArgCaptor.capture());
        var savedCohort = cohortArgCaptor.getValue();

        assertEquals("luminaries", savedCohort.getCohortName());
    }

    @Test
    void getCohort() {
        var cohortArgCaptor = ArgumentCaptor.forClass(Cohort.class);
        verify(cohortRepository).save(cohortArgCaptor.capture());
        var savedCohort = cohortArgCaptor.getValue();
        try {
            cohortService.getCohort(savedCohort.getCohortNumber());
        }catch (Exception ignored){}
        assertNotEquals(savedCohort.getCohortNumber(),"0");

    }

    @Test
    void addNative() {
        Native aNative = new Native();

        var cohortArgCaptor = ArgumentCaptor.forClass(Cohort.class);
        verify(cohortRepository).save(cohortArgCaptor.capture());
        var savedCohort = cohortArgCaptor.getValue();

        cohortService.addNativeToCohort(savedCohort,aNative);
        assertEquals(1,savedCohort.getNatives().size());

    }
}