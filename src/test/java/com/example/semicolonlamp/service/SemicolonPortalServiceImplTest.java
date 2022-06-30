package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.models.Cohort;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.models.SemicolonPortal;
import com.example.semicolonlamp.repository.CohortRepository;
import com.example.semicolonlamp.repository.NativeRepository;
import com.example.semicolonlamp.repository.SemicolonPortalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SemicolonPortalServiceImplTest {
    @Mock
    SemicolonPortalRepository semicolonPortalRepository;
    @Mock
    CohortRepository cohortRepository;
    @Mock
    NativeRepository nativeRepository;
    @InjectMocks
    CohortServiceImpl cohortService;
    @InjectMocks
    NativeServiceImpl nativeService;
    @InjectMocks
    SemicolonPortalServiceImpl semicolonPortalService;
    SemicolonPortal savedPortal;

    @BeforeEach
    void setUp() {
        SemicolonPortalRequest portal = new SemicolonPortalRequest();
        portal.setName("semicolon");
        semicolonPortalService.registerOrganization(portal);


        var nativeArgsCapture = ArgumentCaptor.forClass(SemicolonPortal.class);
        verify(semicolonPortalRepository).save(nativeArgsCapture.capture());
        savedPortal = nativeArgsCapture.getValue();
    }

    @Test
    void registerOrganization() {
        assertEquals(savedPortal.getName(), "semicolon");
    }
    @Test
    void registerCohort() {
        CohortRequest cohortRequest = new CohortRequest();
        cohortRequest.setCohortName("luminaries");
        cohortService.addCohort(cohortRequest);

        try {
            semicolonPortalService.registerCohort(savedPortal.getOrganizationNo(),
                    cohortRequest);
        }catch (Exception ignored){}

        assertEquals(savedPortal.getCohorts().size(),0);

    }

    @Test
    void registerNative() {

    }

    @Test
    void getNative() {
    }




    @Test
    void getOrg() {
        try{
            semicolonPortalService.getOrg(savedPortal.getOrganizationNo());
        }catch (Exception ignored){}
    }
}