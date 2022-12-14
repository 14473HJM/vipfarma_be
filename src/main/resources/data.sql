INSERT INTO branch_office (id, name, location) VALUES (1001, 'NORTE', 'Herrera y Guzman 966, Marques de Sobremonte.');
INSERT INTO branch_office (id, name, location) VALUES (1002, 'CENTRO', 'Boulevard San Juan 966. Observatorio.');
INSERT INTO branch_office (id, name, location) VALUES (1003, 'SUR', 'Av. Valparaiso 1453, Jardin.');

INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1001, 1001, 'cajero1@email.com', 'password', 'caja01', 'CASHIER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1002, 1001, 'cajero2@email.com', 'password', 'caja02', 'CASHIER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1003, 1001, 'cajero3@email.com', 'password', 'caja03', 'CASHIER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1004, 1001, 'deposito1@email.com', 'password', 'deposito01', 'WAREHOUSE_MANAGER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1005, 1001, 'admin@email.com', 'password', 'admin', 'ADMIN');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1006, 1001, 'vendedor1@email.com', 'password', 'vendedor01', 'SELLER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1007, 1001, 'vendedor2@email.com', 'password', 'vendedor02', 'SELLER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1008, 1001, 'vendedor3@email.com', 'password', 'vendedor03', 'SELLER');

INSERT INTO health_insurance (id, name) VALUES (1, 'SIN OBRA SOCIAL');
INSERT INTO health_insurance (id, name) VALUES (1001, 'OSDE');
INSERT INTO health_insurance (id, name) VALUES (1002, 'SWISS MEDICAL');
INSERT INTO health_insurance (id, name) VALUES (1003, 'MEDIFE');
INSERT INTO health_insurance (id, name) VALUES (1004, 'SANCOR');

INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1, 1, 'SIN PLAN');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1001, 1001, 'OSDE 210');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1002, 1001, 'OSDE 310');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1003, 1001, 'OSDE 410');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1004, 1002, 'SM 1000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1005, 1002, 'SM 2000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1006, 1002, 'SM 3000');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1007, 1003, 'MDF1');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1008, 1003, 'MDF2');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1009, 1003, 'MDF3');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1010, 1004, 'Estudiantes');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1011, 1004, 'Profesionales');
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1012, 1004, 'Familly');

INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (1001, 'Herrera y Guzman 966, Marques de Sobremonte.', 'Deposito NORTE', 1001);
INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (1002, 'Boulevard San Juan 966. Observatorio.', 'Deposito CENTRO', 1002);
INSERT INTO warehouses (id, location, name, branch_office_id) VALUES (1003, 'Av. Valparaiso 1453, Jardin.', 'Deposito SUR', 1003);

INSERT INTO racks (id, name, warehouse_id) VALUES (1001, '1A', 1001);
INSERT INTO racks (id, name, warehouse_id) VALUES (1002, '1B', 1001);
INSERT INTO racks (id, name, warehouse_id) VALUES (1003, '1C', 1001);
INSERT INTO racks (id, name, warehouse_id) VALUES (1004, '1D', 1001);
INSERT INTO racks (id, name, warehouse_id) VALUES (1005, '2A', 1002);
INSERT INTO racks (id, name, warehouse_id) VALUES (1006, '2B', 1002);
INSERT INTO racks (id, name, warehouse_id) VALUES (1007, '2C', 1002);
INSERT INTO racks (id, name, warehouse_id) VALUES (1008, '2D', 1002);
INSERT INTO racks (id, name, warehouse_id) VALUES (1009, '3A', 1003);
INSERT INTO racks (id, name, warehouse_id) VALUES (1010, '3B', 1003);
INSERT INTO racks (id, name, warehouse_id) VALUES (1011, '3C', 1003);
INSERT INTO racks (id, name, warehouse_id) VALUES (1012, '3D', 1003);

INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1001, 123456701, 'Laboratorio A', 'Ibuprofeno 400', true, 100);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1002, 123456702, 'Laboratorio A', 'Ibuprofeno 600', true, 200);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1003, 123456703, 'Laboratorio A', 'Ibuprofeno 800', true, 300);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1004, 123456704, 'Laboratorio B', 'Ibuprofeno 500', true, 150);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1005, 123456705, 'Laboratorio B', 'Ibuprofeno 1000', true, 500);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1006, 123456706, 'Laboratorio A', 'Tafirol 200', true, 100);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1007, 123456707, 'Laboratorio A', 'Tafirol 500', true, 200);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1008, 123456708, 'Laboratorio A', 'Tafirol 1000', true, 300);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1009, 123456709, 'Laboratorio B', 'Tafirol 500', true, 150);
INSERT INTO products (id, barcode, laboratory, name, prescription_required, price) VALUES (1010, 123456710, 'Laboratorio B', 'Tafirol 1000', true, 500);

INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1001, 150, 4000, 5000, 1001, 1001, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1002, 200, 1000, 3000, 1001, 1002, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1003, 900, 1500, 4000, 1001, 1003, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1004, 0, 1300 , 2000, 1001, 1004, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1005, 25, 500, 4000, 1001, 1005, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1006, 100, 1500, 2000, 1001, 1006, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1007, 200, 1500, 3000, 1001, 1007, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1008, 1000, 1000, 1000, 1001, 1008, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1009, 1000, 1000, 3000, 1001, 1009, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1010, 150, 800, 2000, 1001, 1001, 1004);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1011, 0, 1800, 2000, 1001, 1001, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1012, 0, 1700, 2000, 1001, 1002, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1013, 0, 1000, 2000, 1001, 1003, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1014, 0, 1000, 3000, 1001, 1004, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1015, 0, 1200, 3000, 1001, 1005, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1016, 0, 2200, 4000, 1001, 1006, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1017, 0, 1300, 2000, 1001, 1007, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1018, 0, 1500, 3000, 1001, 1008, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1019, 0, 1700, 2000, 1001, 1009, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1020, 0, 3500, 5000, 1001, 1010, 1004);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1021, 500, 1000, 2000, 1002, 1009, 1005);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1022, 350, 1750, 5000, 1002, 1010, 1006);

INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1001, 150, CURRENT_DATE -100, CURRENT_DATE + 100, null, 500, 'ACTIVE', 1001, 1001);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1002, 50, CURRENT_DATE -100, CURRENT_DATE, CURRENT_DATE, 500, 'EXPIRED', 1001, 1001);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1003, 200, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1000, 'ACTIVE', 1002, 1002);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1004, 900, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1000, 'ACTIVE', 1003, 1003);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1005, 0, CURRENT_DATE -100, CURRENT_DATE + 30, null, 1000, 'INACTIVE', 1004, 1004);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1006, 25, CURRENT_DATE -45, CURRENT_DATE + 40, null, 500, 'ACTIVE', 1005, 1005);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1007, 300, CURRENT_DATE -90, CURRENT_DATE - 10, CURRENT_DATE-10, 500, 'EXPIRED', 1005, 1005);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1008, 100, CURRENT_DATE -100, CURRENT_DATE + 300, null, 500, 'ACTIVE', 1006, 1006);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1009, 100, CURRENT_DATE -100, CURRENT_DATE -100, null, 500, 'EXPIRED', 1006, 1006);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1010, 200, CURRENT_DATE -100, CURRENT_DATE +200, null, 1000, 'ACTIVE', 1007, 1007);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1011, 1000, CURRENT_DATE -10, CURRENT_DATE +600, null, 1000, 'ACTIVE', 1008, 1008);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1012, 1000, CURRENT_DATE -10, CURRENT_DATE +600, null, 1000, 'ACTIVE', 1009, 1009);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1013, 1, CURRENT_DATE -100, CURRENT_DATE + 100, null, 1, 'RESERVED', 1001, 1001);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1014, 1, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1, 'RESERVED', 1002, 1002);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1015, 1, CURRENT_DATE -100, CURRENT_DATE + 100, null, 1, 'RESERVED', 1001, 1001);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1016, 1, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1, 'RESERVED', 1002, 1002);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1017, 1, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1, 'RESERVED', 1003, 1003);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1018, 1, CURRENT_DATE -100, CURRENT_DATE + 100, null, 1, 'INACTIVE', 1001, 1001);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1019, 1, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1, 'INACTIVE', 1002, 1002);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1020, 1, CURRENT_DATE -50, CURRENT_DATE + 200, null, 1, 'INACTIVE', 1003, 1003);
INSERT INTO stocks (id, available_stock, created_date, due_date, end_date, initial_stock, stock_status, locker_id, product_id)
VALUES (1021, 1, CURRENT_DATE -100, CURRENT_DATE + 30, null, 1, 'INACTIVE', 1004, 1004);


INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1001, null, null, 1, 1, 1001);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1002, null, null, 1, 1, 1002);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1003, null, null, 1, 1, 1003);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1004, null, null, 1, 1, 1004);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1005, null, null, 1, 1, 1005);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1006, null, null, 1, 1, 1006);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1007, null, null, 1, 1, 1007);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1008, null, null, 1, 1, 1008);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1009, null, null, 1, 1, 1009);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1010, null, null, 1, 1, 1010);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1011, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1001);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1012, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1002);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1013, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1003);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1014, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1004);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1015, 'PERCENTAGE',CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1005);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1016, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1006);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1017, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1007);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1018, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1008);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1019, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1009);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1020, 'PERCENTAGE', CONVERT('0.20',DECIMAL(19,2)), 1001, 1001, 1010);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1021, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1001);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1022, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1002);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1023, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1003);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1024, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1004);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1025, 'PERCENTAGE',CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1005);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1026, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1006);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1027, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1007);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1028, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1008);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1029, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1009);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1030, 'PERCENTAGE', CONVERT('0.30',DECIMAL(19,2)), 1001, 1002, 1010);

INSERT INTO customers (id, address, identification, identification_type, last_name, name, health_insurance_id, health_insurance_plan_id)
VALUES (1001, 'Morales 150', '28654321', 'DNI', 'Z??rate', 'Francisco', 1001, 1001);
INSERT INTO customers (id, address, identification, identification_type, last_name, name, health_insurance_id, health_insurance_plan_id)
VALUES (1002, 'Diego de Alvarado 2345', '20987654', 'DNI', 'Su??rez', 'David', 1001, 1002);
INSERT INTO customers (id, address, identification, identification_type, last_name, name, health_insurance_id, health_insurance_plan_id)
VALUES (1003, 'Gorriti 2134', '20987694', 'DNI', 'Figueroa', 'Hernan', 1, 1);
INSERT INTO customers (id, address, identification, identification_type, last_name, name, health_insurance_id, health_insurance_plan_id)
VALUES (1004, 'Morales  345', '35987694', 'DNI', 'Quinteros ', 'Lourdes', 1004, 1012);

INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1001, CURRENT_DATE, 'READY_TO_BILL', null, 300, 1001, 1001, 1004);
INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1002, CURRENT_DATE -10, 'BILLED', null, 600, 1001, 1001, 1004);
INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1003, CURRENT_DATE -20, 'DELIVERED', null, 750, 1001, 1001, 1004);
INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1004, CURRENT_DATE, 'READY_TO_BILL', null, 350, 1002, 1002, 1004);
INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1005, CURRENT_DATE -10, 'READY_TO_BILL', null, 680, 1001, 1002, 1004);
INSERT INTO sale_orders (id, created_date, sale_order_status, status_detail, total_amount, branch_office_id, customer_id, user_id)
VALUES (1006, CURRENT_DATE -20, 'READY_TO_BILL', null, 1250, 1001, 1001, 1003);

