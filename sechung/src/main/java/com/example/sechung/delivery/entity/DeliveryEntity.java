package com.example.sechung.delivery.entity;

import com.example.sechung.delivery.entity.type.DeliveryStatus;
import com.example.sechung.global.type.Address;
import com.example.sechung.order.entity.OrderEntity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;

/**
 * DeliveryEntity.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/24
 */
@Entity
@Table(name = "delivery")
@Getter
public class DeliveryEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
  private OrderEntity order;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;

  public void setOrder(OrderEntity orderEntity) {
    this.order = orderEntity;
  }
}
