DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS menu_items;

CREATE TABLE menu_items (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
                            item_type VARCHAR(20) NOT NULL,
                            calories INT,
                            volume_ml INT
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        customer_name VARCHAR(100) NOT NULL,
                        menu_item_id INT NOT NULL,
                        quantity INT NOT NULL DEFAULT 1,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Foreign Key
                        CONSTRAINT fk_menu_item
                            FOREIGN KEY (menu_item_id)
                                REFERENCES menu_items(id)
                                ON DELETE CASCADE
);

INSERT INTO menu_items (name, price, item_type, calories, volume_ml) VALUES
                                                                         ('Caesar Salad', 12.50, 'FOOD', 350, NULL),
                                                                         ('Cheese Burger', 15.00, 'FOOD', 800, NULL),
                                                                         ('Coca Cola', 2.50, 'DRINK', NULL, 500),
                                                                         ('Green Tea', 3.00, 'DRINK', NULL, 300);

INSERT INTO orders (customer_name, menu_item_id, quantity) VALUES
                                                               ('Murat', 1, 2),
                                                               ('Alibi', 3, 1);