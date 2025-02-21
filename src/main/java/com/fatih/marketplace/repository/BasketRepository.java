package com.fatih.marketplace.repository;

import com.fatih.marketplace.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, UUID> {
}
