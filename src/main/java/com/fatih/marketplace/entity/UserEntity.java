package com.fatih.marketplace.entity;

import com.fatih.marketplace.converter.JasyptAttributeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "users")
@SQLRestriction("record_status <> 'true'")
public class UserEntity extends BaseEntity {

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 345, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, length = 13, unique = true)
    private String phone;

    @Column(name = "password", nullable = false, length = 16)
    @Convert(converter = JasyptAttributeConverter.class)
    private String password;

    @Column(name = "favorite_product_count", nullable = false)
    private Integer favoriteProductCount;

    @Column(name = "address_count", nullable = false)
    private Integer addressCount;

    @Column(name = "campaign_count", nullable = false)
    private Integer campaignCount;

    @Column(name = "order_count", nullable = false)
    private Integer orderCount;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BasketEntity cart;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WalletEntity wallet;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<CampaignEntity> campaigns;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FavoriteEntity> favorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductEntity> products;
}