package com.example.sechung.item.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

/**
 * AlbumEntity.
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
@DiscriminatorValue("A")
@Getter
public class AlbumEntity extends ItemEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String artist;
  private String etc;
}
