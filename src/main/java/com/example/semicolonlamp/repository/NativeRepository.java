package com.example.semicolonlamp.repository;

import com.example.semicolonlamp.models.Native;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NativeRepository extends MongoRepository<Native, String> {
    Native findByNativeID(String nativeId);
}
