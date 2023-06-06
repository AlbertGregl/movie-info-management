-- Creating the database
CREATE DATABASE MovieInfoDB;
GO

USE MovieInfoDB;
GO

------------------------------------------------------------
------------------------------------------------------------

-- Creating Role Table
CREATE TABLE dbo.[Role] (
    RoleID INT PRIMARY KEY IDENTITY(1,1),
    RoleName NVARCHAR(50) NOT NULL
);
GO

INSERT INTO dbo.[Role] (RoleName) VALUES ('ADMINISTRATOR'), ('USER');

-- Retrieve a role by id
CREATE PROCEDURE selectRole
    @roleID INT
AS
BEGIN
    SELECT * FROM dbo.[Role]
    WHERE RoleID = @roleID;
END;
GO


------------------------------------------------------------
------------------------------------------------------------

-- Creating User Table
CREATE TABLE dbo.[User] (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    RoleID INT NOT NULL,
    FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);
GO

INSERT INTO dbo.[User] (Username, Password, RoleID) VALUES ('milica', 'milica', 2), ('pero', 'pero', 2), ('admin', 'admin', 1);

-- Add a new user
CREATE PROCEDURE addUser
    @username NVARCHAR(50),
    @password NVARCHAR(50),
    @roleID INT
AS
BEGIN
    INSERT INTO dbo.[User] (Username, Password, RoleID)
    VALUES (@username, @password, @roleID);
END;
GO

-- Delete a user
CREATE PROCEDURE deleteUser
    @userID INT
AS
BEGIN
    DELETE FROM dbo.[User] 
    WHERE UserID = @userID;
END;
GO

-- Update a user
CREATE PROCEDURE updateUser
    @userID INT,
    @username NVARCHAR(50),
    @password NVARCHAR(50),
    @roleID INT
AS
BEGIN
    UPDATE dbo.[User]
    SET Username = @username,
        Password = @password,
        RoleID = @roleID
    WHERE UserID = @userID;
END;
GO

-- Retrieve a user by id
CREATE PROCEDURE selectUser
    @userID INT
AS
BEGIN
    SELECT * FROM dbo.[User]
    WHERE UserID = @userID;
END;
GO

-- Retrieve a user by username
CREATE PROCEDURE selectUserByUsername
    @username NVARCHAR(50)
AS
BEGIN
    SELECT * FROM dbo.[User]
    WHERE Username = @username;
END;
GO

-- Retrieve all users
CREATE PROCEDURE selectAllUsers
AS
BEGIN
    SELECT * FROM dbo.[User];
END;
GO


------------------------------------------------------------
------------------------------------------------------------

-- Creating Movie Table
CREATE TABLE dbo.[Movie] (
    MovieID INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(100) NOT NULL,
    Genre NVARCHAR(50),
    ReleaseYear INT,
    ImagePath NVARCHAR(255)
);
GO

-- Add a new movie
CREATE PROCEDURE addMovie
    @title NVARCHAR(100),
    @genre NVARCHAR(50),
    @releaseYear INT,
    @imagePath NVARCHAR(255)
AS
BEGIN
    INSERT INTO dbo.[Movie] (Title, Genre, ReleaseYear, ImagePath)
    VALUES (@title, @genre, @releaseYear, @imagePath);
END;
GO

-- Delete a movie
CREATE PROCEDURE deleteMovie
    @movieID INT
AS
BEGIN
    DELETE FROM dbo.[Movie] 
    WHERE MovieID = @movieID;
END;
GO

-- Update a movie
CREATE PROCEDURE updateMovie
    @movieID INT,
    @title NVARCHAR(100),
    @genre NVARCHAR(50),
    @releaseYear INT,
    @imagePath NVARCHAR(255)
AS
BEGIN
    UPDATE dbo.[Movie]
    SET Title = @title,
        Genre = @genre,
        ReleaseYear = @releaseYear,
        ImagePath = @imagePath
    WHERE MovieID = @movieID;
END;
GO

-- Retrieve a movie by id
CREATE PROCEDURE selectMovie
    @movieID INT
AS
BEGIN
    SELECT * FROM dbo.[Movie]
    WHERE MovieID = @movieID;
END;
GO

-- Retrieve all movies
CREATE PROCEDURE selectAllMovies
AS
BEGIN
    SELECT * FROM dbo.[Movie];
END;
GO


------------------------------------------------------------
------------------------------------------------------------

