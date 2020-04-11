#模版管理
drop table if exists th_template_manage;
#模版管理
CREATE TABLE `th_template_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `template_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `banner1` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `banner2` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sub_product` varchar(4096) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;