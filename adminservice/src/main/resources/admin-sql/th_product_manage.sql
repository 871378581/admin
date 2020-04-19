#产品管理
drop table if exists th_product_manage;
#产品管理 type 类型：金融、CPS、通信、结算模式（CPA、CPS）、结算公式（）结算字段 * 结算值 是否二次开发
#渠道码channel_code
CREATE TABLE `th_product_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `channel_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `template_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,

  `settle_mode` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `settle_column` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `settle_value` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,

  `shifou_2_kaifa` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `source_url` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_status` int(10) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;