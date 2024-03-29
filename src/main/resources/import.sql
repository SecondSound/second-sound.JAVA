INSERT INTO category (id, name, created_at)
VALUES (1, 'Equipment and Electronics', NOW()),
       (2, 'Wind instruments', NOW()),
       (3, 'Services and Professionals', NOW()),
       (4, 'Drums and Percussion', NOW()),
       (5, 'Parts and Accessories', NOW()),
       (6, 'Pianos and Keys', NOW()),
       (7, 'String instruments', NOW()),
       (8, 'Stringed instruments', NOW()),
       (9, 'Remainder', NOW());

INSERT INTO sub_category (id, name, created_at, category_id)
VALUES (1, 'Audio | Professional', NOW(), 1),
       (2, 'DJ sets and Turntables', NOW(), 1),
       (3, 'Effects', NOW(), 1),
       (4, 'Light and Laser', NOW(), 1),
       (5, 'Loudspeakers', NOW(), 1),
       (6, 'Mixers', NOW(), 1),
       (7, 'Microphones', NOW(), 1),
       (8, 'MIDI equipment', NOW(), 1),
       (9, 'Samplers', NOW(), 1),
       (10, 'Soundmodules', NOW(), 1),
       (11, 'Amplifiers | Bass and Guitar', NOW(), 1),
       (12, 'Amplifiers | Keyboard, Monitor and PA', NOW(), 1),
       (13, 'Recorders', NOW(), 2),
       (14, 'Didgeridoos', NOW(), 2),
       (15, 'Flutes and piccolo', NOW(), 2),
       (16, 'Hobos', NOW(), 2),
       (17, 'Horns', NOW(), 2),
       (18, 'Clarinets', NOW(), 2),
       (19, 'Harmonicas', NOW(), 2),
       (20, 'Saxophones', NOW(), 2),
       (21, 'Trombones', NOW(), 2),
       (22, 'Trumpets', NOW(), 2),
       (23, 'Tubas', NOW(), 2),
       (24, 'Remainder', NOW(), 2),
       (25, 'Music and Singing lessons', NOW(), 3),
       (26, 'Musicians, Artists and DJs', NOW(), 3),
       (27, 'Repair and Maintenance', NOW(), 3),
       (28, 'Drumcomputers', NOW(), 4),
       (29, 'Drum Sets', NOW(), 4),
       (30, 'Percussion', NOW(), 4),
       (31, 'Enclosures and Cases', NOW(), 5),
       (32, 'Music', NOW(), 5),
       (33, 'Components', NOW(), 5),
       (34, 'Belong', NOW(), 5),
       (35, 'Cables and Plugs', NOW(), 5),
       (36, 'Standards', NOW(), 5),
       (37, 'Theatre lighting', NOW(), 5),
       (38, 'Accordions', NOW(), 6),
       (39, 'Keyboards', NOW(), 6),
       (40, 'Organs', NOW(), 6),
       (41, 'Pianos', NOW(), 6),
       (42, 'Synthesizers', NOW(), 6),
       (43, 'Banjos', NOW(), 7),
       (44, 'Guitars | Acoustic', NOW(), 7),
       (45, 'Guitars | Bass', NOW(), 7),
       (46, 'Guitars | Electric', NOW(), 7),
       (47, 'Harps', NOW(), 7),
       (48, 'Harpsichords', NOW(), 7),
       (49, 'Mandolins', NOW(), 7),
       (50, 'Remainder', NOW(), 7),
       (51, 'Cellos', NOW(), 8),
       (52, 'Double basses', NOW(), 8),
       (53, 'Violins and Violas', NOW(), 8),
       (54, 'Remainder', NOW(), 8),
       (55, 'Books', NOW(), 9),
       (56, 'Barrel organs', NOW(), 9),
       (57, 'Orchestral tapes', NOW(), 9),
       (58, 'Other Music and Instruments', NOW(), 9);



