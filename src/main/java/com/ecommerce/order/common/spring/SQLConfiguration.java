package com.ecommerce.order.common.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * </p>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class SQLConfiguration {
}
