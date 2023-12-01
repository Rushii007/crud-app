package com.rushikesh.qp.assessment.java.dto;

public class StoreInventoryDto {

	private Integer inventoryId;
	private String inventoryName;
	private Integer inventoryLevel;
	private String inventoryLocation;
	
	public StoreInventoryDto() {
		super();
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	public Integer getInventoryLevel() {
		return inventoryLevel;
	}

	public void setInventoryLevel(Integer inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}
	
}
