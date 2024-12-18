USE [DangBaoThong_21014091]
GO
/****** Object:  Table [dbo].[catergory]    Script Date: 24/11/2024 08:38:40 PM ******/
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
/****** Object:  Table [dbo].[product]    Script Date: 24/11/2024 08:38:40 PM ******/
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
	[name] [varchar](20) NULL,
	[price] [float] NULL,
	[register_date] [date] NULL,
	[cart_id] [int] NULL,
 CONSTRAINT [PK__product__3213E83F06A20860] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[catergory] ON 

INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (8, N'Food')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (9, N'Drink')
INSERT [dbo].[catergory] ([cart_id], [name]) VALUES (10, N'Medical')
SET IDENTITY_INSERT [dbo].[catergory] OFF
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (6, N'Pro999-12', N'Japanese beef', N'Beef', 999, CAST(N'2024-11-23' AS Date), 8)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (7, N'Pro998-12', N'Vinamilk', N'Milk', 10, CAST(N'2024-11-23' AS Date), 8)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (14, N'Pro999-09', N'Phenobarbital', N'Phenobarbital', 1, CAST(N'2024-11-05' AS Date), 10)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (15, N'Pro999-10', N' Coca-Cola', N'Coca-Cola', 3, CAST(N'2024-11-13' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (16, N'Pro999-10', N'Pepsi', N'Pepsi', 3, CAST(N'2024-11-20' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (17, N'Pro999-10', N'Fanta', N'Fanta', 3, CAST(N'2024-11-06' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (18, N'Pro999-10', N'Redbull', N'Redbull', 3, CAST(N'2024-11-12' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (19, N'Pro999-10', N'Mountain Dew', N'Mountain Dew', 2, CAST(N'2024-11-13' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (20, N'Pro999-10', N'Sprite ', N'Sprite ', 2, CAST(N'2024-11-15' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (21, N'Pro999-10', N'Monster Energy', N'Monster Energy', 4, CAST(N'2024-11-18' AS Date), 9)
INSERT [dbo].[product] ([id], [code], [description], [name], [price], [register_date], [cart_id]) VALUES (22, N'Pro999-10', N'Mirinda', N'Mirinda', 2, CAST(N'2024-11-21' AS Date), 9)
SET IDENTITY_INSERT [dbo].[product] OFF
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FKeqmu682rsj0muclqll5a5uan9] FOREIGN KEY([cart_id])
REFERENCES [dbo].[catergory] ([cart_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FKeqmu682rsj0muclqll5a5uan9]
GO
