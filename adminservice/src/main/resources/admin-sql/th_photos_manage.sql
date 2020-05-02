#图片管理
drop table if exists th_photos_manage;
#图片管理
CREATE TABLE `th_photos_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `photo_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;