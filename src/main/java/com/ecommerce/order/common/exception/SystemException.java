package com.ecommerce.order.common.exception;

import static com.google.common.collect.ImmutableMap.of;
/**
 * <p>
 * </p>
 */
public class SystemException extends AppException {

    public SystemException(Throwable cause) {
        super(CommonErrorCode.SYSTEM_ERROR, of("detail", cause.getMessage()), cause);
    }
}
