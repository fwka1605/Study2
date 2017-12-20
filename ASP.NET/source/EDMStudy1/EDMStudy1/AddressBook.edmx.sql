
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, and Azure
-- --------------------------------------------------
-- Date Created: 10/26/2016 13:52:07
-- Generated from EDMX file: C:\Users\NVLCLT13\Documents\nouvelle\study\ASP.NET\source\EDMStudy1\EDMStudy1\AddressBook.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [AddressBook];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Entries]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Entries];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Entries'
CREATE TABLE [dbo].[Entries] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [Name] nvarchar(20)  NOT NULL,
    [MailAddress] nvarchar(max)  NOT NULL,
    [TelNo] nvarchar(max)  NOT NULL,
    [Age] smallint  NOT NULL
);
GO

-- Creating table 'Categories'
CREATE TABLE [dbo].[Categories] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [CategoryName] nvarchar(max)  NOT NULL,
    [Detail] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'EntryCategory'
CREATE TABLE [dbo].[EntryCategory] (
    [Entries_ID] int  NOT NULL,
    [Categories_ID] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [ID] in table 'Entries'
ALTER TABLE [dbo].[Entries]
ADD CONSTRAINT [PK_Entries]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [ID] in table 'Categories'
ALTER TABLE [dbo].[Categories]
ADD CONSTRAINT [PK_Categories]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [Entries_ID], [Categories_ID] in table 'EntryCategory'
ALTER TABLE [dbo].[EntryCategory]
ADD CONSTRAINT [PK_EntryCategory]
    PRIMARY KEY NONCLUSTERED ([Entries_ID], [Categories_ID] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [Entries_ID] in table 'EntryCategory'
ALTER TABLE [dbo].[EntryCategory]
ADD CONSTRAINT [FK_EntryCategory_Entry]
    FOREIGN KEY ([Entries_ID])
    REFERENCES [dbo].[Entries]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating foreign key on [Categories_ID] in table 'EntryCategory'
ALTER TABLE [dbo].[EntryCategory]
ADD CONSTRAINT [FK_EntryCategory_Category]
    FOREIGN KEY ([Categories_ID])
    REFERENCES [dbo].[Categories]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;

-- Creating non-clustered index for FOREIGN KEY 'FK_EntryCategory_Category'
CREATE INDEX [IX_FK_EntryCategory_Category]
ON [dbo].[EntryCategory]
    ([Categories_ID]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------