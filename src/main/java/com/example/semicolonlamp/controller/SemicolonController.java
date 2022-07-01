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
@RequestMapping("semicolon")
public class SemicolonController {
    @Autowired
    SemicolonPortalService semicolonPortalService;

    @PostMapping("/registerOrganization")
    public ResponseEntity<?> registerOrganization(
            @RequestBody SemicolonPortalRequest semicolonPortalRequest) {

        semicolonPortalService.registerOrganization(semicolonPortalRequest);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping("/registerCohort")
    public ResponseEntity<?> registerCohort(@RequestBody CohortRequest cohortRequest,
                                            @RequestParam String orgNo){
        semicolonPortalService.registerCohort(orgNo,cohortRequest);
        return new ResponseEntity<>("cohort added successfully", HttpStatus.OK);
    }

    @GetMapping("/getOrg")
    public SemicolonPortal getOrg(@RequestParam String orgNo){
        return semicolonPortalService.getOrg(orgNo);
    }

    @PostMapping("/registerNative")
    public ResponseEntity<?> registerANative(
            @RequestBody NativeRequest nativeRequest,
            @RequestParam String orgNo,
            @RequestParam String cohortNo) {
        semicolonPortalService.registerNative(orgNo,cohortNo, nativeRequest);
        return new ResponseEntity<>("native created successfully", HttpStatus.OK);
    }


    @GetMapping("/getNative")
    public NativeResponse getANative(@RequestParam String orgNo,
                                     @RequestParam String cohortNo,@RequestParam String nativeNo){
        return semicolonPortalService.getNative(orgNo,cohortNo, nativeNo);
    }

}
