USE master
GO
ALTER DATABASE LMS SET MULTI_USER WITH ROLLBACK IMMEDIATE
GO

IF DB_ID('LMS') IS NOT NULL
BEGIN 
	DROP DATABASE LMS;
END

CREATE DATABASE LMS;

USE LMS;


IF OBJECT_ID('USERS','U') IS NOT NULL
BEGIN
	DROP TABLE USERS;
END;

CREATE TABLE USERS
	(
		USERID INT NOT NULL IDENTITY(1000000,1) PRIMARY KEY,
		FIRSTNAME VARCHAR(2000) NOT NULL,
		MIDDLENAME VARCHAR(2000) NULL,
		LASTNAME VARCHAR(2000) NOT NULL,
		USERNAME VARCHAR(2000) NOT NULL,
		DOB DATETIME NOT NULL,
		GENDER VARCHAR(10) NOT NULL ,
		CHANGE_PASS INT NOT NULL,
		IS_ACTIVE BIT NOT NULL DEFAULT 2, -- 0 NOT ACTIVE | 1 ACTIVE -| 2 PENDING VERIFICATION
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);



IF OBJECT_ID('USER_TYPE', 'U') IS NOT NULL
DROP TABLE USER_TYPE
GO

CREATE TABLE USER_TYPE
(
    USERTYPEID INT NOT NULL PRIMARY KEY IDENTITY(1,1), -- Primary Key column
    [NAME] NVARCHAR(100) NOT NULL,  --STUDENT AND STAFF
    [STATUS] INT NOT NULL, -- 1 - ACTIVE | 0 - INACTIVE
    [DESCRIPTION] NVARCHAR(2000) NOT NULL,
	[CREATED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	[MODIFIED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP

);
GO


IF OBJECT_ID('USER_TYPE_MAPPING', 'U') IS NOT NULL
DROP TABLE USER_TYPE_MAPPING
GO

CREATE TABLE USER_TYPE_MAPPING
(
    USERTYPEMAPPINGID INT NOT NULL PRIMARY KEY IDENTITY(1,1), -- Primary Key column
    [USER_ID] INT NOT NULL FOREIGN Key REFERENCES USERS(USERID),
    [USER_TYPE] INT NOT NULL FOREIGN KEY REFERENCES USER_TYPE(USERTYPEID),
    [CREATED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	[MODIFIED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP    
);


GO
IF OBJECT_ID('FACULTY','U') IS NOT NULL
BEGIN
	DROP TABLE FACULTY;
END;

CREATE TABLE FACULTY
	(
		FACULTYID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		FACULTYNAME VARCHAR(2000) NOT NULL,
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);



IF OBJECT_ID('STUDENT_CATEGORY','U') IS NOT NULL
BEGIN
	DROP TABLE STUDENT_CATEGORY;
END;

CREATE TABLE STUDENT_CATEGORY
	(
		CATID INT NOT NULL IDENTITY(100,1) PRIMARY KEY,
		CATEGORY VARCHAR(200) NOT NULL,
		MAX_ALLOWED INT NOT NULL,
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);


IF OBJECT_ID('STUDENT','U') IS NOT NULL
BEGIN
	DROP TABLE STUDENT;
END;

CREATE TABLE STUDENT
	(
		STUDENT_ID INT NOT NULL PRIMARY KEY FOREIGN KEY REFERENCES USERS(USERID),
		CATEGORY INT NOT NULL,
		STUDENT_FACULTY INT NOT NULL FOREIGN KEY REFERENCES FACULTY(FACULTYID),
		[YEAR] INT NOT NULL,
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);


IF OBJECT_ID('STAFF', 'U') IS NOT NULL
DROP TABLE [STAFF]
GO

CREATE TABLE STAFF
(
	STAFF_ID INT NOT NULL PRIMARY KEY FOREIGN KEY REFERENCES USERS(USERID), -- Primary Key column
	[DEPARTMENT] NVARCHAR(50) NOT NULL,
	HIRE_START_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	HIRE_END_DT DATETIME NOT NULL,
	CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
GO


IF OBJECT_ID('BOOK_CATEGORY','U') IS NOT NULL
BEGIN
	DROP TABLE BOOK_CATEGORY;
END;

CREATE TABLE BOOK_CATEGORY
	(
		BOOKCATID INT NOT NULL IDENTITY(10,1) PRIMARY KEY,
		CATEGORY VARCHAR(2000) NOT NULL,
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);


IF OBJECT_ID('BOOK','U') IS NOT NULL
BEGIN
	DROP TABLE BOOK;

END;

CREATE TABLE BOOK
	(
		BOOKID INT NOT NULL IDENTITY(100,1) PRIMARY KEY,
		TITLE VARCHAR(2000) NOT NULL,
		AUTHOR VARCHAR(2000) NOT NULL,
		DESCRIPTION TEXT NOT NULL,
		PUBLISHER TEXT NOT NULL,
		ISBN TEXT NOT NULL,
		YEAR_PUBLISHED DATETIME NULL,
		AVAILABLE_COPIES INT NOT NULL,
		CATEGORY_ID INT NOT NULL FOREIGN KEY REFERENCES BOOK_CATEGORY(BOOKCATID),
		ADDED_BY INT NOT NULL,
		CREATED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);



IF OBJECT_ID('BOOK_ISSUE_LOG','U') IS NOT NULL
BEGIN
	DROP TABLE BOOK_ISSUE_LOG;
END;

CREATE TABLE BOOK_ISSUE_LOG
	(
		BOOKISSUEID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		ID_OF_BOOK INT NOT NULL FOREIGN KEY REFERENCES BOOK(BOOKID),
		ISSUED_TO INT NOT NULL FOREIGN KEY REFERENCES USERS(USERID),
		ISSUED_BY INT NOT NULL FOREIGN KEY REFERENCES USERS(USERID),
		ISSUE_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		RETURN_DT DATETIME NOT NULL,
		MODIFIED_DT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
	);




IF OBJECT_ID('VERIFICATION', 'U') IS NOT NULL
DROP TABLE VERIFICATION
GO

CREATE TABLE VERIFICATION
(
	VERID INT NOT NULL PRIMARY KEY IDENTITY(50,1), -- Primary Key column
	VERIFICATION_STATUS TINYINT NOT NULL DEFAULT 0, --0 NOT VERIFIED | 1 VERIFIED,
	VERIFICATION_TOKEN TEXT NOT NULL,
	OWNER INT NOT NULL FOREIGN KEY REFERENCES USERS(USERID),
	[CREATED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	[VERIFIED_DT] DATETIME NOT NULL
);
GO


IF OBJECT_ID('IDENTITYPASS', 'U') IS NOT NULL
DROP TABLE IDENTITYPASS
GO

CREATE TABLE IDENTITYPASS
(
	[Id] INT NOT NULL IDENTITY(10,1) PRIMARY KEY, -- Primary Key column
	[PASSWORD] NVARCHAR(MAX) NOT NULL,
	[IS_ACTIVE] BIT NOT NULL DEFAULT 1, -- 0 NOT ACTIVE | 1 ACTIVE
	OWNER INT NOT NULL FOREIGN KEY REFERENCES USERS(USERID),
	[CREATED_DT] DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
GO

IF OBJECT_ID('EMAIL','U') IS NOT NULL
BEGIN
	DROP TABLE EMAIL;
END;

CREATE TABLE EMAIL
	(
		EMAILID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		USERID INT NOT NULL FOREIGN KEY REFERENCES USERS(USERID),
		EMAIL_ADDRESS VARCHAR(2000) NOT NULL,
		IS_PRIMARY TINYINT NOT NULL,
		CREATED_DT DATETIME DEFAULT CURRENT_TIMESTAMP,
		MODIFIED_DT DATETIME DEFAULT CURRENT_TIMESTAMP
	);