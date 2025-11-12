package com.example.umc9th.domain.test.converter;

import com.example.umc9th.domain.test.dto.TestResDTO;
import org.springframework.http.HttpStatus;

public class TestConverter {

    // 객체 -> DTO 변환
    public static TestResDTO.Testing toTestingDTO(String testing){
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();

    }

    // 객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(String testing){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
