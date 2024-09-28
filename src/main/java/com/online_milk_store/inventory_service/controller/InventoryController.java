package com.online_milk_store.inventory_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online_milk_store.inventory_service.service.InventoryService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/inventory-service/inventory")
public class InventoryController {
	static final private Logger LOGGER = LogManager.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/milk-brand")
	public ResponseEntity<Map<String, Object>> checkInventoryMilkBrands(@RequestParam Map<String, String> queryParams,
			HttpServletRequest request) {
		LOGGER.debug("InventoryController.checkInventoryMilkBrands() --- START");
		LOGGER.info("InventoryController.checkInventoryMilkBrands() --- queryParams: " + queryParams);
		Map<String, Object> mapResponse = new HashMap<>();
		List<String> listMilkBrandsIdsOutOfStock = inventoryService.checkInventoryMilkBrands(queryParams);
		mapResponse.put("listMilkBrandsIdsOutOfStock", listMilkBrandsIdsOutOfStock);
		mapResponse.put("inventory service port: ", request.getLocalPort());
		LOGGER.info("InventoryController.checkInventoryMilkBrands() --- listMilkBrandsIdsOutOfStock: " + listMilkBrandsIdsOutOfStock);
		LOGGER.debug("InventoryController.checkInventoryMilkBrands() --- END");
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}

	/*** Exception handling section ***/
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Void> handleRuntimeException(RuntimeException runtimeException) {
		LOGGER.debug("InventoryController.handleRuntimeException() --- START");
		LOGGER.info("InventoryController.handleRuntimeException() --- runtimeException: " + runtimeException.getMessage());
		LOGGER.debug("InventoryController.handleRuntimeException() --- END");
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