INSERT INTO users (first_name, last_name, street, house_number, postal_code, city, country, phone_number, iban, email, password, user_role, enabled, locked, created_at)
VALUES ('John','Doe','Veemarktstraat','12','4811ZJ','Breda','Nederland','+31618588947','NL12***********65','john.doe@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Bart','Grootoonk','Statenweg','72','3039JK','Rotterdam','Nederland','+31676893445','NL2***********99','bart.grootoonk@email.com','$2a$10$nIko989EJDWtb4f9jNnrdekCrLv88.rl1I.v/spnsudQSw7VY6mdy','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Johan','de Visser','Professor Kranenburglaan','7','3741EP','Baarn','Nederland','+31623354789','NL12***********78','johandevisser@live.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Berend','Wolfstra','Schaapsweg','71','6713BB','Ede','Nederland','+31615477998','NL63***********90','berendwolfstra@yahoo.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Kees','van Dongen','Zeelelieweg ','51','4325BV','Renesse','Nederland','+31665877034','NL12***********67','kees.vandongen@hetnet.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Merel','van Laren','Straatje van Anna Cramer','70','2033RZ','Haarlem','Nederland','+31664855136','NL12***********22','merelvanlaren@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Sofia','Bulgara','De Gast','63','9801AA','Groningen','Nederland','+31618675075','NL63***********57','sofiabulgara@hotmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Ronald','Peyger','Ootmarsumsestraat','141','7634PN','Tilligte','Nederland','+31639687961','NL12***********57','ronaldpeyger@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Ruud','Klozel','Frans Duwaerstraat','191','1318AD','Almere','Nederland','+31618477689','NL23***********67','ruudklozel@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW() - INTERVAL 5 DAY),
       ('Bas','de Ruyter','Tjalkstraat','70','5301VV','Zaltbommel','Nederland','+31634355789','NL12***********85','basderuyter@gmail.com','$2a$10$nIko989EJDWtb4f9jNnrdekCrLv88.rl1I.v/spnsudQSw7VY6mdy','USER', true, false, NOW() - INTERVAL 5 DAY);


INSERT INTO confirmation_token (confirmed_at, created_at, expired_at, token, user_id)
VALUES (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '88bf0629-45d3-4897-be7c-062bdf21e7d9', 1),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '466b0d03-68a7-4663-bce5-eae2a7325a80', 2),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, 'eac05c5c-4f89-422d-9766-0ec5e2e4edab', 3),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, 'f42259dd-c184-4d50-b273-08b2841bc667', 4),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '5ba86400-c642-4a70-b26e-8439ceb88607', 5),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, 'ca0bdbbf-9fc3-4008-8992-4b21b45e8a22', 6),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '6a3aab52-b8f1-4212-844f-42014adf6c71', 7),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, 'f369ec15-cd7b-4a12-bfbf-1e95a30816c4', 8),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '45fbba19-2e0d-4c65-9b51-97266e83f98a', 9),
       (NOW(), NOW(), NOW() + INTERVAL 1 HOUR, '05bf9bf1-9580-4480-ae6f-b2bc490cdc79', 10);

