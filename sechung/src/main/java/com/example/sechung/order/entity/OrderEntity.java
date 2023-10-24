package com.example.sechung.order.entity;

import com.example.sechung.delivery.entity.DeliveryEntity;
import com.example.sechung.global.entity.BaseEntity;
import com.example.sechung.member.entity.MemberEntity;
import com.example.sechung.order.entity.type.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.sechung.order_entity.entity.OrderItemEntity;

/**
 * OrderEntity.
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
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private MemberEntity member;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItemEntity> orderItems = new ArrayList<>();


  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "delivery_id")
  private DeliveryEntity delivery;

  private OrderStatus status;

  public void setMember(MemberEntity member) {
    this.member = member;
    member.getOrders().add(this);
  }

  public void addOrderItem(OrderItemEntity orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }

  public void setDelivery(DeliveryEntity delivery) {
    this.delivery = delivery;
    delivery.setOrder(this);
  }
}
