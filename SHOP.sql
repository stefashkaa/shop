DROP TABLE PURCHASE CASCADE;
DROP TABLE CLIENT CASCADE;
DROP TABLE PRODUCT CASCADE;
DROP TABLE CATEGORY CASCADE;

DROP SEQUENCE CATEGORY_SEQ;
DROP SEQUENCE CLIENT_SEQ;
DROP SEQUENCE PRODUCT_SEQ;
DROP SEQUENCE PURCHASE_SEQ;

CREATE SEQUENCE CATEGORY_SEQ
INCREMENT BY 1
MINVALUE 1
START WITH 1;

CREATE SEQUENCE CLIENT_SEQ
INCREMENT BY 1
MINVALUE 1
START WITH 1;

CREATE SEQUENCE PRODUCT_SEQ
INCREMENT BY 1
MINVALUE 1
START WITH 1;

CREATE SEQUENCE PURCHASE_SEQ
INCREMENT BY 1
MINVALUE 1
START WITH 1;

CREATE TABLE CATEGORY(
ID INT,
PRIMARY KEY(ID),
NAME VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE PRODUCT(
ID INT,
NAME VARCHAR(20) NOT NULL UNIQUE,
PRICE INT NOT NULL,
COUNT INT,
CATEGORY_ID INT,
IMAGE VARCHAR(100),
DESCRIPTION VARCHAR(255),
FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID),
PRIMARY KEY(ID)
);

CREATE TABLE CLIENT(
ID INT,
PRIMARY KEY (ID),
NAME VARCHAR(20) NOT NULL UNIQUE,
DEFAULT_ADDRESS VARCHAR(20) NOT NULL
);

CREATE TABLE PURCHASE(
ID INT,
PRODUCT_ID INT,
CLIENT_ID INT,
COUNT INT NOT NULL,
PRICE INT NOT NULL,
ADDRESS VARCHAR(20) NOT NULL,
ORD_DATE DATE,
STATUS VARCHAR(20) NOT NULL,
FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID),
FOREIGN KEY(CLIENT_ID) REFERENCES CLIENT(ID),
PRIMARY KEY (ID)
);

INSERT INTO CATEGORY VALUES (nextval('CATEGORY_SEQ'), 'BOOKS'),
                            (nextval('CATEGORY_SEQ'), 'GAMES'),
                            (nextval('CATEGORY_SEQ'), 'MUSIC'),
                            (nextval('CATEGORY_SEQ'), 'FILMS'),
                            (nextval('CATEGORY_SEQ'), 'OTHER');

INSERT INTO PRODUCT VALUES (nextval('PRODUCT_SEQ'), 'CLR via C#', 60, 10, 1, 'clr.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Learn Java', 50, 10, 1, 'java.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Computer networks', 45, 0, 1, 'network.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'C# Programming', 10, 100, 1, 'csharp.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'NFS', 10, 10, 2, 'nfs.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Hitman', 10, 10, 2, 'hitman.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Crysis', 10, 10, 2, 'crysis.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Lumen', 9, 20, 3, 'lumen.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Rammstein', 7, 50, 3, 'rammstein.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Crushed stone', 6, 200, 4, 'cstone.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Nails', 1, 1000, 5, 'nails.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Something', 10, 8, 4, 'something.jpg', 'This is product!'),
                           (nextval('PRODUCT_SEQ'), 'Brick', 1, 100, 5, 'brick.jpg', 'This is product!');

INSERT INTO CLIENT VALUES (nextval('CLIENT_SEQ'), 'Popov S.N.', 'Togliatty, Mira, 43'),
                          (nextval('CLIENT_SEQ'), 'Fedotov A.P.', 'Samara, Lenina, 4'),
                          (nextval('CLIENT_SEQ'), 'Alexeev L.K.', 'Samara, Lukacheva, 1'),
                          (nextval('CLIENT_SEQ'), 'Petrov I.A.', 'Gaya, 5'),
                          (nextval('CLIENT_SEQ'), 'Suhov I.A.', 'Gaya, 5');

INSERT INTO PURCHASE VALUES (nextval('PURCHASE_SEQ'), 1, 1, 1, 60, 'Togliatty, Mira, 43', '13-FEB-2017', 'Waiting for delivery'),
                            (nextval('PURCHASE_SEQ'), 4, 2, 2, 20, 'Gaya, 5', '29-JAN-2016', 'Filled'),
                            (nextval('PURCHASE_SEQ'), 4, 3, 3, 30, 'Gaya, 5', '30-JAN-2016', 'Filled'),
                            (nextval('PURCHASE_SEQ'), 2, 4, 3, 150, 'Samara, Lenina, 4', '10-APR-2016', 'Filled'),
                            (nextval('PURCHASE_SEQ'), 3, 5, 2, 90, 'Samara, Lukacheva, 1', '01-MAR-2017', 'Waiting for delivery');