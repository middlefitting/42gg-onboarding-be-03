package com.example.sechung.item.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * BookEntity.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/24
 */
@Entity(name = "book")
@DiscriminatorValue("B")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BookEntity extends ItemEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String author;
  private String isbn;
}
