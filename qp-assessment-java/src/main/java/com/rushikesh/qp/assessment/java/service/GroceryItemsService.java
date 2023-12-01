/**
 * 
 */
package com.rushikesh.qp.assessment.java.service;

import java.util.List;

import com.rushikesh.qp.assessment.java.dto.GroceryItemsDto;
import com.rushikesh.qp.assessment.java.entity.GroceryItems;

/**
 * 
 */
public interface GroceryItemsService {

	public GroceryItems addGroceryItems(GroceryItems groceryItems);
	public List<GroceryItems> getAllGroceryItems();
	public GroceryItems getGroceryItesById(Integer groceryItemId);
	public List<GroceryItems> getAvailableGroceryItems();
	public GroceryItems updateGroceryItems(GroceryItems groceryItems);
	public void deleteAllGroceryItems();
	public void deleteGroceryItesById(Integer groceryItemId);
	public List<GroceryItemsDto> bookMultipleItems(Integer itemId, Integer reqItemQuantity) throws CloneNotSupportedException;
}
