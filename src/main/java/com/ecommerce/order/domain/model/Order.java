package com.ecommerce.order.domain.model;

import com.ecommerce.order.common.domain.model.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "_order")
@DynamicInsert
@DynamicUpdate
public class Order extends DomainEntity {
    private String name;
    private String comment;
}
