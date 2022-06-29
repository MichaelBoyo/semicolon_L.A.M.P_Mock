package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.dtos.response.NativeResponse;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.models.Native;

public interface SemicolonPortalService {
    void registerNative(String OrganizationNo,NativeRequest nativeRequest);
    NativeResponse getNative(String OrganizationNo, String nativeNo);
    void registerOrganization(SemicolonPortalRequest semicolonPortalRequest);
}
