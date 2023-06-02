-- Creating the database
CREATE DATABASE MovieInfoDB;
GO

USE MovieInfoDB;
GO

-- Creating Role Table
CREATE TABLE dbo.[Role] (
    RoleID INT PRIMARY KEY IDENTITY(1,1),
    RoleName NVARCHAR(50) NOT NULL
);
GO

-- Creating User Table
CREATE TABLE dbo.[User] (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    RoleID INT NOT NULL,
    FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);
GO

-- Creating Movie Table
CREATE TABLE dbo.[Movie] (
    MovieID INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(100) NOT NULL,
    Genre NVARCHAR(50),
    ReleaseYear INT,
    ImagePath NVARCHAR(255)
);
GO

-- Creating Actor Table
CREATE TABLE dbo.[Actor] (
    ActorID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    DOB DATE,
    ImagePath NVARCHAR(255)
);
GO

-- Creating Director Table
CREATE TABLE dbo.[Director] (
    DirectorID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    DOB DATE,
    ImagePath NVARCHAR(255)
);
GO

-- Creating MovieActorDirector Table
CREATE TABLE dbo.[MovieActorDirector] (
    MovieID INT NOT NULL,
    ActorID INT NOT NULL,
    DirectorID INT NOT NULL,
    PRIMARY KEY (MovieID, ActorID, DirectorID),
    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    FOREIGN KEY (ActorID) REFERENCES Actor(ActorID),
    FOREIGN KEY (DirectorID) REFERENCES Director(DirectorID)
);
GO
