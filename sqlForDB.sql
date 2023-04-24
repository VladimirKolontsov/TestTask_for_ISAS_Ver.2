insert into types(name)
values ('TV'),
       ('cleaner'),
       ('fridge'),
       ('phone'),
       ('computer');

insert into product_type(type_id, country, brand, is_online_order, is_credit)
values (1, 'Japan', 'Sony', TRUE, TRUE),
       (1, 'Korea', 'LG', TRUE, TRUE),
       (1, 'Japan', 'Panasonic', TRUE, TRUE),
       (2, 'Netherlands', 'Philips', TRUE, TRUE),
       (2, 'Korea', 'Samsung', TRUE, TRUE),
       (2, 'Switzerland', 'Polaris', TRUE, TRUE),
       (3, 'Electrolux', 'Sweden', TRUE, TRUE),
       (3, 'Korea', 'LG', TRUE, TRUE),
       (3, 'Italy', 'Smeg', TRUE, TRUE),
       (4, 'Japan', 'Sony', TRUE, TRUE),
       (4, 'Korea', 'LG', TRUE, TRUE),
       (4, 'USA', 'Apple', TRUE, TRUE),
       (5, 'Japan', 'Sony', TRUE, TRUE),
       (5, 'Asus', 'Taiwan', TRUE, TRUE),
       (5, 'USA', 'Apple', TRUE, TRUE);

insert into product_model(product_type_id, name, serial_number, color, size, price, is_in_stock)
VALUES (1, 'KD55X', 12334567, 'black', 55, 90000, TRUE),
       (1, 'KD50X', 57463728, 'white', 50, 56000, false),
       (2, 'G2', 63565645, 'black', 77, 82000, TRUE),
       (2, 'C2', 13542656, 'grey', 67, 78000, TRUE),
       (3, 'TX', 87467677, 'black', 42, 40000, false),
       (3, 'TX-55', 67624573, 'blue', 55, 65000, TRUE),
       (4, 'FC9351', 85783563, 'red', 243, 13000, true),
       (4, 'FC9732', 67536636, 'grey', 212, 25000, TRUE),
       (5, 'sc4520', 36356266, 'green', 189, 9000, false),
       (5, 'sc5138', 24565678, 'blue', 195, 19000, TRUE),
       (6, 'pvcs 0725', 96753624, 'black', 201, 8000, TRUE),
       (6, 'pvc 2003', 25456577, 'black', 195, 7500, TRUE),
       (7, 'EN93852', 25667735, 'white', 2000, 50500, false),
       (7, 'en3487', 63573562, 'black', 1800, 43000, TRUE),
       (8, 'GW-B509', 37265653, 'silver', 1990, 45000, TRUE),
       (8, 'GW-B610', 26786473, 'gery', 1900, 55000, TRUE),
       (9, 'FAB5RDUJ5', 68437636, 'multicolor', 1500, 125000, TRUE),
       (9, 'MTE40', 65636363, 'black', 650, 49000, false),
       (10, 'xperia1', 36363632, 'black', 34, 30000, TRUE),
       (10, 'xperia-pro', 25636225, 'black', 40, 40000, TRUE),
       (11, 'w41', 26773562, 'black', 38, 7000, TRUE),
       (11, 'k62', 95787463, 'black', 41, 13000, TRUE),
       (12, 'iphone 12', 87463635, 'gold', 43, 70000, false),
       (12, 'iphone 14 pro', 25657453, 'black', 47, 130000, TRUE),
       (13, 'vaio pcg-71812', 47365652, 'black', 55, 90000, TRUE),
       (13, 'vaio pcg-71211', 62536362, 'grey', 55, 65000, TRUE),
       (14, 'F15', 37362562, 'black', 23, 73000, false),
       (14, 'A15', 62546366, 'silver', 21, 60000, TRUE),
       (15, 'macbook air 2019', 62525256, 'dark grey', 13, 90000, TRUE),
       (15, 'macbook pro M2', 36265377, 'black', 14, 210000, TRUE);

insert into tv_attribute (product_model_id, categories, technology)
values (1, 'auto', 'fast'),
       (2, 'not auto', 'slow'),
       (3, 'auto', 'fast'),
       (4, 'not auto', 'slow'),
       (5, 'auto', 'fast'),
       (6, 'not auto', 'slow');

insert into cleaner_attribute (product_model_id, dust_container_volume, quantity_of_modes)
VALUES (7, 0.3, 3),
       (8, 0.4, 2),
       (9, 0.5, 4),
       (10, 0.25, 5),
       (11, 0.37, 3),
       (12, 0.42, 4);

insert into fridge_attribute (product_model_id, quantity_of_doors, type_of_compressor)
VALUES (13, 1, 'inventor'),
       (14, 1, 'inventor'),
       (15, 1, 'line'),
       (16, 2, 'inventor'),
       (17, 2, 'line'),
       (18, 1, 'line');

insert into phone_attribute (product_model_id, phone_memory, quantity_of_cameras)
VALUES (19, 64, 1),
       (20, 128, 3),
       (21, 256, 2),
       (22, 256, 2),
       (23, 128, 4),
       (24, 512, 5);

insert into computer_attribute (product_model_id, categories, type_of_processor)
VALUES (25, 'laptop', 'intel core i5'),
       (26, 'laptop', 'intel core i3'),
       (27, 'laptop', 'intel core i7'),
       (28, 'laptop', 'AMD Ryzen'),
       (29, 'laptop', 'intel core i5'),
       (30, 'laptop', 'apple m2');