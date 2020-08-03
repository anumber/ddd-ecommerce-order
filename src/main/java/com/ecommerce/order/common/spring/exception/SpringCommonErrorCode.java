package com.ecommerce.order.common.spring.exception;

import com.ecommerce.order.common.exception.ErrorCode;

/**
 * <p>
 * </p>
 */
public enum SpringCommonErrorCode implements ErrorCode {
    REQUEST_VALIDATION_FAILED(400, "请求数据格式验证失败");
    private int status;
    private String message;

    SpringCommonErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
