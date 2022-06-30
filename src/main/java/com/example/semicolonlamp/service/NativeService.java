package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.models.Native;

public interface NativeService {
    Native addNative(NativeRequest _native);
    Native getNative(String nativeID);

    void save(Native aNative);
}
