#订单管理
drop table if exists th_order_manage;
#订单管理
CREATE TABLE `th_order_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单操作状态',
  `order_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单唯一编码',
  `order_time` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单时间',
  `order_phone_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订购号码',
  `prov` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '号码省份',
  `city` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '号码地市',
  `order_status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单状态',
  `customer_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '客户姓名',
  `certificate_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '证件类型',
  `certificate_num` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '证件号码',
  `customer_contact_num` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '客户联系号码',
  `good_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '商品名称',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '配送地址',
  `active_status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '激活状态',
  `cudian_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '触点编码',
  `shoucong_amt` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '首冲金额',
  `shoucong_time` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '首充时间',
  `xiehaozhuanwang_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '携号转网类型',
  `zhuanhualvtichu_reason` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '转化率踢出原因',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_code_UNIQUE` (`order_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
