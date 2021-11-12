CREATE TABLE mvc_board (
    bid      NUMBER(4) PRIMARY KEY,
    bname    VARCHAR2(20),
    btitle   VARCHAR2(100),
    bcontent VARCHAR2(300),
    bdate    DATE DEFAULT sysdate,
    bhit     NUMBER(4) DEFAULT 0
);

-- INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 );

SELECT
    *
FROM
    mvc_board;

SELECT
    bid,
    bname,
    btitle,
    bcontent,
    bdate,
    bhit
FROM
    mvc_board
ORDER BY
    bid DESC;

CREATE SEQUENCE mvc_board_seq;

DROP SEQUENCE mvc_board_seq;

CREATE SEQUENCE mvc_board_seq MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 CACHE 10 NOORDER NOCYCLE;

DELETE FROM mvc_board;

COMMIT;