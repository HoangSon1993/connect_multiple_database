CREATE DATABASE db_primary;
USE db_primary;

CREATE TABLE `product`
(
    id    int auto_increment primary key,
    name  varchar(50)    not null,
    price DECIMAL(10, 2) not null
);

CREATE DATABASE db_secondary;
USE db_secondary;

CREATE TABLE `order`
(
    id          int auto_increment primary key,
    product_id  int            not null,
    quantity    int            not null,
    total_price DECIMAL(10, 2) not null
);

