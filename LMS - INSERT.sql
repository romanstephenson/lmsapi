USE LMS;

DELETE FROM BOOK_CATEGORY;
INSERT INTO [dbo].[BOOK_CATEGORY]
( -- Columns to insert data into
 [CATEGORY]
)
VALUES
( 'Romance' ),
( 'Horror' ),
( 'Mystery' ),
( 'History' ),
( 'Young Adult' ),
( 'Fiction' ),
( 'Adventure' ),
( 'Science Fiction' ),
( 'Fantasy' ),
( 'Classics' ),
( 'Suspense' ),
( 'Autobiography' ),
( 'Dystopian' ),
( 'Poetry' ),
( 'Political Genre' ),
( 'Cookbooks' ),
( 'Thriller' )
GO


DELETE FROM FACULTY;
INSERT INTO [dbo].[FACULTY]
( -- Columns to insert data into
 FACULTYNAME
)
VALUES
( 'Engineering' ),
( 'Law' ),
( 'Social Sciences' ),
( 'Science & Technology' ),
( 'Sport' ),
( 'Medical Sciences' ),
( 'Humanities & Education' )

GO


DELETE FROM STUDENT_CATEGORY;
INSERT INTO [dbo].[STUDENT_CATEGORY]
( -- Columns to insert data into
 [CATEGORY],
 [MAX_ALLOWED]
)
VALUES
( 'Resident Student', 5000 ),
( 'International Student', 1000 ),
( 'Reserved Student', 500 )

GO

DELETE FROM USER_TYPE;
INSERT INTO [dbo].[USER_TYPE]
( -- Columns to insert data into
 [NAME],
 [STATUS],
 [DESCRIPTION]
)
VALUES
( 'Staff', 1 , 'Persons who work for the company'),
( 'Student', 1 , 'Students from Universities'),
( 'Admin', 1 , 'Administrators of the Libray Management System')

GO

SELECT * FROM [DBO].[USER] where ID = 1000010

SELECT * FROM [dbo].[USER_TYPE]

SELECT * FROM [dbo].[STUDENT_CATEGORY]

SELECT * FROM USER_TYPE_MAPPING WHERE USER_TYPE = 2 ORDER BY USER_ID ASC

SELECT * FROM [dbo].[FACULTY]

SELECT * FROM DBO.EMAIL

SELECT * FROM [dbo].[BOOK_CATEGORY]
