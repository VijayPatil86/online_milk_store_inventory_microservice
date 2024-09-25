package com.online_milk_store.inventory_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_milk_store.inventory_service.entity.MilkBrandInventoryEntity;

public interface MilkBrandInventoryRepository extends JpaRepository<MilkBrandInventoryEntity, Integer> {
	List<MilkBrandInventoryEntity> findAllByMilkBrandEntityMilkBrandIdIn(List<Integer> milkBrandIds);
}
