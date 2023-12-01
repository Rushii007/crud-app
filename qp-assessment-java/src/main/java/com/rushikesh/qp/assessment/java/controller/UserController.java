/**
 * 
 */
package com.rushikesh.qp.assessment.java.controller;

import static com.rushikesh.qp.assessment.java.constants.ApiUrl.BOOK_MULTIPLE_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.GET_AVAILABLE_ITEM;
import static com.rushikesh.qp.assessment.java.constants.ApiUrl.USER;
import static com.rushikesh.qp.assessment.java.constants.Constants.ITEM_CANNOTBE_BOOK;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_FOUND;
import static com.rushikesh.qp.assessment.java.constants.Constants.RECORD_NOT_FOUND;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.DATA;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.MESSAGE;
import static com.rushikesh.qp.assessment.java.enums.ApiKey.SUCCESS;

import java.util.EnumMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.qp.assessment.java.dto.GroceryItemsDto;
import com.rushikesh.qp.assessment.java.entity.GroceryItems;
import com.rushikesh.qp.assessment.java.enums.ApiKey;
import com.rushikesh.qp.assessment.java.service.GroceryItemsService;

/**
 * 
 */

@RequestMapping(USER)
@RestController
public class UserController {
	
	private static final Logger log = LogManager.getLogger(UserController.class);
	
	@Autowired
	GroceryItemsService groceryItemsService;

	@GetMapping(GET_AVAILABLE_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> getAllAvaibleItems() {
		log.info("Enter into getAllGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			List<GroceryItems> allGroceryItems = groceryItemsService.getAvailableGroceryItems();
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
	
	@GetMapping(BOOK_MULTIPLE_ITEM)
	public ResponseEntity<EnumMap<ApiKey, Object>> bookMultipleItemInSingleOrder(@PathVariable Integer itemId,
			@RequestParam("requireItemQuantity") Integer requireItemQuantity) {
		log.info("Enter into getAllGroceryItems() function...");
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			List<GroceryItemsDto> allGroceryItems = groceryItemsService.bookMultipleItems(itemId,requireItemQuantity);
			if (!allGroceryItems.isEmpty()) {
				map.put(DATA, allGroceryItems);
				map.put(SUCCESS, true);
				map.put(MESSAGE, "Required Item Quantity: "+ requireItemQuantity +" is booked.");
			} else {
				map.put(SUCCESS, false);
				map.put(MESSAGE, ITEM_CANNOTBE_BOOK);
			}
		} catch(Exception e) {
			log.error("Exception while getting all item, {}",e.getMessage());
			map.put(SUCCESS, false);
			map.put(MESSAGE, ITEM_CANNOTBE_BOOK);
			return ResponseEntity.badRequest().body(map);
		}
		log.info("Exiting from getAllGroceryItems() function...");
		return ResponseEntity.ok(map);
	}
}
