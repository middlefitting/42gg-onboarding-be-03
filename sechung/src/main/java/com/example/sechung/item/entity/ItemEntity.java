package com.example.sechung.item.entity;

import com.example.sechung.category.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * ItemEntity.
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
@Table(name = "item")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ItemEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "item_id")
  private Long id;

  private String name;

  private int price;

  private int stockQuantity;

  @ManyToMany(mappedBy = "items")
  private List<CategoryEntity> categories = new ArrayList<>();
}