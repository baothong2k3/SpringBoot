USE [QL_GiangVien_DeTai]
GO
/****** Object:  Table [dbo].[detai]    Script Date: 15/11/2024 06:56:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[detai](
	[madetai] [int] IDENTITY(1,1) NOT NULL,
	[motadetai] [varchar](255) NULL,
	[nam] [varchar](255) NOT NULL,
	[tendt] [varchar](100) NOT NULL,
	[urlhinh] [varchar](255) NULL,
	[magv] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[madetai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[giangvien]    Script Date: 15/11/2024 06:56:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[giangvien](
	[magv] [int] IDENTITY(1,1) NOT NULL,
	[dienthoai] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[linhvucnghiencuu] [varchar](255) NULL,
	[tengv] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[magv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[detai] ON 

INSERT [dbo].[detai] ([madetai], [motadetai], [nam], [tendt], [urlhinh], [magv]) VALUES (6, N'JavaScript is the most popular and widely used client-side scripting language.', N'2024', N'JavaScript Tutorial', N'/image/javascript-illustration.png', 1)
INSERT [dbo].[detai] ([madetai], [motadetai], [nam], [tendt], [urlhinh], [magv]) VALUES (7, N'Python is a general-purpose high-level programming language and is widely used among the developers’ community.', N'2024', N'How To Learn Python From Scratch', N'/image/Python-Tutorial1.png', 1)
INSERT [dbo].[detai] ([madetai], [motadetai], [nam], [tendt], [urlhinh], [magv]) VALUES (8, N'This Java Tutorial is designed for beginners as well as experienced professionals.', N'2024', N'Java Tutorial', N'/image/Java-programming.png', 2)
SET IDENTITY_INSERT [dbo].[detai] OFF
SET IDENTITY_INSERT [dbo].[giangvien] ON 

INSERT [dbo].[giangvien] ([magv], [dienthoai], [email], [linhvucnghiencuu], [tengv]) VALUES (1, N'0058767459', N'baothong1508@gmail.com.vn', N'Java', N'Dang Thong')
INSERT [dbo].[giangvien] ([magv], [dienthoai], [email], [linhvucnghiencuu], [tengv]) VALUES (2, N'0745905678', N'baothong15082003@gmail.com.vn', N'Python', N'Dang Bao Thong')
INSERT [dbo].[giangvien] ([magv], [dienthoai], [email], [linhvucnghiencuu], [tengv]) VALUES (3, N'6780745905', N'baothong2003@gmail.org.vn', N'JavaScript', N'BaoThong')
SET IDENTITY_INSERT [dbo].[giangvien] OFF
ALTER TABLE [dbo].[detai]  WITH CHECK ADD  CONSTRAINT [FKekllckcb98ign8sdhnbknbprs] FOREIGN KEY([magv])
REFERENCES [dbo].[giangvien] ([magv])
GO
ALTER TABLE [dbo].[detai] CHECK CONSTRAINT [FKekllckcb98ign8sdhnbknbprs]
GO
