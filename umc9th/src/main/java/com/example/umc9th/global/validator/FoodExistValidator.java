package com.example.umc9th.global.validator;

import com.example.umc9th.domain.member.exception.code.FoodErrorCode;
import com.example.umc9th.domain.member.repository.FoodRepository;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodRepository foodRepository;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodRepository.existsById(value));

        if (!isValid) { // DB에 없는 경우 - isValid == false
            // 디폴트 메시지 초기화, 새로운 메시지로 덮어 씌움
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodErrorCode.FOOD_NOT_FOUND.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}