INSERT INTO advertisement (created_at, description, price, title, user_id, sub_category_id, is_active)
VALUES (NOW() - INTERVAL 1544 MINUTE, 'Pellentesque elit eget gravida cum sociis natoque penatibus. Ut morbi tincidunt augue interdum velit euismod in. Gravida quis blandit turpis cursus.', 1100, 'Godin Multiac Nylon SA', 1, 44, true),
       (NOW() - INTERVAL 1733 MINUTE, 'Donec ultrices tincidunt arcu non sodales. Vitae tortor condimentum lacinia quis vel eros donec. Feugiat in fermentum posuere urna nec tincidunt praesent. ', 25, 'General Music Cd1 Hyper Keyboard', 3, 39, true),
       (NOW() - INTERVAL 1235 MINUTE, 'Malesuada fames ac turpis egestas maecenas pharetra. Eu feugiat pretium nibh ipsum consequat nisl vel. Etiam non quam lacus suspendisse faucibus interdum posuere lorem.', 1200, 'Saxophone alto handcraft', 2, 20, true),
       (NOW() - INTERVAL 957 MINUTE, 'Sed arcu non odio euismod lacinia at quis risus. Facilisis sed odio morbi quis commodo odio aenean. Scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis. Et tortor consequat id porta nibh venenatis cras sed felis.', 399, 'Bass guitar Sterling Sub Ray 4 black and Ray24 Butterscotch', 7, 45, true),
       (NOW() - INTERVAL 2654 MINUTE, 'Id volutpat lacus laoreet non curabitur gravida arcu ac tortor. Orci ac auctor augue mauris augue neque. Laoreet sit amet cursus sit.', 109, 'Shure | SM58 | microphone', 9, 7, true),
       (NOW() - INTERVAL 654 MINUTE, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 450, 'Tacoma mandoline', 1, 49, true),
       (NOW() - INTERVAL 741 MINUTE, 'Etiam erat velit scelerisque in dictum non consectetur. Pellentesque elit eget gravida cum sociis natoque penatibus. Ut morbi tincidunt augue interdum velit euismod in.', 2400,'Coolsma alto recorder 415 Hz', 3, 15, true),
       (NOW() - INTERVAL 231 MINUTE, 'Fringilla phasellus faucibus scelerisque eleifend donec. Fermentum dui faucibus in ornare quam. Placerat vestibulum lectus mauris ultrices eros in cursus turpis. Donec ultrices tincidunt arcu non sodales.', 179, 'Fazley FSB418BK headless electric guitar black', 1, 46, true),
       (NOW() - INTERVAL 796 MINUTE, 'Vitae tortor condimentum lacinia quis vel eros donec. Feugiat in fermentum posuere urna nec tincidunt praesent. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. Fusce id velit ut tortor pretium. Integer eget aliquet nibh praesent tristique magna.', 400, 'Fender redondo special MBK', 1, 44, true),
       (NOW() - INTERVAL 985 MINUTE, 'Sodales ut eu sem integer vitae justo eget magna fermentum. Quam id leo in vitae turpis massa sed elementum tempus.', 425, '(B-Stock) Gold Tone CC-MINI Cripple Creek Mini Banjo', 1, 43, true),
       (NOW() - INTERVAL 85 MINUTE, 'Mattis molestie a iaculis at erat pellentesque adipiscing commodo elit. Est ante in nibh mauris cursus mattis molestie a iaculis.', 8999.95, 'LED wall Lighthouse incl. processors', 6, 4, true);


INSERT INTO resource (created_at, file_path, advertisement_id)
VALUES (NOW(), 'https://cdn.webshopapp.com/shops/179375/files/349741130/je-akoestische-gitaar-versterken-en-opnemen.jpg', 1),
       (NOW(), 'https://www.omarimc.com/wp-content/uploads/2018/01/keyboard-2822917_1920.jpg', 2),
       (NOW(), 'https://basensax.nl/images/virtuemart/product/p1050082-1589602842.jpg', 3),
       (NOW(), 'https://i.pinimg.com/originals/fe/56/f0/fe56f0cb02a22f2a4b9813f163066d5d.jpg', 4),
       (NOW(), 'https://medias.audiofanzine.com/images/normal/shure-sm58-876627.jpg', 5),
       (NOW(), 'https://images.reverb.com/image/upload/s--Vm3BSNKZ--/a_exif,c_limit,e_unsharp_mask:80,f_auto,fl_progressive,g_south,h_620,q_90,w_620/v1497806171/jimdsidg6easqujseb4x.jpg', 6),
       (NOW(), 'https://www.waregem.be/sites/waregem/files/styles/half_width/public/blokfluit_0.png', 7),
       (NOW(), 'https://images.richtonemusic.co.uk/product/YIBANEZ9293508.jpg', 8),
       (NOW(), 'https://img.audiofanzine.com/images/u/product/normal/fender-redondo-special-2020-current-287075.jpg', 9),
       (NOW(), 'https://images.reverb.com/image/upload/s--yBpGNgPk--/f_auto,t_large/v1536089751/g6zytpf22kg2awuygwz1.jpg', 10),
       (NOW(), 'https://www.used.forsale/sh-img/thumbnail_led%2Bwall.jpg', 11);



