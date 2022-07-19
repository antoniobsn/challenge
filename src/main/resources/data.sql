INSERT
INTO
  merchant
  (id, name, email, cif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Treutel, Schumm and Fadel', 'info@treutel-schumm-and-fadel.com', 'B611111111');

INSERT
INTO
  shopper
  (id, name, email, nif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Olive Thompson', 'olive.thompson@not_gmail.com', '411111111Z');

INSERT
INTO
  purchase
  (id, shopper_id, merchant_id, amount, created_At, completed_At)
VALUES
  (NEXTVAL('hibernate_sequence'), 2, 1, 61.74, '2022-07-18', '2022-07-18');

INSERT
INTO
  merchant
  (id, name, email, cif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Windler and Sons', 'info@windler-and-sons.com', 'B611111112');

INSERT
INTO
  merchant
  (id, name, email, cif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Mraz and Sons', 'info@mraz-and-sons.com', 'B611111113');

INSERT
INTO
  merchant
  (id, name, email, cif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Cummerata LLC', 'info@cummerata-llc.com', 'B611111114');

INSERT
INTO
  shopper
  (id, name, email, nif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Virgen Anderson', 'virgen.anderson@not_gmail.com', '411111112Z');

INSERT
INTO
  shopper
  (id, name, email, nif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Reagan Auer', 'reagan.auer@not_gmail.com', '411111113Z');

INSERT
INTO
  shopper
  (id, name, email, nif)
VALUES
  (NEXTVAL('hibernate_sequence'), 'Shanelle Satterfield', 'shanelle.satterfield@not_gmail.com', '411111114Z');

INSERT
INTO
  purchase
  (id, shopper_id, merchant_id, amount, created_At, completed_At)
VALUES
  (NEXTVAL('hibernate_sequence'), 2, 1, 293.08, '2022-07-18', '2022-07-18');

INSERT
INTO
  purchase
  (id, shopper_id, merchant_id, amount, created_At, completed_At)
VALUES
  (NEXTVAL('hibernate_sequence'), 7, 4, 373.33, '2022-07-18', '2022-07-18');

--INSERT
--INTO
--  purchase
--  (id, shopper_id, merchant_id, amount, created_At, completed_At)
--VALUES
--  (NEXTVAL('hibernate_sequence'), 8, 5, 60.48, '2022-07-18', '2022-07-18');

--INSERT
--INTO
--  purchase
--  (id, shopper_id, merchant_id, amount, created_At, completed_At)
--VALUES
--  (NEXTVAL('hibernate_sequence'), 9, 6, 213.97, '2022-07-18', '2022-07-18');