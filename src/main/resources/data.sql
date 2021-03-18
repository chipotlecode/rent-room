INSERT INTO ROOM_TYPE(room_type_id, name) VALUES     (1, 'Single');
INSERT INTO ROOM_TYPE(room_type_id, name) VALUES     (2, 'Couple');
INSERT INTO ROOM_TYPE(room_type_id, name) VALUES     (3, 'Family');

INSERT INTO PAYMENT_TYPE(payment_type_id, name) VALUES  (1, 'Cash');
INSERT INTO PAYMENT_TYPE(payment_type_id, name) VALUES  (2, 'Debit Card');
INSERT INTO PAYMENT_TYPE(payment_type_id, name) VALUES  (3, 'Credit Card');

INSERT INTO RENT_TYPE(rent_type_id, name) VALUES    (1, 'By Day');
INSERT INTO RENT_TYPE(rent_type_id, name) VALUES    (2, 'Express');

INSERT INTO ROOM(beds, jacuzzi, people, price, tv, wifi, room_type_room_type_id)
  VALUES(1, 0, 1, 50.00, 1, 1, 1);
INSERT INTO ROOM(beds, jacuzzi, people, price, tv, wifi, room_type_room_type_id)
  VALUES(1, 0, 2, 75.00, 1, 1, 2);
INSERT INTO ROOM(beds, jacuzzi, people, price, tv, wifi, room_type_room_type_id)
  VALUES(1, 1, 2, 75.00, 1, 1, 2);