CREATE TABLE card (
    consumerid VARCHAR2(10),
    amount     NUMBER(1)
);

INSERT INTO card (consumerid, amount) values (?, ?);

CREATE TABLE ticket (
    consumerid VARCHAR2(10),
    countnum   NUMBER(1) CHECK ( countnum < 5 )
);

INSERT INTO ticket (consumerid, countnum) values (?, ?);

SELECT * FROM ticket;
SELECT * FROM card;
SELECT c.consumerid, c.amount, t.countnum FROM card c, ticket t WHERE c.consumerid = t.consumerid;

delete from ticket;
delete from card;
commit;