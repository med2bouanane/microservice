CREATE TABLE IF NOT EXISTS t_orders
(
    id           BIGSERIAL PRIMARY KEY,
    order_number VARCHAR(255),
    sku_code     VARCHAR(255),
    price        DECIMAL(19, 2),
    quantity     INTEGER
);