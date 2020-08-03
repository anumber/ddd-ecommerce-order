package com.ecommerce.order.common.spring.exception;

import com.ecommerce.order.common.exception.AppException;
import lombok.Value;

import java.time.Instant;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.apache.commons.collections4.MapUtils.isEmpty;

/**
 * <p>
 * </p>
 */
@Value
public class ErrorRepresentation {

    String requestId;
    String code;
    int status;
    String message;
    String path;
    Instant timestamp;
    Map<String, Object> data = newHashMap();

    public ErrorRepresentation(AppException ex, String path, String requestId) {
        this(requestId, ex.getError().getCode(), ex.getError().getStatus(), ex.getError().getMessage(), path, ex.getData());
    }
    public ErrorRepresentation(String requestId, String code, int status, String message, String path, Map<String, Object> data) {
        this.requestId = requestId;
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if (!isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
