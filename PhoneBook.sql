/*****
JDBC - PhoneBook.java
*****/

create table phonebook_tb (
    name varchar2(30) primary key,
    phoneNumber varchar2(20),
    birthday date 
);

select * from tab;
desc phonebook_tb;

create sequence seq_phonebook
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

select * from user_sequences;

commit;



