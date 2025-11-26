package com.example.umc9th.global.annotation;

import com.example.umc9th.global.validator.PageNumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageNumValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvalidPageNum {
    // 디폴트 메시지 설정
    String message() default "잘못된 페이지 번호입니다. 1 이상의 번호를 입력해주세요.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
