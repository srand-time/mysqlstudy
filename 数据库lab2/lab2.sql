/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/9 20:38:29                            */
/*==============================================================*/




drop table if exists Detailed_of_bank_lend_table;

drop table if exists bank_lend_table;

drop table if exists bank_table;

drop table if exists checking_account_table;


drop table if exists customer_account_table;

drop table if exists customer_contactor_table;

drop table if exists customer_employee_table;


drop table if exists customer_table;

drop table if exists department_table;

drop table if exists employee_table;

drop table if exists manager_table;

drop table if exists saving_account_table;

/*==============================================================*/
/* Table: Detailed_of_bank_lend_table                           */
/*==============================================================*/
create table Detailed_of_bank_lend_table
(
   lend_id              char(15) not null  comment '',
   sub_lend_id          int(4) not null  comment '',
   money                bigint(11) not null  comment '',
   recieve_customer_idcard_number char(20) not null  comment '',
   primary key (lend_id, sub_lend_id)
);

/*==============================================================*/
/* Table: bank_lend_table                                       */
/*==============================================================*/
create table bank_lend_table
(
   id                   char(15) not null  comment '',
   money                bigint(12) not null  comment '',
   load_bank_name       char(20) not null  comment '',
	state                int(1) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: bank_table                                            */
/*==============================================================*/
create table bank_table
(
   bank_name            char(20) not null  comment '',
   city                 char(15) not null  comment '',
   money                bigint(14) not null  comment '',
   primary key (bank_name)
);

/*==============================================================*/
/* Table: checking_account_table                                */
/*==============================================================*/
create table checking_account_table
(
   id                   char(18) not null  comment '',
   money                bigint(12) not null  comment '',
   open_date            date not null  comment '',
   overdraft            int(9) not null  comment '',
   primary key (id)
);

/*==============================================================*/
/* Table: customer_account_table                                */
/*==============================================================*/
create table customer_account_table
(
   idcard_number        char(20) not null  comment '',
   bank_name            char(20) not null  comment '',
   account1_id          char(18)  comment '',
   account2_id          char(18)  comment '',
   visitdate1           datetime  comment '',
   visitdate2           datetime  comment '',
   primary key (idcard_number, bank_name)
);

/*==============================================================*/
/* Table: customer_contactor_table                              */
/*==============================================================*/
create table customer_contactor_table
(
   id                   int(11) not null  auto_increment,
   name                 char(15) not null  comment '',
   phone_number         char(15)  comment '',
   email                char(20)  comment '',
   primary key (id)
);

/*==============================================================*/
/* Table: customer_employee_table                               */
/*==============================================================*/
create table customer_employee_table
(
   cusomer_id           char(20) not null  comment '',
   loan_employee_id     char(20)  comment '',
   account_employee_id  char(20)  comment '',
   primary key (cusomer_id)
);

/*==============================================================*/
/* Table: customer_table                                        */
/*==============================================================*/
create table customer_table
(
   idcard_number        char(20) not null  comment '',
   name                 char(15) not null  comment '',
   phone_number         char(15)  comment '',
   contactor_id         int(11)  comment '',
   relationship         int(2)  comment '',
   live_place           char(20)  comment '',
   primary key (idcard_number)
);

/*==============================================================*/
/* Table: department_table                                      */
/*==============================================================*/
create table department_table
(
   id                   int(4) not null  comment '',
   name                 char(20) not null  comment '',
   type                 int(3)  comment '',
   primary key (id)
);

/*==============================================================*/
/* Table: employee_table                                        */
/*==============================================================*/
create table employee_table
(
   idcard_num           char(20) not null  comment '',
   name                 char(15) not null  comment '',
   phone_number         char(15)  comment '',
   live_place           char(20)  comment '',
   start_work_date      date not null  comment '',
   manager_idcard_number char(20) not null  comment '',
   primary key (idcard_num)
);

/*==============================================================*/
/* Table: manager_table                                         */
/*==============================================================*/
create table manager_table
(
   idcard_number        char(20) not null  comment '',
   name                 char(15) not null  comment '',
   phone_number         char(15)  comment '',
   live_place           char(20)  comment '',
   dpartment_id         int(4) not null  comment '',
   start_work_date      date not null  comment '',
   primary key (idcard_number)
);

/*==============================================================*/
/* Table: saving_account_table                                  */
/*==============================================================*/
create table saving_account_table
(
   id                   char(18) not null  comment '',
   money                bigint(12) not null  comment '',
   open_date            date not null  comment '',
   interest_rate        float(6,3) not null  comment '',
   currency_type        int(3) not null  comment '',
   primary key (id)
);

alter table Detailed_of_bank_lend_table add constraint FK_DETAILED_REFERENCE_BANK_LEN foreign key (lend_id)
      references bank_lend_table (id) on delete restrict on update restrict;

alter table Detailed_of_bank_lend_table add constraint FK_DETAILED_REFERENCE_CUSTOMER foreign key (recieve_customer_idcard_number)
      references customer_table (idcard_number) on delete restrict on update restrict;

alter table bank_lend_table add constraint FK_BANK_LEN_REFERENCE_BANK_TAB foreign key (load_bank_name)
      references bank_table (bank_name) on delete restrict on update restrict;

alter table customer_account_table add constraint FK_CUSTOMER_REFERENCE_BANK_TAB foreign key (bank_name)
      references bank_table (bank_name) on delete restrict on update restrict;

alter table customer_account_table add constraint FK_CUSTOMER_REFERENCE_SAVING_A foreign key (account1_id)
      references saving_account_table (id) on delete restrict on update restrict;

alter table customer_account_table add constraint FK_CUSTOMER_REFERENCE_CHECKING foreign key (account2_id)
      references checking_account_table (id) on delete restrict on update restrict;

alter table customer_account_table add constraint FK_CUSTOMER_REFERENCE_CUSTOMER_1 foreign key (idcard_number)
      references customer_table (idcard_number) on delete restrict on update restrict;

alter table customer_employee_table add constraint FK_CUSTOMER_REFERENCE_CUSTOMER_2 foreign key (cusomer_id)
      references customer_table (idcard_number) on delete restrict on update restrict;

alter table customer_employee_table add constraint FK_CUSTOMER_REFERENCE_EMPLOYEE_1 foreign key (loan_employee_id)
      references employee_table (idcard_num) on delete restrict on update restrict;

alter table customer_employee_table add constraint FK_CUSTOMER_REFERENCE_EMPLOYEE_2 foreign key (account_employee_id)
      references employee_table (idcard_num) on delete restrict on update restrict;

alter table customer_table add constraint FK_CUSTOMER_REFERENCE_CUSTOMER_3 foreign key (contactor_id)
      references customer_contactor_table (id) on delete restrict on update restrict;

alter table employee_table add constraint FK_EMPLOYEE_REFERENCE_MANAGER_ foreign key (manager_idcard_number)
      references manager_table (idcard_number) on delete restrict on update restrict;

alter table manager_table add constraint FK_MANAGER__REFERENCE_DEPARTME foreign key (dpartment_id)
      references department_table (id) on delete restrict on update restrict;

