package com.rushikesh.qp.assessment.java.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "store_inventory")
public class StoreInventory {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id", unique = true, nullable = false)
	private Integer inventoryId;
	
	@Column(name = "inventory_name", nullable = false, length = 50)
	private String inventoryName;
	
	@Column(name = "inventory_location", nullable = false, length = 50)
	private String inventoryLocation;
	
	@Column(name = "inventory_level", nullable = false)
	private Integer inventoryLevel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "storeInventory", cascade = CascadeType.ALL)
	private List<GroceryItems> groceryItemsList;

	public StoreInventory() {
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

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

	public List<GroceryItems> getGroceryItemsList() {
		return groceryItemsList;
	}

	public void setGroceryItemsList(List<GroceryItems> groceryItemsList) {
		this.groceryItemsList = groceryItemsList;
	}

	public Integer getInventoryLevel() {
		return inventoryLevel;
	}

	public void setInventoryLevel(Integer inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}
	
}
