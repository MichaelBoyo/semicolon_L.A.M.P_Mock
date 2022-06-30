package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.dtos.response.NativeResponse;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.models.SemicolonPortal;

public interface SemicolonPortalService {
    void registerNative(String OrganizationNo,String cohortNo,NativeRequest nativeRequest);
    NativeResponse getNative(String OrganizationNo,String cohortNo, String nativeNo);
    void registerOrganization(SemicolonPortalRequest semicolonPortalRequest);

    void registerCohort(String OrganizationNo,CohortRequest cohortRequest);

    SemicolonPortal getOrg(String orgNo);
}
