DROP TABLE IF EXISTS `tblbranch`;
CREATE TABLE IF NOT EXISTS `tblbranch`(
	branchId bigint not null primary key auto_increment,
    branchCode varchar(10) not null unique,
    branchAddress text not null,
    branchCreationDT datetime default current_timestamp
);

insert into tblbranch(branchCode,branchAddress) values('JPMCHASE01','Paradigm Towers-B Wing, Mindspace, Malad Goregaon Link Rd, Malad (W), Mumbai, Maharashtra 400064');
insert into tblbranch(branchCode,branchAddress) values('JPMCHASE02','Magnus Tower, Chincholi Bunder Rd, Malad, Rajan Pada, Mindspace, Malad West, Mumbai, Maharashtra 400064');
insert into tblbranch(branchCode,branchAddress) values('JPMCHASE03','Prism Towers, Prism Tower Road, Mindspace, Malad West, Mumbai, Maharashtra 400047');


DROP TABLE IF EXISTS `tblcustomer`;
CREATE TABLE IF NOT EXISTS `tblcustomer`(
	custId bigint not null primary key auto_increment,
    custFname varchar(30) not null,
    custLname varchar(30) not null,
    custEmail varchar(50) not null unique,
    custMobile varchar(10) not null unique,
    branchId bigint not null,
    custCreationDT datetime not null default current_timestamp,
    constraint fk_branch foreign key(branchId) references tblbranch(branchId)
    on update cascade
    on delete cascade
);
truncate table tblcustomer;

DROP TABLE IF EXISTS `tblaccount`;
CREATE TABLE IF NOT EXISTS `tblaccount`(
	acctId bigint not null auto_increment,
    custId bigint not null,
    acctNo VARCHAR(11) NOT NULL DEFAULT '0',
    acctType varchar(11) not null,
    acctCreationDT datetime not null default current_timestamp,
    primary key(acctId,acctNo,custId,acctType),
    constraint fk_customer foreign key(custId) references tblcustomer(custId)
    on update cascade
    on delete cascade
);


CREATE TRIGGER after_tblaccount_insert
AFTER INSERT ON tblaccount
FOR EACH ROW
BEGIN
	UPDATE tblaccount
    SET NEW.acctNo = CONCAT('JPMC', LPAD(LAST_INSERT_ID(), 7, '0'))
    WHERE acctId=NEW.acctId;
END;