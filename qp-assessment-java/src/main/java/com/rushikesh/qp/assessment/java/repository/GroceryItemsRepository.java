/**
 * 
 */
package com.rushikesh.qp.assessment.java.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rushikesh.qp.assessment.java.entity.GroceryItems;

/**
 * 
 */
@Repository
public interface GroceryItemsRepository extends JpaRepository<GroceryItems, Integer> {

	@Query(value = "SELECT * FROM grocery_product WHERE product_availablity = 'In-Stock' AND product_quantity > 0", nativeQuery = true)
	public List<GroceryItems> findAllAvailableItems();

	@Modifying
	@Transactional
	@Query(value = "UPDATE grocery_product SET product_quantity = :quantity,  product_availablity = IF(:quantity > 0, 'In-Stock', 'Out-of-Stock') WHERE product_id = :itemId", nativeQuery = true)
	public void updateQuantity(@Param("quantity") Integer quantity, @Param("itemId") Integer itemId);
}
