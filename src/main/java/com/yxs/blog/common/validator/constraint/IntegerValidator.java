package com.yxs.blog.common.validator.constraint;


import com.yxs.blog.common.validator.annotion.IntegerNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Andy Chen
 * @date 9/30/19 12:33 PM
 */
public class IntegerValidator implements ConstraintValidator<IntegerNotNull, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null ) {
            return false;
        }
        return true;
    }
}
