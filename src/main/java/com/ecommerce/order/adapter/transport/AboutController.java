package com.ecommerce.order.adapter.transport;

import com.ecommerce.order.common.logging.RequestIdMdcFilter;
import com.ecommerce.order.representation.AboutRepresentation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * <p>
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(value = "/about")
public class AboutController {
    //now
    private ZonedDateTime deployTime = ZonedDateTime.now();

    private Environment environment;

    public AboutController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public AboutRepresentation about() {
        String buildNumber = environment.getProperty("buildNumber");
        String buildTime = environment.getProperty("buildTime");
        String gitRevision = environment.getProperty("gitRevision");
        String gitBranch = environment.getProperty("gitBranch");
        String appName = environment.getProperty("appName");
        String activeProfiles = Arrays.toString(environment.getActiveProfiles());
        String deployTime = this.deployTime.toString();
        String requestId = MDC.get(RequestIdMdcFilter.REQUEST_ID);
        return new AboutRepresentation(
                requestId,
                appName,
                buildNumber,
                buildTime,
                deployTime,
                gitRevision,
                gitBranch,
                activeProfiles);
    }

}
