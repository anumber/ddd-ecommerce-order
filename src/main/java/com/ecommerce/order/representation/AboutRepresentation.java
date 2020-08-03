package com.ecommerce.order.representation;

import lombok.Value;

/**
 * <p>
 * </p>
 */
@Value
public class AboutRepresentation {
    String requestId;
    String appName;
    String buildNumber;
    String buildTime;
    String deployTime;
    String gitRevision;
    String gitBranch;
    String environment;
}
