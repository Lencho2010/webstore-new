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

 Date: 16/09/2021 18:36:28
*/


-- ----------------------------
-- Table structure for jctb_task_sub
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_task_sub";
CREATE TABLE "public"."jctb_task_sub" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "status" int2,
  "progress" int2,
  "start_time" timestamp(6),
  "end_time" timestamp(6),
  "step_code" int4
)
;

-- ----------------------------
-- Records of jctb_task_sub
-- ----------------------------
INSERT INTO "public"."jctb_task_sub" VALUES (1002, '2021S205190028', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1002);
INSERT INTO "public"."jctb_task_sub" VALUES (1003, '2021S205190028', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1003);
INSERT INTO "public"."jctb_task_sub" VALUES (1004, '2021S205190028', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1004);
INSERT INTO "public"."jctb_task_sub" VALUES (1005, '2021S205190028', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1005);
INSERT INTO "public"."jctb_task_sub" VALUES (1006, '2021S205190028', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1006);
INSERT INTO "public"."jctb_task_sub" VALUES (10001, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1001);
INSERT INTO "public"."jctb_task_sub" VALUES (10002, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1002);
INSERT INTO "public"."jctb_task_sub" VALUES (10003, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1003);
INSERT INTO "public"."jctb_task_sub" VALUES (10004, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1004);
INSERT INTO "public"."jctb_task_sub" VALUES (10005, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1005);
INSERT INTO "public"."jctb_task_sub" VALUES (10006, '2021S205190027', 1, 55, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1006);
INSERT INTO "public"."jctb_task_sub" VALUES (1001, '2021S205190028', 1, 65, '2021-08-31 17:33:19', '2021-09-02 17:33:23', 1001);

-- ----------------------------
-- Primary Key structure for table jctb_task_sub
-- ----------------------------
ALTER TABLE "public"."jctb_task_sub" ADD CONSTRAINT "jctb_task_sub_pkey" PRIMARY KEY ("id");
