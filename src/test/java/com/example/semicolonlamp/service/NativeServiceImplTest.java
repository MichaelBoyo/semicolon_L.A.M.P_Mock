package com.example.semicolonlamp.service;

import com.example.semicolonlamp.dtos.requests.NativeRequest;
import com.example.semicolonlamp.models.Native;
import com.example.semicolonlamp.repository.NativeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.semicolonlamp.enums.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NativeServiceImplTest {
    @Mock
    NativeRepository nativeRepository;
    @InjectMocks
    NativeServiceImpl nativeService;
    NativeRequest nativeRQST;

    @BeforeEach
    void setUp() {
        nativeRQST = new NativeRequest("Eden", "Elenwoke", "woke@gmail.com", "08023443234", "23", FEMALE);
        nativeRQST.setFirstName("Eden");
        nativeService.addNative(nativeRQST);
    }

    @Test
    void addNative() {
        var nativeArgsCapture = ArgumentCaptor.forClass(Native.class);
        verify(nativeRepository).save(nativeArgsCapture.capture());
        var savedNative = nativeArgsCapture.getValue();
        assertEquals("Eden", savedNative.getFirstName());
    }

    @Test
    void getNative() {
        var nativeArgsCapture = ArgumentCaptor.forClass(Native.class);
        verify(nativeRepository).save(nativeArgsCapture.capture());
        var savedNative = nativeArgsCapture.getValue();

        assertEquals("Eden", savedNative.getFirstName());
        assertNotNull(savedNative.getNativeID());
    }
}