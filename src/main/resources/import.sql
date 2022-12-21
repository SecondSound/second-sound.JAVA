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
VALUES ('John','Doe','Veemarktstraat','12','4811ZJ','Breda','Nederland','+31618588947','NL12INGB047583365','john.doe@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Bart','Grootoonk','Stationsstraat','47','5867HH','Tilburg','Nederland','+31676893445','NL23ABNA083465899','bart.grootoonk@email.com','$2a$10$nIko989EJDWtb4f9jNnrdekCrLv88.rl1I.v/spnsudQSw7VY6mdy','USER', true, false, NOW()),
       ('Johan','de Visser','Zuidermarkt','7C','2298HK','Groningen','Nederland','+31623354789','NL12INGB014365578','johandevisser@live.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Berend','Wolfstra','Beverweg','156','8766UO','Breda','Nederland','+31615477998','NL63RABO043667890','berendwolfstra@yahoo.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Kees','van Dongen','Parelsebaan','2','2857TY','Eindhoven','Nederland','+31665877034','NL12INGB031224567','kees.vandongen@hetnet.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Merel','van Laren','Poolseweg','48D','6755JQ','Breda','Nederland','+31664855136','NL12INGB078695722','merelvanlaren@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Sofia','Bulgara','Torenstraat','18','4758UY','Amsterdam','Nederland','+31618675075','NL63RABO027586957','sofiabulgara@hotmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Ronald','Peyger','Dubbelsebaan','23','9273SO','Maastricht','Nederland','+31639687961','NL12INGB011334657','ronaldpeyger@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Ruud','Klozel','John F. Kennedylaan','112','3968GJ','Tilburg','Nederland','+31618477689','NL23ABNA047565767','ruudklozel@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Bas','de Ruyter','Ginnekenweg','34','4812BK','Breda','Nederland','+31634355789','NL12INGB044879685','basderuyter@gmail.com','$2a$10$nIko989EJDWtb4f9jNnrdekCrLv88.rl1I.v/spnsudQSw7VY6mdy','USER', true, false, NOW());


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
VALUES (NOW(), '3/4 Guitar, with guitar bag backpack. Guitar gives a warm sound', 1100, 'Godin Multiac Nylon SA', 1, 44, true),
       (NOW(), 'Great keyboard. Including textbook.', 25, 'General Music Cd1 Hyper Keyboard', 3, 39, true),
       (NOW(), 'Professional alt-martijn saxophone model handmade, handmade from 1926, hand engraved, individually welded tone holes, re-polished with prestini brand pad in 2022, feathers replaced, working. It is shipped with a mordiba travel bag, with courier and insurance.', 1200, 'Saxophone alto handcraft', 2, 20, true),
       (NOW(), 'Now from € 525,00 for € 399,00. Free at home. Full manufacturers warranty. Delivered adjusted. Of course you can test it in our showroom of 2000m2. With 14 day money back guarantee!', 399, 'Bass guitar Sterling Sub Ray 4 black and Ray24 Butterscotch', 7, 45, true),
       (NOW(), 'The legendary SM58® (without switch) is an industry-standard, highly versatile, cardioid, dynamic vocal microphone specially made for a warm and clear vocal reproduction. The SM58® is invariably the first choice for singing performances around the world.', 109, 'Shure | SM58 | microfoon', 9, 7, true);

INSERT INTO resource (created_at, file_path, advertisement_id)
VALUES (NOW(), 'https://cdn.webshopapp.com/shops/179375/files/349741130/je-akoestische-gitaar-versterken-en-opnemen.jpg', 1),
       (NOW(), 'https://www.omarimc.com/wp-content/uploads/2018/01/keyboard-2822917_1920.jpg', 2),
       (NOW(), 'https://basensax.nl/images/virtuemart/product/p1050082-1589602842.jpg', 3),
       (NOW(), 'https://i.pinimg.com/originals/fe/56/f0/fe56f0cb02a22f2a4b9813f163066d5d.jpg', 4),
       (NOW(), 'https://medias.audiofanzine.com/images/normal/shure-sm58-876627.jpg', 5);

INSERT INTO chat (created_at, advertisement_id, sender_id, receiver_id)
VALUES (NOW(), 1, 1, 2),
       (NOW(), 2, 3, 4),
       (NOW(), 4, 2, 1);

INSERT INTO message (created_at, message, chat_id, sender_id, receiver_id)
VALUES (NOW(), "test message", 1, 1, 2),
        (NOW(), "test message2", 1, 2, 1),
        (NOW(),"test", 2, 3, 4),
        (NOW(),"test2", 2, 4, 3);



