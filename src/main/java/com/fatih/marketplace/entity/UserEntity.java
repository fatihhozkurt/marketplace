package com.fatih.marketplace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@SQLRestriction("record_status <> 'true'")
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false, length = 33)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 345, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, length = 13, unique = true)
    private String phone;

    @Column(name = "address", nullable = false, length = 255, unique = true)
    private String address;
}