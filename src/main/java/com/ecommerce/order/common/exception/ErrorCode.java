package com.ecommerce.order.common.exception;

/**
 * <p>
 * </p>
 */
public interface ErrorCode {
    int getStatus();

    String getMessage();

    String getCode();
}
