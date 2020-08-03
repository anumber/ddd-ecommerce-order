package com.ecommerce.order.common.spring.exception;

import com.ecommerce.order.common.exception.AppException;
import com.ecommerce.order.common.exception.SystemException;
import com.ecommerce.order.common.logging.RequestIdMdcFilter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.springframework.http.HttpStatus.valueOf;

/**
 * <p>
 * </p>
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<?> handleAppException(AppException ex, HttpServletRequest request) {
        log.warn("App error:", ex);
        String path = request.getRequestURI();
        String requestId = MDC.get(RequestIdMdcFilter.REQUEST_ID);

        ErrorRepresentation representation = new ErrorRepresentation(ex, path, requestId);
        return new ResponseEntity<>(representation, new HttpHeaders(), valueOf(ex.getError().getStatus()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        String requestId = MDC.get(RequestIdMdcFilter.REQUEST_ID);

        Map<String, Object> error = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, fieldError -> {
                    String message = fieldError.getDefaultMessage();
                    return isEmpty(message) ? "无错误提示" : message;
                }));

        log.warn("Validation error for [{}]:{}", ex.getParameter().getParameterType().getName(), error);

        RequestValidationException validationException = new RequestValidationException(error);
        ErrorRepresentation representation = new ErrorRepresentation(validationException, path, requestId);
        return new ResponseEntity<>(representation, new HttpHeaders(), valueOf(validationException.getError().getStatus()));
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<?> handleGeneralException(Throwable ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        String requestId = MDC.get(RequestIdMdcFilter.REQUEST_ID);
        log.error("Error occurred while access[{}]:", path, ex);

        SystemException systemException = new SystemException(ex);
        ErrorRepresentation representation = new ErrorRepresentation(systemException, path, requestId);
        return new ResponseEntity<>(representation, new HttpHeaders(), valueOf(systemException.getError().getStatus()));
    }
}
