package com.ecommerce.order.common.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * <p>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class ConcurrencyEntity extends DomainEntity {
    @Version
    protected int concurrencyVersion;
}
