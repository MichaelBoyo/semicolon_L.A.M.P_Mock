package com.example.semicolonlamp.controller;

import com.example.semicolonlamp.SemicolonException;
import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.dtos.requests.SemicolonPortalRequest;
import com.example.semicolonlamp.dtos.response.NativeResponse;
import com.example.semicolonlamp.models.Native;
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
            @RequestBody SemicolonPortalRequest semicolonPortalRequest){
        try{
            semicolonPortalService.registerOrganization(semicolonPortalRequest);
            return new ResponseEntity<>("created successfully",HttpStatus.OK);
        }catch(SemicolonException err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/registerNative/{orgNo}")
    public ResponseEntity<?> registerNative(
            @RequestBody NativeRequest nativeRequest, @PathVariable("orgNo") String orgNo){
        try{
            semicolonPortalService.registerNative(orgNo,nativeRequest);
            return new ResponseEntity<>("native created successfully",HttpStatus.OK);
        }catch(SemicolonException err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getNative/{orgNo}/{nativeNo}")
    public NativeResponse getNative(@PathVariable("nativeNo") String nativeNo,
                            @PathVariable("orgNo") String orgNo){
        try{
            return semicolonPortalService.getNative(orgNo,nativeNo);
        }catch(SemicolonException err){
           err.printStackTrace();
        }
        return null;

    }


}
