#渠道管理
drop table if exists th_channel_manage;
#渠道管理
CREATE TABLE `th_channel_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_code` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `channel_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `main_body` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contacter` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contacter_phone` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `channel_type` int(10) DEFAULT NULL,
  `jieru_way` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `meiti_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `meiti_pwd` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `meiti_account` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_card` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `open_bank_area` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `real_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;