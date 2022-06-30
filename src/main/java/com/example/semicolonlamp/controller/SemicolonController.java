package com.example.semicolonlamp.controller;

import com.example.semicolonlamp.dtos.requests.CohortRequest;
import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.dtos.response.NativeResponse;
import com.example.semicolonlamp.models.SemicolonPortal;
import com.example.semicolonlamp.service.SemicolonPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/semicolon")
public class SemicolonController {
    @Autowired
    SemicolonPortalService semicolonPortalService;

    @PostMapping("/registerOrganization")
    public ResponseEntity<?> registerOrganization(
            @RequestBody SemicolonPortalRequest semicolonPortalRequest) {

        semicolonPortalService.registerOrganization(semicolonPortalRequest);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }
    @PostMapping("/registerCohort/{orgNo}")
    public ResponseEntity<?> registerCohort(@RequestBody CohortRequest cohortRequest, @PathVariable String orgNo){
        semicolonPortalService.registerCohort(orgNo,cohortRequest);
        return new ResponseEntity<>("cohort added successfully", HttpStatus.OK);
    }
    @GetMapping("/getOrg/{orgNo}")
    public SemicolonPortal getOrg(@PathVariable String orgNo){
        return semicolonPortalService.getOrg(orgNo);
    }

    @PostMapping("/registerNative/{orgNo}/{cohortNo}")
    public ResponseEntity<?> registerNative(
            @RequestBody NativeRequest nativeRequest,
            @PathVariable("orgNo") String orgNo,
            @PathVariable String cohortNo) {
        semicolonPortalService.registerNative(orgNo,cohortNo, nativeRequest);
        return new ResponseEntity<>("native created successfully", HttpStatus.OK);
    }

    @GetMapping("/getNative/{orgNo}/{cohortNo}/{nativeNo}")
    public NativeResponse getNative(@PathVariable("nativeNo") String nativeNo,
                                    @PathVariable("orgNo") String orgNo, @PathVariable String cohortNo) {
        return semicolonPortalService.getNative(orgNo,cohortNo, nativeNo);
    }


}
