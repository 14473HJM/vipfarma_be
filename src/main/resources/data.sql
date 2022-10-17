INSERT INTO branch_office (id, name, location) VALUES (1, 'NORTE', 'Herrera y Guzman 966, Marques de Sobremonte.');
INSERT INTO branch_office (id, name, location) VALUES (2, 'CENTRO', 'Boulevard San Juan 966. Observatorio.');
INSERT INTO branch_office (id, name, location) VALUES (3, 'SUR', 'Av. Valparaiso 1453, Jardin.');

INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1, 1, 'cajero1@email.com', 'password', 'caja', 'CASHIER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (2, 1, 'deposito1@email.com', 'password', 'deposito', 'WAREHOUSE_MANAGER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (3, 1, 'admin@email.com', 'password', 'admin', 'ADMIN');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (4, 1, 'vendedor1@email.com', 'password', 'vendedor', 'SELLER');

INSERT INTO health_insurance (id, name) VALUES (1, 'OSDE');
INSERT INTO health_insurance (id, name) VALUES (2, 'SWISS MEDICAL');
INSERT INTO health_insurance (id, name) VALUES (3, 'MEDIFE');
INSERT INTO health_insurance (id, name) VALUES (4, 'SANCOR');

INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1, 1, 'OSDE 210');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (2, 1, 'OSDE 310');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (3, 1, 'OSDE 410');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (4, 2, 'SM 1000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (5, 2, 'SM 2000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (6, 2, 'SM 3000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (7, 3, 'MDF1');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (8, 3, 'MDF2');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (9, 3, 'MDF3');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (10, 4, 'Estudiantes');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (11, 4, 'Profecionales');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (12, 4, 'Familly');

INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (1, 'Herrera y Guzman 966, Marques de Sobremonte.', 'Deposito NORTE', 1);
INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (2, 'Boulevard San Juan 966. Observatorio.', 'Deposito CENTRO', 2);
INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (3, 'Av. Valparaiso 1453, Jardin.', 'Deposito SUR', 3);

INSERT INTO racks (id, name, warehouse_id) VALUES (1, '1A', 1);
INSERT INTO racks (id, name, warehouse_id) VALUES (2, '1B', 1);
INSERT INTO racks (id, name, warehouse_id) VALUES (3, '1C', 1);
INSERT INTO racks (id, name, warehouse_id) VALUES (4, '1D', 1);
INSERT INTO racks (id, name, warehouse_id) VALUES (5, '2A', 2);
INSERT INTO racks (id, name, warehouse_id) VALUES (6, '2B', 2);
INSERT INTO racks (id, name, warehouse_id) VALUES (7, '2C', 2);
INSERT INTO racks (id, name, warehouse_id) VALUES (8, '2D', 2);
INSERT INTO racks (id, name, warehouse_id) VALUES (9, '3A', 3);
INSERT INTO racks (id, name, warehouse_id) VALUES (10, '3B', 3);
INSERT INTO racks (id, name, warehouse_id) VALUES (11, '3C', 3);
INSERT INTO racks (id, name, warehouse_id) VALUES (12, '3D', 3);

INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1, 123456701, 'Laboratorio A', 'Ibuprofeno 400', true, 100);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (2, 123456702, 'Laboratorio A', 'Ibuprofeno 600', true, 200);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (3, 123456703, 'Laboratorio A', 'Ibuprofeno 800', true, 300);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (4, 123456704, 'Laboratorio B', 'Ibuprofeno 500', true, 150);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (5, 123456705, 'Laboratorio B', 'Ibuprofeno 1000', true, 500);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (6, 123456706, 'Laboratorio A', 'Tafirol 200', true, 100);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (7, 123456707, 'Laboratorio A', 'Tafirol 500', true, 200);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (8, 123456708, 'Laboratorio A', 'Tafirol 1000', true, 300);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (9, 123456709, 'Laboratorio B', 'Tafirol 500', true, 150);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (10, 123456710, 'Laboratorio B', 'Tafirol 1000', true, 500);

INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1, 150, 200, 1000, 1, 1, 1);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (2, 200, 200, 1000, 1, 2, 1);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (3, 900, 900, 1000, 1, 3, 1);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (4, 0, 0, 1000, 1, 4, 2);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (5, 25, 325, 1000, 1, 5, 2);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (6, 100, 200, 1000, 1, 6, 2);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (7, 200, 200, 1000, 1, 7, 3);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (8, 1000, 1000, 1000, 1, 8, 3);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (9, 1000, 1000, 1000, 1, 9, 3);

INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1, 150, CURRENT_DATE -100, CURRENT_DATE + 100, null, 500, 'ACTIVE', 1, 1);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (2, 50, CURRENT_DATE -100, CURRENT_DATE, CURRENT_DATE, 500, 'EXPIRED', 1, 1);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (3, 200, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1000, 'ACTIVE', 2, 2);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (4, 900, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1000, 'ACTIVE', 3, 3);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (5, 0, CURRENT_DATE -100, CURRENT_DATE + 30, null, 1000, 'INACTIVE', 4, 4);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (6, 25, CURRENT_DATE -45, CURRENT_DATE + 40, null, 500, 'ACTIVE', 5, 5);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (7, 300, CURRENT_DATE -90, CURRENT_DATE - 10, CURRENT_DATE-10, 500, 'EXPIRED', 5, 5);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (8, 100, CURRENT_DATE -100, CURRENT_DATE + 300, null, 500, 'ACTIVE', 6, 6);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (9, 100, CURRENT_DATE -100, CURRENT_DATE -100, null, 500, 'EXPIRED', 6, 6);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (10, 200, CURRENT_DATE -100, CURRENT_DATE +200, null, 1000, 'ACTIVE', 7, 7);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (11, 1000, CURRENT_DATE -10, CURRENT_DATE +600, null, 1000, 'ACTIVE', 8, 8);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (12, 1000, CURRENT_DATE -10, CURRENT_DATE +600, null, 1000, 'ACTIVE', 9, 9);

INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1, null, null, null, null, 1);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (2, null, null, null, null, 2);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (3, null, null, null, null, 3);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (4, null, null, null, null, 4);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (5, null, null, null, null, 5);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (6, null, null, null, null, 6);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (7, null, null, null, null, 7);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (8, null, null, null, null, 8);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (9, null, null, null, null, 9);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (10, null, null, null, null, 10);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (11, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 1);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (12, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 2);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (13, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 3);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (14, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 4);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (15, 'PERCENTAGE',CONVERT('0.20',DECIMAL(19,2)), 1, 1, 5);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (16, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 6);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (17, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 7);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (18, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 8);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (19, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 9);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (20, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1, 1, 10);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (21, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 1);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (22, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 2);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (23, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 3);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (24, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 4);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (25, 'PERCENTAGE',CONVERT('0.30',DECIMAL(19,2)), 1, 2, 5);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (26, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 6);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (27, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 7);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (28, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 8);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (29, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 9);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (30, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1, 2, 10);