/*
 Navicat Premium Data Transfer

 Source Server         : postgres@docker-hadoop104
 Source Server Type    : PostgreSQL
 Source Server Version : 120001
 Source Host           : hadoop104:5432
 Source Catalog        : db01
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120001
 File Encoding         : 65001

 Date: 16/09/2021 18:35:34
*/


-- ----------------------------
-- Table structure for jctb_contrast_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_contrast_detail";
CREATE TABLE "public"."jctb_contrast_detail" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "status" int2,
  "fail" varchar(255) COLLATE "pg_catalog"."default",
  "info" varchar(255) COLLATE "pg_catalog"."default",
  "origin_count" int4,
  "result_count" int4
)
;

-- ----------------------------
-- Records of jctb_contrast_detail
-- ----------------------------
INSERT INTO "public"."jctb_contrast_detail" VALUES (28, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511824', '石棉县', 2, '', '', 1, 1);
INSERT INTO "public"."jctb_contrast_detail" VALUES (2, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330111', '富阳区', 2, '', '', 147, 147);
INSERT INTO "public"."jctb_contrast_detail" VALUES (3, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330110', '余杭区', 2, '', '', 205, 205);
INSERT INTO "public"."jctb_contrast_detail" VALUES (4, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330109', '萧山区', 2, '', '', 170, 170);
INSERT INTO "public"."jctb_contrast_detail" VALUES (5, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632525', '贵南县', 2, '', '', 2, 2);
INSERT INTO "public"."jctb_contrast_detail" VALUES (6, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330108', '滨江区', 2, '', '', 36, 36);
INSERT INTO "public"."jctb_contrast_detail" VALUES (7, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632522', '同德县', 2, '', '', 3, 3);
INSERT INTO "public"."jctb_contrast_detail" VALUES (8, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632521', '共和县', 2, '', '', 26, 26);
INSERT INTO "public"."jctb_contrast_detail" VALUES (9, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330103', '下城区', 2, '', '', 21, 21);
INSERT INTO "public"."jctb_contrast_detail" VALUES (10, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330104', '江干区', 2, '', '', 53, 53);
INSERT INTO "public"."jctb_contrast_detail" VALUES (11, '2021S205190028', '630000', '青海省', '632300', '黄南藏族自治州', '632323', '泽库县', 2, '', '', 3, 3);
INSERT INTO "public"."jctb_contrast_detail" VALUES (12, '2021S205190028', '620000', '甘肃省', '620900', '酒泉市', '620923', '肃北蒙古族自治县', 2, '', '', 35, 35);
INSERT INTO "public"."jctb_contrast_detail" VALUES (13, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330102', '上城区', 2, '', '', 1, 1);
INSERT INTO "public"."jctb_contrast_detail" VALUES (14, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330106', '西湖区', 2, '', '', 52, 52);
INSERT INTO "public"."jctb_contrast_detail" VALUES (15, '2021S205190028', '210000', '辽宁省', '211300', '朝阳市', '211321', '朝阳县', 2, '', '', 3, 3);
INSERT INTO "public"."jctb_contrast_detail" VALUES (16, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530628', '彝良县', 2, '', '', 9, 9);
INSERT INTO "public"."jctb_contrast_detail" VALUES (17, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330105', '拱墅区', 2, '', '', 69, 69);
INSERT INTO "public"."jctb_contrast_detail" VALUES (18, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530625', '永善县', 2, '', '', 1, 1);
INSERT INTO "public"."jctb_contrast_detail" VALUES (19, '2021S205190028', '210000', '辽宁省', '211300', '朝阳市', '211324', '喀喇沁左翼蒙古族自治县', 2, '', '', 6, 6);
INSERT INTO "public"."jctb_contrast_detail" VALUES (20, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530621', '鲁甸县', 2, '', '', 20, 20);
INSERT INTO "public"."jctb_contrast_detail" VALUES (21, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530624', '大关县', 2, '', '', 1, 1);
INSERT INTO "public"."jctb_contrast_detail" VALUES (22, '2021S205190028', '150000', '内蒙古自治区', '152200', '兴安盟', '152223', '扎赉特旗', 2, '', '', 54, 54);
INSERT INTO "public"."jctb_contrast_detail" VALUES (23, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', 2, '', '', 9, 9);
INSERT INTO "public"."jctb_contrast_detail" VALUES (24, '2021S205190028', '150000', '内蒙古自治区', '150700', '呼伦贝尔市', '150783', '扎兰屯市', 2, '', '', 13, 13);
INSERT INTO "public"."jctb_contrast_detail" VALUES (25, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530602', '昭阳区', 2, '', '', 95, 95);
INSERT INTO "public"."jctb_contrast_detail" VALUES (26, '2021S205190028', '510000', '四川省', '513300', '甘孜藏族自治州', '513322', '泸定县', 2, '', '', 89, 89);
INSERT INTO "public"."jctb_contrast_detail" VALUES (27, '2021S205190028', '150000', '内蒙古自治区', '152200', '兴安盟', '152221', '科尔沁右翼前旗', 2, '', '', 12, 12);
INSERT INTO "public"."jctb_contrast_detail" VALUES (29, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511823', '汉源县', 2, '', '', 20, 20);
INSERT INTO "public"."jctb_contrast_detail" VALUES (30, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511822', '荥经县', 2, '', '', 6, 6);
INSERT INTO "public"."jctb_contrast_detail" VALUES (31, '2021S205190028', '410000', '河南省', '411600', '周口市', '411681', '项城市', 2, '', '', 13, 13);
INSERT INTO "public"."jctb_contrast_detail" VALUES (32, '2021S205190028', '410000', '河南省', '411600', '周口市', '411626', '淮阳县', 2, '', '', 1, 1);
INSERT INTO "public"."jctb_contrast_detail" VALUES (33, '2021S205190028', '410000', '河南省', '411400', '商丘市', '411421', '民权县', 2, '', '', 6, 6);
INSERT INTO "public"."jctb_contrast_detail" VALUES (34, '2021S205190028', '410000', '河南省', '410900', '濮阳市', '410928', '濮阳县', 2, '', '', 7, 7);
INSERT INTO "public"."jctb_contrast_detail" VALUES (1, '2021S205190028', '650000', '新疆维吾尔自治区', '650400', '吐鲁番市', '650421', '鄯善县', 2, '', '', 75, 75);

-- ----------------------------
-- Primary Key structure for table jctb_contrast_detail
-- ----------------------------
ALTER TABLE "public"."jctb_contrast_detail" ADD CONSTRAINT "jctb_contrast_detail_pkey" PRIMARY KEY ("id");
