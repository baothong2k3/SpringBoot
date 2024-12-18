USE [web_customer_tracker]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 15/11/2024 01:02:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NULL,
	[first_name] [varchar](255) NULL,
	[last_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[customer] ON 

INSERT [dbo].[customer] ([id], [email], [first_name], [last_name]) VALUES (11, N'baothong15082003@gmail.com', N'Đ?ng B?o', N'Thông')
INSERT [dbo].[customer] ([id], [email], [first_name], [last_name]) VALUES (12, N'21014091.thong@student.iuh.edu.vn', N'Đ?ng', N'Thông')
INSERT [dbo].[customer] ([id], [email], [first_name], [last_name]) VALUES (13, N'playgamesbaothong1508@gmail.com', N'Dang', N'Thong')
SET IDENTITY_INSERT [dbo].[customer] OFF
