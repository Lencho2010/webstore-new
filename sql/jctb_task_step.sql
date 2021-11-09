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

 Date: 16/09/2021 18:36:22
*/


-- ----------------------------
-- Table structure for jctb_task_step
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_task_step";
CREATE TABLE "public"."jctb_task_step" (
  "step_code" int4 NOT NULL,
  "step_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of jctb_task_step
-- ----------------------------
INSERT INTO "public"."jctb_task_step" VALUES (1001, '接收解压');
INSERT INTO "public"."jctb_task_step" VALUES (1002, '质量检查');
INSERT INTO "public"."jctb_task_step" VALUES (1003, '套合比对');
INSERT INTO "public"."jctb_task_step" VALUES (1004, '成果检查');
INSERT INTO "public"."jctb_task_step" VALUES (1005, '成果输出');
INSERT INTO "public"."jctb_task_step" VALUES (1006, '数据入库');

-- ----------------------------
-- Primary Key structure for table jctb_task_step
-- ----------------------------
ALTER TABLE "public"."jctb_task_step" ADD CONSTRAINT "jctb_task_step_pkey" PRIMARY KEY ("step_code");