INSERT INTO taxes (id, label_invoice, tax_type, tax_value)
VALUES (1001, 'IVA Consumidor Final', 'VAT', CONVERT('0.21',DECIMAL(19,2)));

INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1001, null, 1, 1001, 100, 100, 1001);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1002, null, 3, 1001, 200, 200, 1002);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1010, CONVERT('40.00',DECIMAL(19,2)), 2, 1001, 200, 200, 1002);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1003, null, 1, 1002, 100, 100, 1001);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1004, null, 1, 1002, 200, 200, 1002);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1005, null, 1, 1002, 300, 300, 1003);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1006, null, 1, 1003, 100, 100, 1001);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1007, null, 1, 1003, 200, 200, 1002);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1008, null, 1, 1003, 300, 300, 1003);
INSERT INTO sale_order_items (id, discount_amount, quantity, sale_order_id, total_price, unitary_price, offer_id)
VALUES (1009, null, 1, 1003, 150, 150, 1004);

INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1001, 1013);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1002, 1014);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1003, 1015);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1004, 1016);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1005, 1017);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1006, 1018);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1007, 1019);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1008, 1020);
INSERT INTO order_item_stocks (sale_order_item_id, stock_id)
VALUES (1009, 1021);


INSERT INTO bills (id, cae, created_date, due_date, customer_id, sale_order_id, user_id)
VALUES (1001, '1234567891234567890', CURRENT_DATE, CURRENT_DATE +1, 1001, 1002, 1001);
INSERT INTO bills (id, cae, created_date, due_date, customer_id, sale_order_id, user_id)
VALUES (1002, '1234567891234567891', CURRENT_DATE, CURRENT_DATE +1, 1001, 1003, 1001);

INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1001, 1, null, 'Ibuprofeno 400', 1, 100, 100, 1001);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1002, 1, null, 'Ibuprofeno 600', 1, 200, 200, 1002);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1003, 1, null, 'Ibuprofeno 800', 1, 300, 300, 1003);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1004, 2, null, 'Ibuprofeno 400', 1, 100, 100, 1001);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1005, 2, null, 'Ibuprofeno 600', 1, 200, 200, 1002);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1006, 2, null, 'Ibuprofeno 800', 1, 300, 300, 1003);
INSERT INTO bill_items (id, bill_id, discount_amount, label_invoice, quantity, total_price, unitary_price, offer_id)
VALUES (1007, 2, null, 'Ibuprofeno 500', 1, 150, 150, 1004);


INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1001, CURRENT_DATE -45, 'CREATED', 1235467, 1001);
INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1002, CURRENT_DATE -10, 'PENDING_DELIVERY', 12678384, 1001);
INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1003, CURRENT_DATE -20, 'PENDING_DELIVERY', 2312345, 1001);
INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1004, CURRENT_DATE - 45, 'PENDING_DELIVERY', 56454532, 1001);
INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1005, CURRENT_DATE -10, 'PENDING_DELIVERY', 65478934, 1001);
INSERT INTO stock_orders (id, created_date, stock_order_status, purchase_order_id, warehouse_id)
VALUES (1006, CURRENT_DATE -20, 'PENDING_DELIVERY', 23445768, 1001);


INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1001, 2000, 1002, 'PENDING', 1001);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1002, 1000, 1002, 'PENDING', 1002);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1003, 1500, 1002, 'PENDING', 1003);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1004, 5000, 1002, 'PENDING', 1004);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1005, 1000, 1002, 'PENDING', 1005);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1006, 500, 1002, 'PENDING', 1006);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1007, 200, 1002, 'PENDING', 1007);
INSERT INTO stock_order_items (id, required_quantity, stock_order_id, stock_order_item_status, product_id)
VALUES (1008, 100, 1002, 'PENDING', 1008);
