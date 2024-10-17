DROP DATABASE IF EXISTS schooldb;
CREATE DATABASE schooldb;
USE schooldb;

CREATE TABLE clients (
                         id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name_client varchar(45) DEFAULT NULL,
                         address varchar(45) DEFAULT NULL,
                         age int DEFAULT '0',
                         email varchar(45) DEFAULT NULL
);

CREATE TABLE products (
                          id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          product_name varchar(45) DEFAULT NULL,
                          details varchar(400) DEFAULT NULL,
                          quantity_available int DEFAULT 0,
                          price float DEFAULT 0
);

CREATE TABLE orders (
                        id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        product_id int,
                        client_id int,
                        quantity int,
                        FOREIGN KEY(product_id) REFERENCES products(id),
                        FOREIGN KEY(client_id) REFERENCES clients(id)
);

CREATE TABLE bill (
                      bill_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      client_id int,
                      product_id int,
                      product_price float,
                      quantity int,
                      total float
);

INSERT INTO clients (name_client, address, age, email) VALUES
                                                           ('Ioana Ionescu', 'Str.Principala', 35, 'ana.ionescu@gmail.com'),
                                                           ('Ioana Calinescu', 'Str.Luca Caragiale', 19, 'ioana.calinescu@gmail.com'),
                                                           ('Ana-Maria', 'Cluj-Napoca, Str. Flamingo', 20, 'ana.maria@gmail.com'),
                                                           ('Risteiu Ioana', 'Str. Principala, nr.208', 20, 'ioana.risteiu@gmail.com'),
                                                           ('Andreea Popovici', 'Targu Jiu', 20, 'andreea.popovici@gmail.com'),
                                                           ('Raluca Andronescu', 'Baia de Fier', 21, 'raluca.andronescu@gmail.com'),
                                                           ('Gabriela Pirvulescu', 'Bilteni', 20, 'gabriela.pirvulescu@gmail.com'),
                                                           ('Oana Lihaciu', 'Simeria', 20, 'oana.lihaciu@gmail.com');

INSERT INTO products (product_name, details, quantity_available, price) VALUES
                                                                            ('Banana', 'Fruct', 30, 1.0),
                                                                            ('Mar', 'Fruct', 40, 1.0),
                                                                            ('Ciocolata', 'sud', 30, 14.0);

