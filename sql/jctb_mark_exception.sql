/*
 Navicat Premium Data Transfer

 Source Server         : postgres@hadoop102-docker
 Source Server Type    : PostgreSQL
 Source Server Version : 120001
 Source Host           : hadoop102:5432
 Source Catalog        : db01
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120001
 File Encoding         : 65001

 Date: 17/09/2021 17:25:26
*/


-- ----------------------------
-- Table structure for jctb_mark_exception
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_mark_exception";
CREATE TABLE "public"."jctb_mark_exception" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "jcbh" varchar(255) COLLATE "pg_catalog"."default",
  "error_type" varchar(255) COLLATE "pg_catalog"."default",
  "error_desc" varchar(255) COLLATE "pg_catalog"."default",
  "is_mark" int2 DEFAULT 0,
  "mark_reason" varchar(255) COLLATE "pg_catalog"."default",
  "step_code" int2
)
;
COMMENT ON COLUMN "public"."jctb_mark_exception"."step_code" IS '1002-质量检查；1003-套合比对；1004-成果检查';

-- ----------------------------
-- Records of jctb_mark_exception
-- ----------------------------
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770945, '2021S105300022', '110000', '北京市', '110100', '北京市', '110222', '房山区222', 'jcbh1002', '', '', 0, '', 1002);
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770947, '2021S105300044', '110000', '北京市', '110100', '北京市', '110444', '房山区444', 'jcbh1004', '', '', 0, '', 1002);
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770949, '2021S105300066', '110000', '北京市', '110100', '北京市', '110666', '房山区666', 'jcbh1006', '', '', 0, '', 1002);
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770946, '2021S105300033', '110000', '北京市', '110100', '北京市', '110333', '房山区333', 'jcbh1003', '', '', 0, '', 1004);
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770948, '2021S105300055', '110000', '北京市', '110100', '北京市', '110555', '房山区555', 'jcbh1005', '', '', 0, '', 1003);
INSERT INTO "public"."jctb_mark_exception" VALUES (636249919010770944, '2021S105300011', '110000', '北京市', '110100', '北京市', '110111', '房山区111', 'jcbh1001', '', '', 0, '123456', 1002);
INSERT INTO "public"."jctb_mark_exception" VALUES (636247767374761985, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511824', '石棉县', '20211001', '1001', '错误描述', 1, '测试标识例外', 1003);
INSERT INTO "public"."jctb_mark_exception" VALUES (636247767374761986, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511824', '石棉县', '20211002', '1002', '错误描述2222', 0, '测试标识例外', 1004);
INSERT INTO "public"."jctb_mark_exception" VALUES (636247767374761984, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511824', '石棉县', '20211003', '1001', '错误描述更新', 1, '1233', 1002);

-- ----------------------------
-- Primary Key structure for table jctb_mark_exception
-- ----------------------------
ALTER TABLE "public"."jctb_mark_exception" ADD CONSTRAINT "jctb_mark_exception_pkey" PRIMARY KEY ("id");
