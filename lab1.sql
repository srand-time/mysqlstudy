#创建表的过程
CREATE TABLE BOOK(
  	id CHAR(8)  NOT NULL,
  	name VARCHAR(10) NOT NULL,
  	author VARCHAR(10) NOT NULL,
	price FLOAT NOT NULL,
  	status INT NOT NULL,
  	PRIMARY KEY(id)
	) Engine=INNODB DEFAULT CHARSET=UTF8;

	CREATE TABLE READER(
  	id CHAR(8)  NOT NULL,
  	name VARCHAR(10) NOT NULL,
  	age INT NOT NULL,
	address VARCHAR(20),
  	PRIMARY KEY(id)
	) Engine=INNODB DEFAULT CHARSET=UTF8;

	CREATE TABLE BORROW(
	book_id CHAR(8) NOT NULL,
	reader_id CHAR(8) NOT NULL,
	borrow_date date NOT NULL,
	return_date date,
	PRIMARY KEY(book_id,reader_id)
	)Engine=INNODB DEFAULT CHARSET=UTF8;

	alter table borrow ADD CONSTRAINT fk_emp_dept1
	FOREIGN KEY(book_id) REFERENCES book(id);

	alter table borrow ADD CONSTRAINT fk_emp_dept2
	FOREIGN KEY(reader_id) REFERENCES reader(id);



#插入数据
INSERT INTO BOOK(id,name,author,price,status) VALUES('CB114','DIV','Ullman',20.22,1),('CB113','SUB','Ullman',13.15,1),('AD002','LOOP','RUA',17.32,1),
	('AD004','JMP','RUA',16.31,1),('AD003','BEQ','RUA',18.35,1),('GC007','DAW','CCCP',8.37,1),('GC1917','LN','CCCP',9.57,1),('GC1990','GDT','CCCP',8.58,1);

INSERT INTO READER(id,name,age,address) VALUES ('CP001','SDL',103,'SOV'),('CH001','CHM',25,'CHN'),('PB003','ROSE',18,'UST'),('PB010','LINI',20,'UST');

INSERT INTO BORROW(book_id,reader_id,borrow_date,return_date) VALUES('CB114','PB003','2012-12-1',NULL),('CB113','PB003','2012-12-25','2013-5-6'),			('AD002','PB003','2018-11-2','2019-12-3'),('GC007','PB010','2017-1-1',NULL),('GC1990','PB010','2017-1-1',NULL);
INSERT INTO BORROW(book_id,reader_id,borrow_date,return_date) VALUES('AD004','PB010','2016-5-6','2017-1-1');



#创建触发器
delimiter $$
	create trigger borrowbook1 after insert on borrow for each row
	begin
    		update book set status=1 where id = new.book_id and new.return_date is null;
		update book set status=0 where id = new.book_id and new.return_date is not null;
	end
	$$
	delimiter ;


	delimiter $$
	create trigger borrowbook2 after update on borrow for each row
	begin
    		update book set status=1 where id = new.book_id and new.return_date is null;
		update book set status=0 where id = new.book_id and new.return_date is not null;
	end
	$$
	delimiter ;
    
    

#9个查询语句
#先创建一个通用视图：
	create view l1v1 as select 
			borrow.book_id,borrow.reader_id,borrow.borrow_date,borrow.return_date,reader.name as rname,
			reader.age as rage,reader.address as rad,book.name as bname,book.author as bauthor,book.price as bprice ,book.status as bs
			from book,reader,borrow where book.id=borrow.book_id and reader.id=borrow.reader_id;

#预先显示三个表的内容以及联合表的内容
	select * from book;
	select * from reader;
    select * from borrow;
    select * from l1v1;

	#查询1.	
    select id,address from reader where name='ROSE'; 
	#查询2.	
    select bname,borrow_date from l1v1 where rname='ROSE';
	#查询3.	
	select name from reader left join borrow on reader.id=borrow.reader_id where book_id is NULL;
	#查询4.	
    select name,price from book where author='Ullman';
	#查询5.	
    select book_id,bname from l1v1 where rname='LINI';
	#查询6.	
    select rname from l1v1 group by rname having count(rname)>=3;
	#查询7.	
    select rname,reader_id from l1v1 where rname!='LINI';
	#查询8.	
    select name,id from book where name like '%D%';
	#查询9.	
    create view l1v2 as select reader_id,rname,book_id,bname,borrow_date from l1v1;
	#先创建一个视图含读者号、姓名、所借图书号、图书名和借期；
		select distinct rname,reader_id,count(book_id) as num_of_borrow_book from l1v2 group by rname;
        
        
	
    
    delimiter $$
	create procedure updatebookid(old char(8),new char(8))
	begin
    		insert into book(id,name,author,price,status) select id='',name,author,price,status from book where id=old; 
		#复制记录，此时id默认为0
		update book set id=new where id='0';		
			#将默认为0的id值改为新的id值
		update borrow set book_id=new where book_id=old;  
			#将borrow表中的id值改变
		delete from book where id=old;			
			#删除原来id值的记录
	end
	$$
	delimiter ;


	#调用该过程	call updatebookid('原来的id','新的id');