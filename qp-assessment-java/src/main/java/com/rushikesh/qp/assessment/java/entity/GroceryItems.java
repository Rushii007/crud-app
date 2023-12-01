/**
 * 
 */
package com.rushikesh.qp.assessment.java.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 */

@Entity
@Table(name = "grocery_product")
public class GroceryItems {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	private Integer groceryItemId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private StoreInventory storeInventory;
	
	@Column(name = "product_name", nullable = false, length = 50)
	private String groceryItemName;
	
	@Column(name = "product_desc", nullable = false, length = 200)
	private String groceryItemDesc;
	
	@Column(name = "product_price", nullable = false)
	private Double groceryItemPrice;
	
	@Column(name = "product_brand", nullable = false, length = 50)
	private String groceryItemBrand;
	
	@Column(name = "product_availablity", nullable = false, length = 20)
	private String productAvailablity;
	
	@Column(name = "product_quantity", nullable = false)
	private Integer productQuantity;
	
	public GroceryItems() {
		super();
	}
	
	public StoreInventory getStoreInventory() {
		return storeInventory;
	}

	public void setStoreInventory(StoreInventory storeInventory) {
		this.storeInventory = storeInventory;
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

	public String getProductAvailablity() {
		return productAvailablity;
	}

	public void setProductAvailablity(String productAvailablity) {
		this.productAvailablity = productAvailablity;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
