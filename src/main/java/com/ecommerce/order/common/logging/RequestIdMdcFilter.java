package com.ecommerce.order.common.logging;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.*;


/**
 * <p>
 * </p>
 */
@WebFilter("/*")
public class RequestIdMdcFilter implements Filter {

    public static final String HEADER_X_REQUEST_ID = "HEADER_X_REQUEST_ID";
    public static final String REQUEST_ID = "requestId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //request id in header may come from Gateway, eg. Nginx
        String headerRequestId = req.getHeader(HEADER_X_REQUEST_ID);
        MDC.put(REQUEST_ID, isEmpty(headerRequestId) ? UUID.randomUUID().toString() : headerRequestId);
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove(REQUEST_ID);
        }
    }
}
