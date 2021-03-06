-- CREATE TABLE BOOK INVENTORY:
SET DEFINE OFF;

CREATE TABLE TB_BOOK_INVENTORY (
  ID NUMBER NOT NULL,
  NAME VARCHAR2(50),
  AUTHOR_ID NUMBER NOT NULL,
  PUBLISHER_ID NUMBER NOT NULL,
  PRICE NUMBER,
  AMT_PAGES NUMBER,
  TOTAL NUMBER,
  CREATED_DT TIMESTAMP,
  CREATED_BY VARCHAR2(20),
  UPDATED_DT TIMESTAMP,
  UPDATED_BY VARCHAR2(20),
  CONSTRAINT TB_BOOK_INVENTORY_PK PRIMARY KEY(ID) ENABLE
);

COMMIT;

CREATE SEQUENCE "TB_BOOK_INVENTORY_SEQ" MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE;
COMMIT;