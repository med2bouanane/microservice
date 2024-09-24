CREATE TABLE t_inventories
(
    id           BIGSERIAL PRIMARY KEY,
    sku_code     VARCHAR(255),
    price        DECIMAL(19, 2),
    quantity     INTEGER
);