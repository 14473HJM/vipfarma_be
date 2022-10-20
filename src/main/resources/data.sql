INSERT INTO branch_office (id, name, location) VALUES (1001, 'NORTE', 'Herrera y Guzman 966, Marques de Sobremonte.');
INSERT INTO branch_office (id, name, location) VALUES (1002, 'CENTRO', 'Boulevard San Juan 966. Observatorio.');
INSERT INTO branch_office (id, name, location) VALUES (1003, 'SUR', 'Av. Valparaiso 1453, Jardin.');

INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1001, 1001, 'cajero1@email.com', 'password', 'caja', 'CASHIER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1002, 1001, 'deposito1@email.com', 'password', 'deposito', 'WAREHOUSE_MANAGER');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1003, 1001, 'admin@email.com', 'password', 'admin', 'ADMIN');
INSERT INTO users (id, branch_office_id, email, password, user_name, user_role) VALUES (1004, 1001, 'vendedor1@email.com', 'password', 'vendedor', 'SELLER');

INSERT INTO health_insurance (id, name) VALUES (1001, 'OSDE');
INSERT INTO health_insurance (id, name) VALUES (1002, 'SWISS MEDICAL');
INSERT INTO health_insurance (id, name) VALUES (1003, 'MEDIFE');
INSERT INTO health_insurance (id, name) VALUES (1004, 'SANCOR');

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
INSERT INTO health_insurance_plan (id, health_insurance_id, name) VALUES (1011, 1004, 'Profecionales');
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

INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1001, 150, 200, 1000, 1001, 1001, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1002, 200, 200, 1000, 1001, 1002, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1003, 900, 900, 1000, 1001, 1003, 1001);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1004, 0, 0, 1000, 1001, 1004, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1005, 25, 325, 1000, 1001, 1005, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1006, 100, 200, 1000, 1001, 1006, 1002);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1007, 200, 200, 1000, 1001, 1007, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1008, 1000, 1000, 1000, 1001, 1008, 1003);
INSERT INTO lockers (id, current_stock, occupied_capacity, stock_capacity, branch_office_id, product_id, rack_id) VALUES (1009, 1000, 1000, 1000, 1001, 1009, 1003);

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

INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1001, null, null, null, null, 1001);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1002, null, null, null, null, 1002);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1003, null, null, null, null, 1003);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1004, null, null, null, null, 1004);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1005, null, null, null, null, 1005);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1006, null, null, null, null, 1006);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1007, null, null, null, null, 1007);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1008, null, null, null, null, 1008);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1009, null, null, null, null, 1009);
INSERT INTO offers (id, discount_type, discount_value, health_insurance_id, health_insurance_plan_id, product_id)
VALUES (1010, null, null, null, null, 1010);
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
VALUES (1001, 'Calle sin numero 150', '28654321', 'DNI', 'Lescano', 'Pablo', 1001, 1001);
INSERT INTO customers (id, address, identification, identification_type, last_name, name, health_insurance_id, health_insurance_plan_id)
VALUES (1002, 'La esquina del infinito', '20987654', 'DNI', 'Nápoli', 'Chizzo', 1001, 1002);

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
VALUES (1002, null, 1, 1001, 200, 200, 1002);
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