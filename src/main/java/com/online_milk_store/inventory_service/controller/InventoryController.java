package com.online_milk_store.inventory_service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_milk_store.inventory_service.service.InventoryService;

@CrossOrigin
@RestController
@RequestMapping("/inventory-service/inventory")
public class InventoryController {
	static final private Logger LOGGER = LogManager.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;
}
