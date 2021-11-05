CREATE TABLE mvc_board (
    bid      NUMBER(4) PRIMARY KEY,
    bname    VARCHAR2(20),
    btitle   VARCHAR2(100),
    bcontent VARCHAR2(300),
    bdate    DATE DEFAULT sysdate,
    bhit     NUMBER(4) DEFAULT 0
);

CREATE SEQUENCE mvc_board_seq;

-- INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 );

SELECT
    *
FROM
    mvc_board;