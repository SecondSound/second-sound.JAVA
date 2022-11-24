INSERT INTO users (first_name, last_name, street, house_number, postal_code, city, country, phone_number, iban, email, password, user_role, enabled, locked, created_at)
VALUES ('John','Doe','Veemarktstraat','12','4811ZJ','Breda','Nederland','+31618588947','NL12INGB047583365','john.doe@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Bart','Grootoonk','Stationsstraat','47','5867HH','Tilburg','Nederland','+31676893445','NL23ABNA083465899','bart.grootoonk@email.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Johan','de Visser','Zuidermarkt','7C','2298HK','Groningen','Nederland','+31623354789','NL12INGB014365578','johandevisser@live.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Berend','Wolfstra','Beverweg','156','8766UO','Breda','Nederland','+31615477998','NL63RABO043667890','berendwolfstra@yahoo.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Kees','van Dongen','Parelsebaan','2','2857TY','Eindhoven','Nederland','+31665877034','NL12INGB031224567','kees.vandongen@hetnet.nl','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Merel','van Laren','Poolseweg','48D','6755JQ','Breda','Nederland','+31664855136','NL12INGB078695722','merelvanlaren@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Sofia','Bulgara','Torenstraat','18','4758UY','Amsterdam','Nederland','+31618675075','NL63RABO027586957','sofiabulgara@hotmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Ronald','Peyger','Dubbelsebaan','23','9273SO','Maastricht','Nederland','+31639687961','NL12INGB011334657','ronaldpeyger@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Ruud','Klozel','John F. Kennedylaan','112','3968GJ','Tilburg','Nederland','+31618477689','NL23ABNA047565767','ruudklozel@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW()),
       ('Bas','de Ruyter','Ginnekenweg','34','4812BK','Breda','Nederland','+31634355789','NL12INGB044879685','basderuyter@gmail.com','$2a$10$J1cVbLW4.wDH.oydt1R3Gupx0qb3mw885FfLNE8U5Oz2Rc.YFbmry','USER', true, false, NOW());


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