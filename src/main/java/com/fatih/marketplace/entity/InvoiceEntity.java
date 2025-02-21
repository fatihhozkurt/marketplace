package com.fatih.marketplace.entity;

import com.fatih.marketplace.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "invoices")
public class InvoiceEntity extends BaseEntity {

    @Column(name = "invoice_number", nullable = false, unique = true, length = 50)
    private String invoiceNumber;

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime invoiceDate;

    @Column(name = "total_amount", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "billing_address", nullable = false, length = 255)
    private String billingAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_status", nullable = false, length = 20)
    private InvoiceStatus invoiceStatus;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    private OrderEntity order;
}
