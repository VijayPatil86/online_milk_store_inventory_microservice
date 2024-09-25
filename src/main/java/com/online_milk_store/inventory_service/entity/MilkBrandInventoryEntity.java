package com.online_milk_store.inventory_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "MILK_BRAND_INVENTORY")
public class MilkBrandInventoryEntity {
	@Column(name = "INVENTORY_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventotyId;

	@Column(name = "CURRENT_QUANTITY")
	private int currentQuantity;

	@Column(name = "MINIMUM_QUANTITY")
	private int minimumQuantity;

	@Column(name = "CURRENT_BUY_PRICE")
	private float currentPurchasePrice;

	@Column(name = "CURRENT_SELL_PRICE")
	private float currentSellPrice;

	@Column(name = "OUT_OF_STOCK")
	private String outOfStock;

	@OneToOne
	@JoinColumn(name = "MILK_BRAND_ID")
	private MilkBrandEntity milkBrandEntity;

	@Override
	public String toString() {
		return "MilkBrandInventoryEntity [inventotyId=" + inventotyId + ", currentQuantity=" + currentQuantity
				+ ", minimumQuantity=" + minimumQuantity + ", currentPurchasePrice=" + currentPurchasePrice
				+ ", currentSellPrice=" + currentSellPrice + ", outOfStock=" + outOfStock + ", milkBrandEntity="
				+ milkBrandEntity + "]";
	}
}
