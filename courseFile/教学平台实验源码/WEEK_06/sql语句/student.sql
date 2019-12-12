use javaee;
select * from student;

update student set phoneNumber="15717854321" where stuNo=1;
update student set phoneNumber="18503266663" where stuNo=2;
update student set phoneNumber="18112345672" where stuNo=3;
update student set phoneNumber="17603222229" where stuNo=4;
update student set phoneNumber="18533263326" where stuNo=5;
update student set phoneNumber="15717854321" where stuNo=6;
update student set phoneNumber="15717854321" where stuNo=7;
update student set phoneNumber="15717854321" where stuNo=8;
update student set phoneNumber="15717854321" where stuNo=9;
update student set phoneNumber="15717854321" where stuNo=10;
update student set phoneNumber="15717854321" where stuNo=11;
update student set phoneNumber="15717854321" where stuNo=12;

update student set stuPermission=1 where stuNo=2;
update student set stuPermission=1 where stuNo=3;
update student set stuPermission=1 where stuNo=4;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456789';