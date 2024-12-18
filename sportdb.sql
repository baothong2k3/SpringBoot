USE [sportdb]
GO
/****** Object:  Table [dbo].[app_role]    Script Date: 28/11/2024 02:48:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[app_role](
	[role_id] [bigint] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[app_user]    Script Date: 28/11/2024 02:48:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[app_user](
	[user_id] [bigint] IDENTITY(1,1) NOT NULL,
	[enabled] [bit] NOT NULL,
	[encryted_password] [varchar](128) NOT NULL,
	[user_name] [varchar](36) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 28/11/2024 02:48:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[role_id] [bigint] NOT NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[app_role] ON 

INSERT [dbo].[app_role] ([role_id], [role_name]) VALUES (1, N'ADMIN')
INSERT [dbo].[app_role] ([role_id], [role_name]) VALUES (2, N'USER')
SET IDENTITY_INSERT [dbo].[app_role] OFF
SET IDENTITY_INSERT [dbo].[app_user] ON 

INSERT [dbo].[app_user] ([user_id], [enabled], [encryted_password], [user_name]) VALUES (5, 1, N'{bcrypt}$2a$10$qLrocpXKe5niys5aKaRnZe3ToA9.5GJxqSZaeHy..JRoXfmrdGINW', N'baothongAdmin')
INSERT [dbo].[app_user] ([user_id], [enabled], [encryted_password], [user_name]) VALUES (7, 1, N'{bcrypt}$2a$10$qLrocpXKe5niys5aKaRnZe3ToA9.5GJxqSZaeHy..JRoXfmrdGINW', N'baothongUser')
SET IDENTITY_INSERT [dbo].[app_user] OFF
SET IDENTITY_INSERT [dbo].[user_role] ON 

INSERT [dbo].[user_role] ([id], [role_id], [user_id]) VALUES (2, 1, 5)
INSERT [dbo].[user_role] ([id], [role_id], [user_id]) VALUES (3, 2, 7)
SET IDENTITY_INSERT [dbo].[user_role] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [APP_ROLE_UK]    Script Date: 28/11/2024 02:48:05 PM ******/
ALTER TABLE [dbo].[app_role] ADD  CONSTRAINT [APP_ROLE_UK] UNIQUE NONCLUSTERED 
(
	[role_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [APP_USER_UK]    Script Date: 28/11/2024 02:48:05 PM ******/
ALTER TABLE [dbo].[app_user] ADD  CONSTRAINT [APP_USER_UK] UNIQUE NONCLUSTERED 
(
	[user_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [USER_ROLE_UK]    Script Date: 28/11/2024 02:48:05 PM ******/
ALTER TABLE [dbo].[user_role] ADD  CONSTRAINT [USER_ROLE_UK] UNIQUE NONCLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKg7fr1r7o0fkk41nfhnjdyqn7b] FOREIGN KEY([user_id])
REFERENCES [dbo].[app_user] ([user_id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKg7fr1r7o0fkk41nfhnjdyqn7b]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKp6m37g6n6c288s096400uw8fw] FOREIGN KEY([role_id])
REFERENCES [dbo].[app_role] ([role_id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKp6m37g6n6c288s096400uw8fw]
GO
