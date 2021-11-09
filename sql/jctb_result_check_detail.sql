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

 Date: 16/09/2021 18:36:06
*/


-- ----------------------------
-- Table structure for jctb_result_check_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_result_check_detail";
CREATE TABLE "public"."jctb_result_check_detail" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "status" int2,
  "info" varchar(255) COLLATE "pg_catalog"."default",
  "rule_code" varchar(255) COLLATE "pg_catalog"."default",
  "rule_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of jctb_result_check_detail
-- ----------------------------
INSERT INTO "public"."jctb_result_check_detail" VALUES (635941699486617600, '2021S205190028', '650000', '新疆维吾尔自治区', '650400', '吐鲁番市', '650421', '鄯善县', 2, '', '1001', '测试规则');

-- ----------------------------
-- Primary Key structure for table jctb_result_check_detail
-- ----------------------------
ALTER TABLE "public"."jctb_result_check_detail" ADD CONSTRAINT "jctb_result_check_detail_pkey" PRIMARY KEY ("id");
