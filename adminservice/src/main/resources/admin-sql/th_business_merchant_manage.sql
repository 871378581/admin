#商户管理
drop table if exists th_business_merchant_manage;
#商户管理 商户名称、商户简称、商户编码、联系电话、联系人、联系email 商户状态、描述
CREATE TABLE `th_business_merchant_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_short_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_status` int(10) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `business_code_UNIQUE` (`business_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;