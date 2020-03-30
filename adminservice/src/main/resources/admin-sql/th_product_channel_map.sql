#产品渠道映射
drop table if exists th_product_channel_map;
#产品管理
CREATE TABLE `th_product_channel_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `biz_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_onwer_account` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `prodco_onwacc_UNIQUE` (`product_code`,`product_onwer_account` )
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;