package com.online_milk_store.inventory_service.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online_milk_store.inventory_service.repository.MilkBrandInventoryRepository;

@Service
@Transactional
public class InventoryService {
	final static private Logger LOGGER = LogManager.getLogger(InventoryService.class);

	@Autowired
	private MilkBrandInventoryRepository milkBrandInventoryRepository;
}
