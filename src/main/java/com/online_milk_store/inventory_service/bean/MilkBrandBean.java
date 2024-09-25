package com.online_milk_store.inventory_service.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class MilkBrandBean {
	private int milkBrandId;
	private String milkBrandName;
	private String packaging;
	private String milkBrandAvailable;
	private MilkBrandInventoryBean milkBrandInventoryBean;
}
