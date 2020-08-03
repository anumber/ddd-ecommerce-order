package com.ecommerce.order.common.exception;

import static com.google.common.collect.ImmutableMap.of;
/**
 * <p>
 * </p>
 */
public class LockAlreadyOccupiedException extends AppException {
    public LockAlreadyOccupiedException(String lockKey) {
        super(CommonErrorCode.LOCK_OCCUPIED, of("lockKey", lockKey));
    }
}
