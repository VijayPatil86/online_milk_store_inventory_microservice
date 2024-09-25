package com.online_milk_store.inventory_service.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online_milk_store.inventory_service.entity.MilkBrandInventoryEntity;
import com.online_milk_store.inventory_service.repository.MilkBrandInventoryRepository;

@Service
@Transactional
public class InventoryService {
	final static private Logger LOGGER = LogManager.getLogger(InventoryService.class);

	@Autowired
	private MilkBrandInventoryRepository milkBrandInventoryRepository;

	@Transactional(readOnly = true)
	public List<String> checkInventoryMilkBrands(Map<String, String> queryParams) {
		LOGGER.debug("InventoryService.checkInventoryMilkBrands() --- START");
		LOGGER.info("InventoryService.checkInventoryMilkBrands() --- queryParams: " + queryParams);
		List<Integer> listMilkBrandIds = queryParams.keySet().stream()
				.map(key -> Integer.valueOf(key))
				.toList();
		List<MilkBrandInventoryEntity> listMilkBrandInventoryEntity =
				milkBrandInventoryRepository.findAllByMilkBrandEntityMilkBrandIdIn(listMilkBrandIds);
		List<String> listMilkBrandsInventoryStatus = listMilkBrandInventoryEntity.stream()
				.map(milkBrandInventoryEntity -> {
					String milkBrandInventoryStatus = null;
					if(milkBrandInventoryEntity.getCurrentQuantity() <= 0) {
						milkBrandInventoryStatus = milkBrandInventoryEntity.getMilkBrandEntity().getMilkBrandId() + "_" + "OOS";
					}
					int milkBrandQuantity =
							Integer.parseInt(queryParams.get(String.valueOf(milkBrandInventoryEntity.getMilkBrandEntity().getMilkBrandId())));
					if(milkBrandQuantity > milkBrandInventoryEntity.getCurrentQuantity()) {
						milkBrandInventoryStatus = milkBrandInventoryEntity.getMilkBrandEntity().getMilkBrandId() + "_" +
								milkBrandInventoryEntity.getCurrentQuantity();
					}
					return milkBrandInventoryStatus;
				})
				.filter(Objects::nonNull)
				.toList();
		LOGGER.info("InventoryService.checkInventoryMilkBrands() --- listMilkBrandsIdsOutOfStock: " + listMilkBrandsInventoryStatus);
		LOGGER.debug("InventoryService.checkInventoryMilkBrands() --- END");
		return listMilkBrandsInventoryStatus;
	}
}
