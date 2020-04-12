#销售推广管理
drop table if exists th_sale_extension_manage;
#销售推广管理
CREATE TABLE `th_sale_extension_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `share_url_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `request_url` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `source_url` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `qq` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `owner_account` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_account` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pro_phone_UNIQUE` (`product_code`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;