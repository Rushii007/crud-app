/**
 * 
 */
package com.rushikesh.qp.assessment.java.service.impl;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushikesh.qp.assessment.java.dto.GroceryItemsDto;
import com.rushikesh.qp.assessment.java.entity.GroceryItems;
import com.rushikesh.qp.assessment.java.entity.StoreInventory;
import com.rushikesh.qp.assessment.java.repository.GroceryItemsRepository;
import com.rushikesh.qp.assessment.java.repository.StoreInventoryRepository;
import com.rushikesh.qp.assessment.java.service.GroceryItemsService;

/**
 * 
 */
@Service
public class GroceryItemsServiceImpl implements GroceryItemsService {

	@Autowired
	GroceryItemsRepository groceryItemsRepository;

	@Autowired
	StoreInventoryRepository storeInventoryRepository;

	@Override
	public GroceryItems addGroceryItems(GroceryItems groceryItems) {
		GroceryItems groceryItem = null;
		if (nonNull(groceryItems)) {
			if (groceryItems.getProductQuantity() > 0) {
				groceryItems.setProductAvailablity("In-Stock");
			} else {
				groceryItems.setProductAvailablity("Out-of-Stock");
			}
			if (groceryItems.getStoreInventory() != null && groceryItems.getStoreInventory().getInventoryId() != null
					&& groceryItems.getStoreInventory().getInventoryId() != 0) {
				setStoreInv(groceryItems);
			}
			groceryItem = groceryItemsRepository.save(groceryItems);
		}
		return groceryItem;
	}

	@Override
	public List<GroceryItems> getAllGroceryItems() {
		return groceryItemsRepository.findAll();
	}

	@Override
	public GroceryItems getGroceryItesById(Integer groceryItemId) {
		return groceryItemsRepository.findById(groceryItemId).orElse(null);
	}

	@Override
	public List<GroceryItems> getAvailableGroceryItems() {
		return groceryItemsRepository.findAllAvailableItems();
	}

	@Override
	public GroceryItems updateGroceryItems(GroceryItems groceryItems) {
		GroceryItems groceryItem = null;
		if (groceryItems.getProductQuantity() > 0) {
			groceryItems.setProductAvailablity("In-Stock");
		} else {
			groceryItems.setProductAvailablity("Out-of-Stock");
		}
		if (nonNull(groceryItems)) {
			if (groceryItems.getStoreInventory() != null && groceryItems.getStoreInventory().getInventoryId() != null
					&& groceryItems.getStoreInventory().getInventoryId() != 0) {
				setStoreInv(groceryItems);
			}
			if (groceryItems.getGroceryItemId() != null && groceryItems.getGroceryItemId() != 0) {
				GroceryItems updateItems = groceryItemsRepository.findById(groceryItems.getGroceryItemId())
						.orElse(null);
				if (nonNull(updateItems)) {
					groceryItems
							.setGroceryItemId(groceryItems.getGroceryItemId() == null ? updateItems.getGroceryItemId()
									: groceryItems.getGroceryItemId());
					groceryItems.setGroceryItemBrand(
							groceryItems.getGroceryItemBrand() == null ? updateItems.getGroceryItemBrand()
									: groceryItems.getGroceryItemBrand());
					groceryItems.setGroceryItemDesc(
							groceryItems.getGroceryItemDesc() == null ? updateItems.getGroceryItemDesc()
									: groceryItems.getGroceryItemDesc());
					groceryItems.setGroceryItemName(
							groceryItems.getGroceryItemName() == null ? updateItems.getGroceryItemName()
									: groceryItems.getGroceryItemName());
					groceryItems.setGroceryItemPrice(
							groceryItems.getGroceryItemPrice() == null ? updateItems.getGroceryItemPrice()
									: groceryItems.getGroceryItemPrice());
					groceryItems.setProductQuantity(
							groceryItems.getProductQuantity() == null ? updateItems.getProductQuantity()
									: groceryItems.getProductQuantity());
					if (groceryItems.getStoreInventory() != null
							&& groceryItems.getStoreInventory().getInventoryId() != null
							&& groceryItems.getStoreInventory().getInventoryId() != 0) {
						setStoreInv(groceryItems);
						groceryItem = groceryItemsRepository.save(groceryItems);
					} else {
						updateItems.setProductQuantity(groceryItems.getProductQuantity());
						if (groceryItems.getProductQuantity() > 0) {
							updateItems.setProductAvailablity("In-Stock");
						} else {
							updateItems.setProductAvailablity("Out-of-Stock");
						}
						setStoreInv(updateItems);
						groceryItem = groceryItemsRepository.save(updateItems);
					}
				}
			}
		}
		return groceryItem;
	}

	private void setStoreInv(GroceryItems groceryItems) {
		StoreInventory storeInv = storeInventoryRepository.findById(groceryItems.getStoreInventory().getInventoryId())
				.orElse(null);
		if (nonNull(storeInv) && nonNull(groceryItems.getStoreInventory())) {
			StoreInventory storeToUpdateInv = new StoreInventory();
			storeToUpdateInv.setInventoryId(
					groceryItems.getStoreInventory().getInventoryId() == null ? storeInv.getInventoryId()
							: groceryItems.getStoreInventory().getInventoryId());
			storeToUpdateInv.setInventoryLevel(
					groceryItems.getStoreInventory().getInventoryLevel() == null ? storeInv.getInventoryLevel()
							: groceryItems.getStoreInventory().getInventoryLevel());
			storeToUpdateInv.setInventoryLocation(
					groceryItems.getStoreInventory().getInventoryLocation() == null ? storeInv.getInventoryLocation()
							: groceryItems.getStoreInventory().getInventoryLocation());
			storeToUpdateInv.setInventoryName(
					groceryItems.getStoreInventory().getInventoryName() == null ? storeInv.getInventoryName()
							: groceryItems.getStoreInventory().getInventoryName());
			groceryItems.setStoreInventory(storeToUpdateInv);
		}
	}

	@Override
	public void deleteAllGroceryItems() {
		groceryItemsRepository.deleteAll();
	}

	@Override
	public void deleteGroceryItesById(Integer groceryItemId) {
		groceryItemsRepository.deleteById(groceryItemId);
	}

	@Override
	public List<GroceryItemsDto> bookMultipleItems(Integer itemId, Integer reqItemQuantity)
			throws CloneNotSupportedException {
		GroceryItems groceryItem = groceryItemsRepository.findById(itemId).orElse(null);
		GroceryItemsDto groceryItemsDto = new GroceryItemsDto();
		List<GroceryItemsDto> groceryItemsList = new ArrayList<>();
		if (nonNull(groceryItem) && nonNull(groceryItem.getProductQuantity()) 
				&& groceryItem.getProductQuantity() > 0 && reqItemQuantity <= groceryItem.getProductQuantity()) {
			groceryItemsRepository.updateQuantity(groceryItem.getProductQuantity() - reqItemQuantity, itemId);
			groceryItemsDto.setGroceryItemId(groceryItem.getGroceryItemId());
			groceryItemsDto.setGroceryItemName(groceryItem.getGroceryItemName());
			groceryItemsDto.setGroceryItemDesc(groceryItem.getGroceryItemDesc());
			groceryItemsDto.setGroceryItemBrand(groceryItem.getGroceryItemBrand());
			groceryItemsDto.setGroceryItemPrice(groceryItem.getGroceryItemPrice());
			for (int i = 0; i < reqItemQuantity; i++) {
				groceryItemsList.add((GroceryItemsDto) groceryItemsDto.clone());
			}
		}
		return groceryItemsList;
	}

}
