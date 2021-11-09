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

 Date: 16/09/2021 18:35:53
*/


-- ----------------------------
-- Table structure for jctb_quality_check_fail
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_quality_check_fail";
CREATE TABLE "public"."jctb_quality_check_fail" (
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
  "tbbh" varchar(255) COLLATE "pg_catalog"."default",
  "final_result" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."jctb_quality_check_fail"."tbbh" IS '图斑编号';
COMMENT ON COLUMN "public"."jctb_quality_check_fail"."final_result" IS '结果信息';

-- ----------------------------
-- Records of jctb_quality_check_fail
-- ----------------------------
INSERT INTO "public"."jctb_quality_check_fail" VALUES (2, '2021S205190028', '140000', '山西省', '140900', '忻州市', '140902', '忻府区', '4101', '面层内拓扑关系', '1409022021061907145506', 'self intersections');
INSERT INTO "public"."jctb_quality_check_fail" VALUES (3, '2021S205190028', '150000', '内蒙古自治区', '152200', '兴安盟', '152223', '扎赉特旗', '4101', '面层内拓扑关系', '15222320210316062320982', 'self intersections');
INSERT INTO "public"."jctb_quality_check_fail" VALUES (4, '2021S205190028', '370000', '山东省', '371000', '威海市', '371083', '乳山市', '4101', '面层内拓扑关系', '3710832021062007212439', 'self intersections');
INSERT INTO "public"."jctb_quality_check_fail" VALUES (1, '2021S205190028', '360000', '江西省1', '360600', '鹰潭市', '360603', '余江区', '4101', '面层内拓扑关系', '360603202105020628752', 'self intersections');

-- ----------------------------
-- Primary Key structure for table jctb_quality_check_fail
-- ----------------------------
ALTER TABLE "public"."jctb_quality_check_fail" ADD CONSTRAINT "jctb_quality_check_fail_pkey" PRIMARY KEY ("id");
