package com.example.semicolonlamp.repository;

import com.example.semicolonlamp.models.SemicolonPortal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SemicolonPortalRepository extends MongoRepository<SemicolonPortal,String> {
    SemicolonPortal findByOrganizationNo(String organizationNo);

}
