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

 Date: 16/09/2021 18:36:11
*/


-- ----------------------------
-- Table structure for jctb_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_task";
CREATE TABLE "public"."jctb_task" (
  "task_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "status" int2,
  "progress" int2,
  "start_time" timestamp(6),
  "end_time" timestamp(6),
  "creator" varchar(255) COLLATE "pg_catalog"."default",
  "tb_count" int4
)
;
COMMENT ON COLUMN "public"."jctb_task"."creator" IS '创建者';
COMMENT ON COLUMN "public"."jctb_task"."tb_count" IS '图斑数量';

-- ----------------------------
-- Records of jctb_task
-- ----------------------------
INSERT INTO "public"."jctb_task" VALUES ('2021S204120005', 1, 100, '2021-09-02 15:16:38', '2021-09-10 15:16:43', 'admin', 900);
INSERT INTO "public"."jctb_task" VALUES ('2021S205190028', 1, 100, '2021-09-02 15:16:38', '2021-09-10 15:16:43', 'admin', 900);
INSERT INTO "public"."jctb_task" VALUES ('2021S204120004', 2, 80, '2021-09-02 15:16:38', '2021-09-10 15:16:43', 'admin', 900);
INSERT INTO "public"."jctb_task" VALUES ('2021S204120003', 3, 70, '2021-09-02 15:16:38', '2021-09-10 15:16:43', 'admin', 500);

-- ----------------------------
-- Primary Key structure for table jctb_task
-- ----------------------------
ALTER TABLE "public"."jctb_task" ADD CONSTRAINT "jctb_task_pkey" PRIMARY KEY ("task_name");
