package com.example.semicolonlamp.service;

import com.example.semicolonlamp.SemicolonException;
import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.dtos.response.NativeResponse;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.models.SemicolonPortal;
import com.example.semicolonlamp.repository.SemicolonPortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
public class SemicolonPortalServiceImpl implements SemicolonPortalService{
    @Autowired
    SemicolonPortalRepository semicolonPortalRepository;
    @Autowired
    NativeService nativeService;


    private SemicolonPortal getPortal(String organizationNo){
        Optional<SemicolonPortal> portal = Optional.ofNullable(semicolonPortalRepository.
                findByOrganizationNo(organizationNo));
        return portal.orElseThrow(()->{
            throw new SemicolonException("wrong organization id");
        });
    }

    @Override
    public void registerNative(String organizationNo, NativeRequest nativeRequest) {
        var portal = getPortal(organizationNo);
        var _native = nativeService.addNative(nativeRequest);
        portal.getNatives().add(_native);
        semicolonPortalRepository.save(portal);
    }

    @Override
    public NativeResponse getNative(String OrganizationNo, String nativeNo) {
        var org = getPortal(OrganizationNo);
        var _native = nativeService.getNative(nativeNo);
        if(org.getNatives().contains(_native)){
            System.out.println("found");

            return new NativeResponse(_native.getFirstName()+" "+_native.getLastName(),
                    _native.getEmail(),_native.getPhone(),_native.getCohort());
        }
        throw new SemicolonException("native not found");

    }

    @Override
    public void registerOrganization(SemicolonPortalRequest semicolonPortalRequest) {
        var semicolonPortal = new SemicolonPortal(generateOrganizationNo(),
                semicolonPortalRequest.getName(),
                semicolonPortalRequest.getPassword());
        semicolonPortalRepository.save(semicolonPortal);
    }
    private String generateOrganizationNo(){
        Random random = new Random(10);
        StringBuilder orgNo = new StringBuilder();
        orgNo.append(1);
        for (int i = 0; i <4 ; i++) {
            orgNo.append(random.nextInt(10));
        }
        return orgNo.toString();
    }
}
