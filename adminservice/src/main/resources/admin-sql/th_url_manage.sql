#连接管理
drop table if exists th_url_manage;
#连接管理url_code 唯一编码，share_url_code 分享编码 编号、商户名称、开票主体、产品名称、产品类型、产品渠道码、产品链接、链接状态、所属业务线、渠道号、有效时间
CREATE TABLE `th_url_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `share_url_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `open_ticket_main_body` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_qudao_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(2048) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url_status` int(10) DEFAULT NULL,
  `biz_line` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `channel_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `youxiao_time` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `owner_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
