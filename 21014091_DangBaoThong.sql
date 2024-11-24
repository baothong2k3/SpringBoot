USE [DangBaoThong_21014091]
GO
/****** Object:  Table [dbo].[catergory]    Script Date: 24/11/2024 12:56:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[catergory](
	[cart_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[cart_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product]    Script Date: 24/11/2024 12:56:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[price] [float] NULL,
	[register_date] [datetime2](6) NULL,
	[cart_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[catergory] ON 

INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (1, N'CH')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (2, N'XT')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (3, N'L')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (4, N'TEST')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (5, N'TEST')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (6, N'TEST')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (7, N'A')
SET IDENTITY_INSERT [dbo].[catergory] OFF
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (1, N'1', N'11', N'11', 11, CAST(N'2024-10-10 00:00:00.0000000' AS DateTime2), 1)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (2, N'1', N'1', N'1', 1, CAST(N'2024-11-23 00:55:00.0000000' AS DateTime2), 1)
SET IDENTITY_INSERT [dbo].[product] OFF
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FKeqmu682rsj0muclqll5a5uan9] FOREIGN KEY([cart_id])
REFERENCES [dbo].[catergory] ([cart_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FKeqmu682rsj0muclqll5a5uan9]
GO