-- Creating Actor Table
CREATE TABLE dbo.[Actor] (
    ActorID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    DOB DATE,
    ImagePath NVARCHAR(255)
);
GO

-- Add a new actor
CREATE PROCEDURE addActor
    @name NVARCHAR(100),
    @dob DATE,
    @imagePath NVARCHAR(255)
AS
BEGIN
    INSERT INTO dbo.[Actor] (Name, DOB, ImagePath)
    VALUES (@name, @dob, @imagePath);
END;
GO

-- Delete an actor
CREATE PROCEDURE deleteActor
    @actorID INT
AS
BEGIN
    DELETE FROM dbo.[Actor] 
    WHERE ActorID = @actorID;
END;
GO

-- Update an actor
CREATE PROCEDURE updateActor
    @actorID INT,
    @name NVARCHAR(100),
    @dob DATE,
    @imagePath NVARCHAR(255)
AS
BEGIN
    UPDATE dbo.[Actor]
    SET Name = @name,
        DOB = @dob,
        ImagePath = @imagePath
    WHERE ActorID = @actorID;
END;
GO

-- Retrieve an actor by id
CREATE PROCEDURE selectActor
    @actorID INT
AS
BEGIN
    SELECT * FROM dbo.[Actor]
    WHERE ActorID = @actorID;
END;
GO

-- Retrieve all actors
CREATE PROCEDURE selectAllActors
AS
BEGIN
    SELECT * FROM dbo.[Actor];
END;
GO


------------------------------------------------------------
------------------------------------------------------------

-- Creating Director Table
CREATE TABLE dbo.[Director] (
    DirectorID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    DOB DATE,
    ImagePath NVARCHAR(255)
);
GO

-- Add a new director
CREATE PROCEDURE addDirector
    @name NVARCHAR(100),
    @dob DATE,
    @imagePath NVARCHAR(255)
AS
BEGIN
    INSERT INTO dbo.[Director] (Name, DOB, ImagePath)
    VALUES (@name, @dob, @imagePath);
END;
GO

-- Delete a director
CREATE PROCEDURE deleteDirector
    @directorID INT
AS
BEGIN
    DELETE FROM dbo.[Director] 
    WHERE DirectorID = @directorID;
END;
GO

-- Update a director
CREATE PROCEDURE updateDirector
    @directorID INT,
    @name NVARCHAR(100),
    @dob DATE,
    @imagePath NVARCHAR(255)
AS
BEGIN
    UPDATE dbo.[Director]
    SET Name = @name,
        DOB = @dob,
        ImagePath = @imagePath
    WHERE DirectorID = @directorID;
END;
GO

-- Retrieve a director by id
CREATE PROCEDURE selectDirector
    @directorID INT
AS
BEGIN
    SELECT * FROM dbo.[Director]
    WHERE DirectorID = @directorID;
END;
GO

-- Retrieve all directors
CREATE PROCEDURE selectAllDirectors
AS
BEGIN
    SELECT * FROM dbo.[Director];
END;
GO


------------------------------------------------------------
------------------------------------------------------------

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


-- Add a new record
CREATE PROCEDURE addMovieActorDirector
    @movieID INT,
    @actorID INT,
    @directorID INT
AS
BEGIN
    INSERT INTO dbo.[MovieActorDirector] (MovieID, ActorID, DirectorID)
    VALUES (@movieID, @actorID, @directorID);
END;
GO

-- Delete a record
CREATE PROCEDURE deleteMovieActorDirector
    @movieID INT,
    @actorID INT,
    @directorID INT
AS
BEGIN
    DELETE FROM dbo.[MovieActorDirector] 
    WHERE MovieID = @movieID AND ActorID = @actorID AND DirectorID = @directorID;
END;
GO

-- Retrieve a record by MovieID, ActorID, and DirectorID
CREATE PROCEDURE selectMovieActorDirector
    @movieID INT,
    @actorID INT,
    @directorID INT
AS
BEGIN
    SELECT * FROM dbo.[MovieActorDirector]
    WHERE MovieID = @movieID AND ActorID = @actorID AND DirectorID = @directorID;
END;
GO

-- Retrieve all records
CREATE PROCEDURE selectAllMovieActorDirectors
AS
BEGIN
    SELECT * FROM dbo.[MovieActorDirector];
END;
GO

------------------------------------------------------------
------------------------------------------------------------