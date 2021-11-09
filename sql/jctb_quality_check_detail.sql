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

 Date: 16/09/2021 18:35:47
*/


-- ----------------------------
-- Table structure for jctb_quality_check_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_quality_check_detail";
CREATE TABLE "public"."jctb_quality_check_detail" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "rule_code" varchar(255) COLLATE "pg_catalog"."default",
  "rule_name" varchar(255) COLLATE "pg_catalog"."default",
  "check_result" int2,
  "check_info" varchar(255) COLLATE "pg_catalog"."default",
  "final_result" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."jctb_quality_check_detail"."check_result" IS '质检结果';
COMMENT ON COLUMN "public"."jctb_quality_check_detail"."check_info" IS '质检信息';
COMMENT ON COLUMN "public"."jctb_quality_check_detail"."final_result" IS '结果信息';

-- ----------------------------
-- Records of jctb_quality_check_detail
-- ----------------------------
INSERT INTO "public"."jctb_quality_check_detail" VALUES (2, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '2101', '数学基础', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (3, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '3101', '属性字段名称类型检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (4, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '3102', '属性字段的长度位数检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (5, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '3201', '代码一致性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (6, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '3401', '编号唯一性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (7, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '3501', '字段必填性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (8, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '4101', '面层内拓扑关系', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (9, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '5101', '数据自重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (10, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '5201', '数据间重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (11, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '1201', '数据有效性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (12, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '2101', '数学基础', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (13, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '3101', '属性字段名称类型检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (14, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '3102', '属性字段的长度位数检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (15, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '3201', '代码一致性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (16, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '3401', '编号唯一性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (17, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '3501', '字段必填性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (18, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '4101', '面层内拓扑关系', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (19, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '5101', '数据自重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (20, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', '5201', '数据间重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (21, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '1201', '数据有效性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (22, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '2101', '数学基础', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (23, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '3101', '属性字段名称类型检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (24, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '3102', '属性字段的长度位数检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (25, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '3201', '代码一致性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (26, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '3401', '编号唯一性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (27, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '3501', '字段必填性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (28, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '4101', '面层内拓扑关系', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (29, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '5101', '数据自重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (30, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', '5201', '数据间重叠检查', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (31, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653222', '墨玉县', '1201', '数据有效性', 1, '', '');
INSERT INTO "public"."jctb_quality_check_detail" VALUES (1, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', '1201', '数据有效性', 1, '1111', '');

-- ----------------------------
-- Primary Key structure for table jctb_quality_check_detail
-- ----------------------------
ALTER TABLE "public"."jctb_quality_check_detail" ADD CONSTRAINT "jctb_quality_check_detail_pkey" PRIMARY KEY ("id");
