package com.ecommerce.order.common.domain.model;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * </p>
 */
public class DomainEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DomainEvent(Object source) {
        super(source);
    }
}
