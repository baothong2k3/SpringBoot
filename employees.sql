USE [employees]
GO
/****** Object:  Table [dbo].[address]    Script Date: 23/11/2024 12:48:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[address](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employee]    Script Date: 23/11/2024 12:48:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](6) NULL,
	[dob] [datetime2](6) NULL,
	[email] [varchar](255) NOT NULL,
	[first_name] [varchar](255) NOT NULL,
	[gender] [varchar](255) NULL,
	[last_name] [varchar](255) NOT NULL,
	[modified_date] [datetime2](6) NULL,
	[phone_number] [varchar](255) NULL,
	[address_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FKga73hdtpb67twlr9c1i337tyt] FOREIGN KEY([address_id])
REFERENCES [dbo].[address] ([id])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FKga73hdtpb67twlr9c1i337tyt]
GO
