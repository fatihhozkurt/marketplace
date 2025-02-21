package com.fatih.marketplace.entity;

import com.fatih.marketplace.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@SQLRestriction("record_status <> 'true'")
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false, length = 10)
    private OrderStatus orderStatus;

    @Column(name = "order_date", nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @Column(name = "cancel_date", updatable = false)
    private LocalDateTime cancelDate;

    @Column(name = "order_note", nullable = false, length = 200)
    private String orderNote;

    @Column(name = "order_amount", nullable = false, precision = 6, scale = 2)
    private BigDecimal orderAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
    private InvoiceEntity invoice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private BasketEntity cart;
}
