CREATE TABLE grocery_product(
	product_id INT AUTO_INCREMENT,
    inventory_id INT,
    product_name VARCHAR(50),
    product_desc VARCHAR(200),
    product_price DECIMAL(5,2),  
    product_brand VARCHAR(50),
    product_availablity VARCHAR(20),
    product_quantity INT,
    PRIMARY KEY (product_id),
    FOREIGN KEY (inventory_id) REFERENCES store_inventory(inventory_id)
);

CREATE TABLE store_inventory(
	inventory_id INT AUTO_INCREMENT,
    inventory_name VARCHAR(50),
    inventory_level int,
    inventory_location VARCHAR(50),
    PRIMARY KEY (inventory_id)
);