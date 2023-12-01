/**
 * 
 */
package com.rushikesh.qp.assessment.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.qp.assessment.java.entity.StoreInventory;

/**
 * 
 */
@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Integer>{

}
