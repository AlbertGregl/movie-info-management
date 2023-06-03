USE MovieInfoDB;
GO

-- Delete data from all tables
DELETE FROM dbo.[MovieActorDirector];
DELETE FROM dbo.[Movie];
DELETE FROM dbo.[Actor];
DELETE FROM dbo.[Director];
DELETE FROM dbo.[User];
DELETE FROM dbo.[Role];
GO

USE master
GO

DROP DATABASE MovieInfoDB
GO