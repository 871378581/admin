#订单管理 金融订单管理
drop table if exists th_order_for_jinrong_manage;
#订单管理 日期，产品名称，渠道码，注册，新户，进件，激活，授信，核卡，下款，下款金额。
CREATE TABLE `th_order_for_jinrong_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单操作状态',
  `order_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单唯一编码',
  `channel_account` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '渠道账号',
  `order_time` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '订单时间',
  `product_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '产品名称',
  `channel_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '渠道码',
  `zhuce` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '注册',
  `xinhu` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '新户',
  `jinjian` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '进件',
  `jihuo` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '激活',
  `shouxin` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '授信',
  `heka` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '核卡',
  `xiakuan` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '下款',
  `xiakuan_amt` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL comment '下款金额',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `creator_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modifier_account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_code_UNIQUE` (`order_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
