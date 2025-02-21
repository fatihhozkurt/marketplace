package com.fatih.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "categories")
@SQLRestriction("record_status <> 'true'")
public class CategoryEntity extends BaseEntity {

    @Column(name = "category_name", length = 50, unique = true, nullable = false)
    private String categoryName;

    @Column(name = "product_count", nullable = false)
    private Long productCount;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductEntity> products;
}