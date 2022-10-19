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
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table tblloanType(
	loanTypeId NUMBER(19) NOT NULL PRIMARY KEY,
    loanType VARCHAR2(3) NOT NULL UNIQUE,
    loanTypeDesc VARCHAR2(20) NOT NULL
);

-- Generate ID using sequence and trigger
create sequence tblloanType_seq start with 1 increment by 1;

create or replace trigger tblloanType_seq_tr
 before insert on tblloanType for each row
 when (new.loanTypeId is null)
begin
 select tblloanType_seq.nextval into :new.loanTypeId from dual;
end;
/

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table tblloan(
loanId  NUMBER(19) NOT NULL PRIMARY KEY,
loanAcctNo VARCHAR2(11) NOT NULL unique,
            loanStartDate DATE NOT NULL,
    loanTenure NUMBER(10) NOT NULL,
            loanType VARCHAR2(3) NOT NULL,
    loanROI binary_double NOT NULL,
            loanCreationDT TIMESTAMP(0) default systimestamp NOT NULL,
    loanAmount BINARY_DOUBLE NOT NULL,
            loanPendingAmount BINARY_DOUBLE NOT NULL,
    acctNo VARCHAR2(11) NOT NULL
);

-- Generate ID using sequence and trigger
create sequence tblloan_seq start with 1 increment by 1;

create or replace trigger tblloan_seq_tr
 before insert on tblloan for each row
 when (new.loanId is null)
begin
 select tblloan_seq.nextval into :new.loanId from dual;
end;
/
-- SQLINES LICENSE FOR EVALUATION USE ONLY
insert into tblloantype(loanType,loanTypeDesc)
coalesce('PL','Personal Loan'),('BL','Business Loan'),('2WL','Two Wheeler Loan'),('HL','Home Loan'),('GL','Gold Loan'),('4WL','Four Wheeler Loan');