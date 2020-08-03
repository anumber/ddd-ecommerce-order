package com.ecommerce.order.common.spring.exception;

import com.ecommerce.order.common.exception.AppException;

import java.util.Map;

/**
 * <p>
 * </p>
 */
public class RequestValidationException extends AppException {
    public RequestValidationException(Map<String, Object> data) {
        super(SpringCommonErrorCode.REQUEST_VALIDATION_FAILED, data);
    }
}
