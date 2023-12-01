/**
 * 
 */
package com.rushikesh.qp.assessment.java.controller;

import static com.rushikesh.qp.assessment.java.constants.ApiUrl.ADD_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.GET_ALL_ITEMS;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.GET_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.UPDATE_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.DELETE_ALL_ITEMS;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.DELETE_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.ADMIN;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.DATA;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.MESSAGE;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.SUCCESS;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_ADDED;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_NOT_ADDED;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_FOUND;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_NOT_FOUND;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_UPDATED;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_NOT_UPDATED;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_DELETED;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_NOT_DELETED;


import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.qp.assessment.java.dto.GroceryItemsDto;
import com.rushikesh.qp.assessment.java.entity.GroceryItems;
import com.rushikesh.qp.assessment.java.enums.ApiKey;
import com.rushikesh.qp.assessment.java.service.GroceryItemsService;
import com.rushikesh.qp.assessment.java.util.FunctionUtil;

/**
 * The java class AdminController
 * 
 * @author Rushikesh Chavan
 * @version 1.0
 */

@RestController
@RequestMapping(ADMIN)
public class AdminController {

	private static final Logger log = LogManager.getLogger(AdminController.class);
	
	@Autowired
	GroceryItemsService groceryItemsService;

	@PostMapping(ADD_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> addGroceryItems(@RequestBody GroceryItemsDto groceryItemsDto) {
		log.info("Enter into addGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		GroceryItems groceryItems = FunctionUtil.evalMapper(groceryItemsDto,GroceryItems.class).orElse(null);
		try {
			GroceryItems addedGroceryItems = groceryItemsService.addGroceryItems(groceryItems);
			if(Objects.nonNull(addedGroceryItems)) {
				map.put(DATA, addedGroceryItems);
				map.put(SUCCESS, true);
				map.put(MESSAGE, RECORD_ADDED);
			} else {
				map.put(SUCCESS, false);
				map.put(MESSAGE, RECORD_NOT_ADDED);
			}
		} catch(Exception e) {
			log.error("Exception while adding item, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_ADDED);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from addGroceryItems() function...");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping(GET_ALL_ITEMS)
	public ResponseEntity<EnumMap<ApiKey, Object>> getAllGroceryItems() {
		log.info("Enter into getAllGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			List<GroceryItems> allGroceryItems = groceryItemsService.getAllGroceryItems();
			if (!allGroceryItems.isEmpty()) {
				map.put(DATA, allGroceryItems);
				map.put(SUCCESS, true);
				map.put(MESSAGE, RECORD_FOUND);
			} else {
				map.put(SUCCESS, false);
				map.put(MESSAGE, RECORD_NOT_FOUND);
			}
		} catch(Exception e) {
			log.error("Exception while getting all item, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_FOUND);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from getAllGroceryItems() function...");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping(GET_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> getGroceryItemById(@PathVariable Integer groceryItemId) {
		log.info("Enter into getGroceryItemById() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			GroceryItems groceryItem = groceryItemsService.getGroceryItesById(groceryItemId);
			if(Objects.nonNull(groceryItem)) {
				map.put(DATA, groceryItem);
				map.put(SUCCESS, true);
				map.put(MESSAGE, RECORD_FOUND);
			} else {
				map.put(SUCCESS, false);
				map.put(MESSAGE, RECORD_NOT_FOUND);
			}
		} catch(Exception e) {
			log.error("Exception while getting item by id, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_FOUND);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from getGroceryItemById() function...");
		return ResponseEntity.ok(map);
	}
	
	@PutMapping(UPDATE_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> updateGroceryItems(@RequestBody GroceryItemsDto groceryItemsDto) {
		log.info("Enter into updateGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		GroceryItems groceryItems = FunctionUtil.evalMapper(groceryItemsDto,GroceryItems.class).orElse(null);
		try {
			GroceryItems updatedGroceryItem = groceryItemsService.updateGroceryItems(groceryItems);
			if (Objects.nonNull(updatedGroceryItem)) {
				map.put(DATA, updatedGroceryItem);
				map.put(SUCCESS, true);
				map.put(MESSAGE, RECORD_UPDATED);
			} else {
				map.put(SUCCESS, false);
				map.put(MESSAGE, RECORD_NOT_UPDATED);
			}
		} catch(Exception e) {
			log.error("Exception while updating item, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_UPDATED);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from updateGroceryItems() function...");
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping(DELETE_ALL_ITEMS)
	public ResponseEntity<EnumMap<ApiKey, Object>> deleteAllGroceryItems() {
		log.info("Enter into deleteAllGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			groceryItemsService.deleteAllGroceryItems();
			map.put(SUCCESS, true);
			map.put(MESSAGE, RECORD_DELETED);
		} catch(Exception e) {
			log.error("Exception while deleting all items, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_DELETED);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from deleteAllGroceryItems() function...");
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping(DELETE_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> deleteGroceryItemById(@PathVariable Integer groceryItemId) {
		log.info("Enter into deleteGroceryItemById() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			groceryItemsService.deleteGroceryItesById(groceryItemId);
			map.put(SUCCESS, true);
			map.put(MESSAGE, RECORD_DELETED);
		} catch(Exception e) {
			log.error("Exception while deleting item by id, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, RECORD_NOT_DELETED);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from deleteGroceryItemById() function...");
		return ResponseEntity.ok(map);
	}
}
