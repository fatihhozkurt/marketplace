package com.fatih.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "addresses")
@SQLRestriction("record_status <> 'true'")
public class AddressEntity extends BaseEntity {

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "district", nullable = false, length = 50)
    private String district;

    @Column(name = "neighbourhood", nullable = false, length = 100)
    private String neighbourhood;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "apartment", length = 100)
    private String apartment;

    @Column(name = "apartment_number", length = 20)
    private String apartmentNumber;

    @Column(name = "zip_code", length = 20)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
}