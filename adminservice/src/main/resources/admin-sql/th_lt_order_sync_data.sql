#联通数据同步表
drop table if exists th_lt_order_sync_data;
##联通数据同步表
CREATE TABLE `th_lt_order_sync_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `channel_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `extend` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pacakge_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pacakge_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contract_period` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `discount_amount` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `access_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `addressee` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `addressee_phone` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `selected_phone_num` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `freeze` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `freeze_amount` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `order_create_time` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,

  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;