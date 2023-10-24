package com.example.sechung.category.entity;

import com.example.sechung.item.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * CategoryEntity.
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
@Table(name = "category")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class CategoryEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "category_item",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id")
  )
  private List<ItemEntity> items = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private CategoryEntity parent;

  @OneToMany(mappedBy = "parent")
  private List<CategoryEntity> child = new ArrayList<>();

  public void addChildCategory(CategoryEntity child) {
    this.child.add(child);
    child.setParent(this);
  }

  private void setParent(CategoryEntity categoryEntity) {
    this.parent = categoryEntity;
  }
}