INSERT INTO chat (created_at, advertisement_id, sender_id, receiver_id)
VALUES (NOW(), 1, 1, 2),
       (NOW(), 2, 3, 4),
       (NOW(), 4, 2, 1);

INSERT INTO message (created_at, message, chat_id, sender_id, receiver_id)
VALUES (NOW(), "test message", 1, 1, 2),
        (NOW(), "test message2", 1, 2, 1),
        (NOW(),"test", 2, 3, 4),
        (NOW(),"test2", 2, 4, 3);





INSERT INTO bid (created_at, amount, advertisement_id, bidder_id)
VALUES (NOW() - INTERVAL 1354 MINUTE, 750, 1, 7),
       (NOW() - INTERVAL 847 MINUTE, 800, 1, 5),
       (NOW() - INTERVAL 542 MINUTE, 835, 1, 6),
       (NOW() - INTERVAL 42 MINUTE, 880, 1, 7),
       (NOW() - INTERVAL 1447 MINUTE, 10, 2, 2),
       (NOW() - INTERVAL 647 MINUTE, 12.50, 2, 4),
       (NOW() - INTERVAL 317 MINUTE, 13.00, 2, 1),
       (NOW() - INTERVAL 255 MINUTE, 15.00, 2, 4),
       (NOW() - INTERVAL 62 MINUTE, 17.90, 2, 1),
       (NOW() - INTERVAL 12 MINUTE, 21.50, 2, 4),
       (NOW() - INTERVAL 365 MINUTE, 575, 3, 1),
       (NOW() - INTERVAL 142 MINUTE, 810, 3, 5),
       (NOW() - INTERVAL 2144 MINUTE, 75, 5, 3),
       (NOW() - INTERVAL 1456 MINUTE, 85, 5, 6),
       (NOW() - INTERVAL 841 MINUTE, 89, 5, 1),
       (NOW() - INTERVAL 142 MINUTE, 95.50, 5, 6),
       (NOW() - INTERVAL 62 MINUTE, 1000, 7, 1),
       (NOW() - INTERVAL 12 MINUTE, 250, 9, 4),
       (NOW() - INTERVAL 365 MINUTE, 75, 8, 2),
       (NOW() - INTERVAL 142 MINUTE, 85, 8, 5),
       (NOW() - INTERVAL 2144 MINUTE, 6500, 11, 4);

INSERT INTO rating (rating, rated_by_user_id, user_id)
VALUES (5, 2, 1),
       (3, 1, 2),
       (4, 5, 3),
       (4, 2, 4),
       (3, 2, 5),
       (5, 3, 6),
       (5, 8, 7),
       (2, 10, 8),
       (4, 6, 9),
       (5, 4, 10),
       (4, 2, 1),
       (4, 10, 2),
       (5, 5, 3),
       (5, 2, 4),
       (2, 2, 5),
       (1, 3, 6),
       (4, 8, 7),
       (5, 10, 8),
       (5, 1, 9),
       (3, 4, 10),
       (4, 2, 1),
       (3, 8, 2),
       (5, 5, 3),
       (5, 2, 4),
       (5, 2, 5),
       (1, 3, 6),
       (2, 8, 7),
       (3, 10, 8),
       (4, 7, 9),
       (4, 4, 10);
