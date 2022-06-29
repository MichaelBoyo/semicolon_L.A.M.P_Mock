package com.example.semicolonlamp.service;

import com.example.semicolonlamp.SemicolonException;
import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.repository.NativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
public class NativeServiceImpl implements NativeService{
    @Autowired
    NativeRepository nativeRepository;

    @Override
    public Native addNative(NativeRequest _native) {
        var native_ = new Native();
        native_.setFirstName(_native.getFirstName());
        native_.setNativeID(generateNativeNo());
        native_.setLastName(_native.getLastName());
        native_.setEmail(_native.getEmail());
        native_.setPhone(_native.getPhone());
        native_.setAge(_native.getAge());
        nativeRepository.save(native_);
        return native_;
    }

    @Override
    public Native getNative(String nativeID) {
        Optional<Native> native_ = Optional.ofNullable(nativeRepository.findByNativeID(nativeID));
        return native_.orElseThrow(()->{
           throw  new SemicolonException("native not found");
        }
        );
    }
    private String generateNativeNo(){
        Random random = new Random(10);
        StringBuilder txNo = new StringBuilder();
        txNo.append(101);
        for (int i = 0; i <7 ; i++) {
            txNo.append(random.nextInt(10));
        }
        return txNo.toString();
    }
}
