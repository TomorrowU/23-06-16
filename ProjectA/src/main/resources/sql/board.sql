Drop Table board;

Drop SEQUENCE board_seq;

CREATE SEQUENCE board_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE TABLE board (
    bno      NUMBER(5)           NOT NULL CONSTRAINT BOARD_BNO_PK PRIMARY KEY,         
    subject  VARCHAR2(20 char)   NOT NULL,
    content  VARCHAR2(3000 char)         ,
    writer   VARCHAR2(10 char)   NOT NULL,
    reg_date date default sysdate
     );

insert into board 
    (bno , subject , content ,writer,reg_date)
    VALUES (
    1,'제목','내용','유옥천',SYSDATE
);


commit;