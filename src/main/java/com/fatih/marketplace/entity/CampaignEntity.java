package com.fatih.marketplace.entity;

import com.fatih.marketplace.enums.CampaignType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@SQLRestriction("record_status <> 'true'")
@Table(name = "campaigns")
public class CampaignEntity extends BaseEntity {

    @Column(name = "campaign_name", nullable = false, length = 50)
    private String campaignName;

    @Column(name = "campaign_description", nullable = false, length = 500)
    private String campaignDescription;

    @Column(name = "campaign_code", length = 10, nullable = false, unique = true)
    private String campaignCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "campaign_type", nullable = false, length = 10, unique = true)
    private CampaignType campaignType;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "campaign", fetch = FetchType.LAZY)
    private List<BasketEntity> carts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "campaign_user",
            joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<UserEntity> users;
}