USE [AddressBook];
GO

drop procedure [dbo].[select_categories]
go

CREATE PROCEDURE [dbo].[select_categories]
AS
select ID,CategoryName from [categories]
GO

drop procedure [dbo].[update_age]
go

CREATE PROCEDURE [dbo].[update_age]
(
  @name nvarchar(100),
  @age int
)
AS
UPDATE [entries] set [age]=@age where [name]=@name
GO
