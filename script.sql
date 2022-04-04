drop database agenda;
create database agenda;
use agenda;

create table PHONEBOOK(
nameR varChar(15) not null,
num int not null,
mail varChar(64),

primary key(num)
);

use agenda;
select * from PHONEBOOK;

/*
CREATE USER 'root'@'localhost' IDENTIFIED BY 'password'; 
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost';
*/