/**
 * 
 */
package com.rushikesh.qp.assessment.java.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
public class GroceryItemsDto implements Cloneable{

	private Integer groceryItemId;
	private String groceryItemName;
	private String groceryItemDesc;
	private Double groceryItemPrice;
	private String groceryItemBrand;
	@JsonIgnore
	private StoreInventoryDto storeInventory;
	@JsonIgnore
	private Integer productQuantity;

	public GroceryItemsDto() {
		super();
	}

	public Integer getGroceryItemId() {
		return groceryItemId;
	}

	public void setGroceryItemId(Integer groceryItemId) {
		this.groceryItemId = groceryItemId;
	}

	public String getGroceryItemName() {
		return groceryItemName;
	}

	public void setGroceryItemName(String groceryItemName) {
		this.groceryItemName = groceryItemName;
	}

	public String getGroceryItemDesc() {
		return groceryItemDesc;
	}

	public void setGroceryItemDesc(String groceryItemDesc) {
		this.groceryItemDesc = groceryItemDesc;
	}

	public Double getGroceryItemPrice() {
		return groceryItemPrice;
	}

	public void setGroceryItemPrice(Double groceryItemPrice) {
		this.groceryItemPrice = groceryItemPrice;
	}

	public String getGroceryItemBrand() {
		return groceryItemBrand;
	}

	public void setGroceryItemBrand(String groceryItemBrand) {
		this.groceryItemBrand = groceryItemBrand;
	}

	public StoreInventoryDto getStoreInventory() {
		return storeInventory;
	}

	public void setStoreInventory(StoreInventoryDto storeInventory) {
		this.storeInventory = storeInventory;
	}

 	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
}
