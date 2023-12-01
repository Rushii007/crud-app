package com.rushikesh.qp.assessment.java.constants;

public class ApiUrl {

	public ApiUrl() {
		super();
	}

	public static final String ADMIN = "/admin/groceryStore";
	public static final String USER = "/user/groceryStore";

	public static final String ADD_ITEM = "/addItems";
	public static final String GET_ALL_ITEMS = "/getAllItems";
	public static final String GET_ITEM = "/getItems/{groceryItemId}";
	public static final String GET_AVAILABLE_ITEM = "/getAvailableItems";
	public static final String BOOK_MULTIPLE_ITEM = "/bookMultipleItems/{itemId}";
	public static final String UPDATE_ITEM = "/updateItem";
	public static final String DELETE_ALL_ITEMS = "/deleteAllItems";
	public static final String DELETE_ITEM = "/deleteItem/{groceryItemId}";
	
}
