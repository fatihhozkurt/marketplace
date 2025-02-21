package com.fatih.marketplace.entity;

import com.fatih.marketplace.enums.CartStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "baskets")
public class BasketEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "cart_status", nullable = false, length = 10)
    private CartStatus cartStatus;

    @Column(name = "item_count", nullable = false)
    private Integer itemCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    private CampaignEntity campaign;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItems;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private OrderEntity order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
}