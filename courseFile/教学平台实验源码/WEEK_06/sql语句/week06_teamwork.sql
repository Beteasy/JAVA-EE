use javaee;
 -- 对班级的操作 
select * from class;
insert into class values(1,'1班');
insert into class values(2,'2班');
insert into class values(3,'3班');
insert into class values(4,'4班');
insert into class values(5,'5班');
insert into class values(6,'6班');
insert into class values(7,'7班');
insert into class values(8,'8班');

-- 对学生的操作
select * from student;
insert into student values(1,'小赵','1',1);
update student set userName='zhao', password='123456' where stuNo=1;
insert into student values(2,'小钱','2',0,'qian','123456');
insert into student values(3,'小孙','3',0,'shun','123456');
insert into student values(4,'小李','4',0,'li','123456');
insert into student values(5,'小周','1',0,'zhou','123456');
insert into student values(6,'小吴','2',0,'wu','123456');
insert into student values(7,'小郑','3',0,'zheng','123456');
insert into student values(8,'小王','4',0,'wang','123456');
insert into student values(9,'小冯','1',0,'feng','123456');
insert into student values(10,'小陈','2',0,'chen','123456');
insert into student values(11,'小卫','3',0,'wei','123456');
insert into student values(12,'小蒋','4',0,'jiang','123456');