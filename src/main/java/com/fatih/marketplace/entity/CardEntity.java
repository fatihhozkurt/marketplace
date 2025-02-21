package com.fatih.marketplace.entity;

import com.fatih.marketplace.converter.JasyptAttributeConverter;
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
@SQLRestriction("record_status <> 'true'")
@Table(name = "cards")
public class CardEntity extends BaseEntity {

    @Column(name = "card_name", nullable = false, length = 30)
    private String cardName;

    @Convert(converter = JasyptAttributeConverter.class)
    @Column(name = "card_holder_first_name", nullable = false, length = 50)
    private String cardHolderFirstName;

    @Convert(converter = JasyptAttributeConverter.class)
    @Column(name = "card_holder_last_name", nullable = false, length = 50)
    private String cardHolderLastName;

    @Convert(converter = JasyptAttributeConverter.class)
    @Column(name = "card_number", nullable = false, length = 19)
    private String cardNumber;

    @Convert(converter = JasyptAttributeConverter.class)
    @Column(name = "card_company", nullable = false, length = 30)
    private String cardCompany;

    @Column(name = "expiry_date", nullable = false)
    @Convert(converter = JasyptAttributeConverter.class)
    private String expiryDate;

    @Convert(converter = JasyptAttributeConverter.class)
    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false)
    private WalletEntity wallet;
}
