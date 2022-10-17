BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE tblbranch';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE tblbranch(
	branchId number(19) not null primary key,
    branchCode varchar2(10) not null unique,
    branchAddress clob not null,
    branchCreationDT timestamp(0) default systimestamp
);

-- Generate ID using sequence and trigger
CREATE SEQUENCE tblbranch_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tblbranch_seq_tr
 BEFORE INSERT ON tblbranch FOR EACH ROW
 WHEN (NEW.branchId IS NULL)
BEGIN
 SELECT tblbranch_seq.NEXTVAL INTO :NEW.branchId FROM DUAL;
END;
/

-- SQLINES LICENSE FOR EVALUATION USE ONLY
insert into tblbranch(branchCode,branchAddress) values('JPMCHASE01','Paradigm Towers-B Wing, Mindspace, Malad Goregaon Link Rd, Malad (W), Mumbai, Maharashtra 400064');
-- SQLINES LICENSE FOR EVALUATION USE ONLY
insert into tblbranch(branchCode,branchAddress) values('JPMCHASE02','Magnus Tower, Chincholi Bunder Rd, Malad, Rajan Pada, Mindspace, Malad West, Mumbai, Maharashtra 400064');
-- SQLINES LICENSE FOR EVALUATION USE ONLY
insert into tblbranch(branchCode,branchAddress) values('JPMCHASE03','Prism Towers, Prism Tower Road, Mindspace, Malad West, Mumbai, Maharashtra 400047');


BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE tblcustomer';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE tblcustomer(
	custId number(19) not null primary key,
    custFname varchar2(30) not null,
    custLname varchar2(30) not null,
    custEmail varchar2(50) not null unique,
    custMobile varchar2(10) not null unique,
    branchId number(19) not null,
    custCreationDT timestamp(0) default systimestamp not null,
    constraint fk_branch foreign key(branchId) references tblbranch(branchId)
);

-- Generate ID using sequence and trigger
CREATE SEQUENCE tblcustomer_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tblcustomer_seq_tr
 BEFORE INSERT ON tblcustomer FOR EACH ROW
 WHEN (NEW.custId IS NULL)
BEGIN
 SELECT tblcustomer_seq.NEXTVAL INTO :NEW.custId FROM DUAL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE tblaccount';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE tblaccount(
	acctId number(19) not null,
    custId number(19) not null,
    acctNo VARCHAR2(11) DEFAULT '0' NOT NULL,
    acctType varchar2(11) not null,
    acctBal Binary_double DEFAULT 0.0 NOT NULL,
    acctCreationDT timestamp(0) default systimestamp not null,
    primary key(acctId,acctNo,custId,acctType),
    constraint fk_customer foreign key(custId) references tblcustomer(custId)
);


-- Generate ID using sequence and trigger
CREATE SEQUENCE tblaccount_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tblaccount_seq_tr
 BEFORE INSERT ON tblaccount FOR EACH ROW
 WHEN (NEW.acctId IS NULL)
BEGIN
 SELECT tblaccount_seq.NEXTVAL INTO :NEW.acctId FROM DUAL;
END;
/