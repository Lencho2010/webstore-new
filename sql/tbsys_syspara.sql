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

 Date: 16/09/2021 18:36:40
*/


-- ----------------------------
-- Table structure for tbsys_syspara
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbsys_syspara";
CREATE TABLE "public"."tbsys_syspara" (
  "f_id" numeric NOT NULL,
  "f_name" text COLLATE "pg_catalog"."default",
  "f_key" text COLLATE "pg_catalog"."default",
  "f_value1" text COLLATE "pg_catalog"."default",
  "f_value2" bytea,
  "f_desc" text COLLATE "pg_catalog"."default",
  "f_group" text COLLATE "pg_catalog"."default",
  "f_userid" numeric,
  "f_type" numeric(255)
)
;

-- ----------------------------
-- Records of tbsys_syspara
-- ----------------------------
INSERT INTO "public"."tbsys_syspara" VALUES (1004, 'scanPaths', 'a10519d2-85f3-4b06-b38a-2df9c6462623', '[
"hadoop104:5432/db2021",
"hadoop103:5432/db2021",
"hadoop102:5432/db2021"
]', NULL, '扫描路径备选', NULL, NULL, NULL);
INSERT INTO "public"."tbsys_syspara" VALUES (1003, 'scanPath', 'eefc68d6-50d0-46ee-ae60-f7556941e92c', 'hadoop104:5432/db2021', NULL, '扫描路径', NULL, NULL, NULL);
INSERT INTO "public"."tbsys_syspara" VALUES (1002, 'scanInterval', 'aadea8a9-b7ad-44e2-a7a4-6d37ae432742', '25', NULL, '扫描间隔：单位分钟', NULL, NULL, NULL);
INSERT INTO "public"."tbsys_syspara" VALUES (1001, 'serviceStatus', 'add77e71-6603-4dd7-9ff9-6e2a947c398e', '1', NULL, '服务状态：0-暂停；1-启动', NULL, NULL, NULL);

-- ----------------------------
-- Primary Key structure for table tbsys_syspara
-- ----------------------------
ALTER TABLE "public"."tbsys_syspara" ADD CONSTRAINT "tbsys_syspara_pkey" PRIMARY KEY ("f_id");
