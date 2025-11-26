package com.example.umc9th.global.validator;

import com.example.umc9th.domain.member.exception.code.FoodErrorCode;
import com.example.umc9th.global.annotation.InvalidPageNum;
import com.example.umc9th.global.apiPayload.code.PageErrorCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageNumValidator implements ConstraintValidator<InvalidPageNum, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        boolean isValid = page >= 1;  // 1 이상일 때 true

        if (!isValid) { // page 가 0 이하의 수일 때 false
            // 디폴트 메시지 초기화, 새로운 메시지로 덮어 씌움
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(PageErrorCode.INVALID_PAGE_NUMBER.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
