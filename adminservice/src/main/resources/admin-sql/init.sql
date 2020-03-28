#菜单组
INSERT INTO `admin_menu_group` (`id`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`group`,`sort`) VALUES (15,'2020-03-21 00:35:57','2020-03-21 00:35:57','admin','admin','系统设置',1);

#菜单
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (49,'渠道管理','2020-03-21 00:39:49','2020-03-21 00:39:49','admin','admin','app/user/manage.html','渠道管理',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (50,'后台角色管理','2020-03-21 00:40:47','2020-03-21 00:40:47','admin','admin','app/role/role-manage.html','系统设置',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (51,'菜单管理','2020-03-21 00:41:10','2020-03-21 00:41:10','admin','admin','app/menu/manage.html','系统设置',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (52,'菜单组管理','2020-03-21 00:41:29','2020-03-21 00:41:29','admin','admin','app/menu_group/manage.html','系统设置',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (53,'角色菜单关系管理','2020-03-21 00:41:53','2020-03-21 00:41:53','admin','admin','app/role_menu_relation/role-menu-relation-manage.html','系统设置',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (54,'用户角色关系管理','2020-03-21 00:42:20','2020-03-21 00:42:20','admin','admin','app/user_role_relation/user-role-relation-manage.html','系统设置',0);
INSERT INTO `admin_menu` (`id`,`menu_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`url`,`group`,`version`) VALUES (55,'系统配置项管理','2020-03-21 00:42:38','2020-03-21 00:42:38','admin','admin','app/system_config/system-config-manage.html','系统设置',0);

#角色
INSERT INTO `admin_role` (`id`,`role_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`description`,`version`) VALUES (3,'超级管理员','2020-03-21 00:39:20','2020-03-21 00:39:20','admin','admin','超级管理员',0);

#用户
INSERT INTO `admin_user` (`id`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`account`,`password`,`version`,`token`,`expire_time`) VALUES (1,'2020-03-21 00:00:00','2020-03-21 00:00:00','sys','sys','admin','admin',1,'a865a40e-7c4e-44c7-b40c-16ee4c1682de','2020-03-28 08:53:03');

#用户角色关系表
INSERT INTO `admin_user_role_relation` (`id`,`user_id`,`role_id`,`account`,`role_name`,`gmt_create`,`gmt_modify`,`creator_account`,`modifier_account`,`description`,`version`) VALUES (13,19,3,'test1234','超级管理员','2020-03-21 00:40:10','2020-03-21 00:40:10','admin','admin',NULL,0);



