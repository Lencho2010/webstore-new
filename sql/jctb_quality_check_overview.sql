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

 Date: 16/09/2021 18:35:58
*/


-- ----------------------------
-- Table structure for jctb_quality_check_overview
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_quality_check_overview";
CREATE TABLE "public"."jctb_quality_check_overview" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "status" int2,
  "info" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of jctb_quality_check_overview
-- ----------------------------
INSERT INTO "public"."jctb_quality_check_overview" VALUES (1, '2021S205190028', '130000', '河北省11', '130200', '唐山市', '130223', '滦县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (2, '2021S205190028', '130000', '河北省', '130300', '秦皇岛市', '130324', '卢龙县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (3, '2021S205190028', '140000', '山西省', '140500', '晋城市', '140525', '泽州县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (4, '2021S205190028', '150000', '内蒙古自治区', '152200', '兴安盟', '152223', '扎赉特旗', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (5, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330103', '下城区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (6, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330106', '西湖区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (7, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330108', '滨江区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (8, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330109', '萧山区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (9, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330111', '富阳区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (10, '2021S205190028', '330000', '浙江省', '330400', '嘉兴市', '330481', '海宁市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (11, '2021S205190028', '330000', '浙江省', '330500', '湖州市', '330521', '德清县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (12, '2021S205190028', '340000', '安徽省', '340300', '蚌埠市', '340303', '蚌山区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (13, '2021S205190028', '140000', '山西省', '140700', '晋中市', '140724', '昔阳县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (14, '2021S205190028', '150000', '内蒙古自治区', '150500', '通辽市', '150526', '扎鲁特旗', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (15, '2021S205190028', '150000', '内蒙古自治区', '150700', '呼伦贝尔市', '150783', '扎兰屯市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (16, '2021S205190028', '340000', '安徽省', '340400', '淮南市', '340402', '大通区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (17, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330102', '上城区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (18, '2021S205190028', '340000', '安徽省', '341100', '滁州市', '341125', '定远县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (19, '2021S205190028', '360000', '江西省', '360400', '九江市', '360428', '都昌县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (20, '2021S205190028', '360000', '江西省', '361000', '抚州市', '361021', '南城县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (21, '2021S205190028', '410000', '河南省', '410200', '开封市', '410202', '龙亭区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (22, '2021S205190028', '410000', '河南省', '410200', '开封市', '410204', '鼓楼区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (23, '2021S205190028', '410000', '河南省', '410200', '开封市', '410212', '祥符区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (24, '2021S205190028', '370000', '山东省', '371600', '滨州市', '371625', '博兴县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (25, '2021S205190028', '410000', '河南省', '410700', '新乡市', '410727', '封丘县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (26, '2021S205190028', '410000', '河南省', '410200', '开封市', '410225', '兰考县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (27, '2021S205190028', '410000', '河南省', '411400', '商丘市', '411421', '民权县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (28, '2021S205190028', '410000', '河南省', '410200', '开封市', '410221', '杞县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (29, '2021S205190028', '410000', '河南省', '411600', '周口市', '411681', '项城市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (30, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530602', '昭阳区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (31, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511822', '荥经县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (32, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530625', '永善县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (33, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511823', '汉源县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (34, '2021S205190028', '410000', '河南省', '410700', '新乡市', '410728', '长垣县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (35, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530621', '鲁甸县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (36, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632521', '共和县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (37, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632525', '贵南县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (38, '2021S205190028', '650000', '新疆维吾尔自治区', '650500', '哈密市', '650521', '巴里坤哈萨克自治县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (39, '2021S205190028', '650000', '新疆维吾尔自治区', '652300', '昌吉回族自治州', '652328', '木垒哈萨克自治县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (40, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530628', '彝良县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (41, '2021S205190028', '620000', '甘肃省', '620900', '酒泉市', '620923', '肃北蒙古族自治县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (42, '2021S205190028', '650000', '新疆维吾尔自治区', '652800', '巴音郭楞蒙古自治州', '652801', '库尔勒市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (43, '2021S205190028', '650000', '新疆维吾尔自治区', '652800', '巴音郭楞蒙古自治州', '652823', '尉犁县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (44, '2021S205190028', '650000', '新疆维吾尔自治区', '652700', '博尔塔拉蒙古自治州', '652722', '精河县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (45, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653222', '墨玉县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (46, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653201', '和田市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (47, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652924', '沙雅县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (48, '2021S205190028', '360000', '江西省', '361000', '抚州市', '361028', '资溪县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (49, '2021S205190028', '370000', '山东省', '370300', '淄博市', '370322', '高青县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (50, '2021S205190028', '370000', '山东省', '370500', '东营市', '370502', '东营区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (51, '2021S205190028', '370000', '山东省', '370700', '潍坊市', '370782', '诸城市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (52, '2021S205190028', '370000', '山东省', '370700', '潍坊市', '370784', '安丘市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (53, '2021S205190028', '370000', '山东省', '371100', '日照市', '371103', '岚山区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (54, '2021S205190028', '370000', '山东省', '371100', '日照市', '371122', '莒县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (55, '2021S205190028', '370000', '山东省', '371600', '滨州市', '371602', '滨城区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (56, '2021S205190028', '130000', '河北省', '130300', '秦皇岛市', '130322', '昌黎县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (57, '2021S205190028', '410000', '河南省', '410200', '开封市', '410205', '禹王台区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (58, '2021S205190028', '410000', '河南省', '410500', '安阳市', '410526', '滑县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (59, '2021S205190028', '410000', '河南省', '410200', '开封市', '410203', '顺河回族区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (60, '2021S205190028', '410000', '河南省', '411600', '周口市', '411624', '沈丘县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (61, '2021S205190028', '650000', '新疆维吾尔自治区', '650400', '吐鲁番市', '650421', '鄯善县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (62, '2021S205190028', '510000', '四川省', '513300', '甘孜藏族自治州', '513322', '泸定县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (63, '2021S205190028', '540000', '西藏自治区', '540400', '林芝地区', '540425', '察隅县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (64, '2021S205190028', '410000', '河南省', '410900', '濮阳市', '410928', '濮阳县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (65, '2021S205190028', '530000', '云南省', '530600', '昭通市', '530624', '大关县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (66, '2021S205190028', '630000', '青海省', '632300', '黄南藏族自治州', '632323', '泽库县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (67, '2021S205190028', '410000', '河南省', '411600', '周口市', '411626', '淮阳县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (68, '2021S205190028', '510000', '四川省', '511800', '雅安市', '511824', '石棉县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (69, '2021S205190028', '410000', '河南省', '410200', '开封市', '410222', '通许县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (70, '2021S205190028', '630000', '青海省', '632500', '海南藏族自治州', '632522', '同德县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (71, '2021S205190028', '650000', '新疆维吾尔自治区', '652800', '巴音郭楞蒙古自治州', '652827', '和静县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (72, '2021S205190028', '650000', '新疆维吾尔自治区', '652700', '博尔塔拉蒙古自治州', '652701', '博乐市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (73, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659007', '双河市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (74, '2021S205190028', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区', '652923', '库车县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (75, '2021S205190028', '650000', '新疆维吾尔自治区', '659000', '新疆维吾尔自治区直辖', '659006', '铁门关市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (76, '2021S205190028', '650000', '新疆维吾尔自治区', '653200', '和田地区', '653221', '和田县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (77, '2021S205190028', '', '', '', '', '', '', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (78, '2021S205190028', '140000', '山西省', '140500', '晋城市', '140502', '晋城市城区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (79, '2021S205190028', '130000', '河北省', '130200', '唐山市', '130224', '滦南县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (80, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330110', '余杭区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (81, '2021S205190028', '210000', '辽宁省', '211300', '朝阳市', '211321', '朝阳县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (82, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330112', '临安区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (83, '2021S205190028', '140000', '山西省', '140700', '晋中市', '140723', '和顺县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (84, '2021S205190028', '150000', '内蒙古自治区', '152200', '兴安盟', '152221', '科尔沁右翼前旗', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (85, '2021S205190028', '210000', '辽宁省', '211300', '朝阳市', '211324', '喀喇沁左翼蒙古族自治县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (86, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330104', '江干区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (87, '2021S205190028', '330000', '浙江省', '330100', '杭州市', '330105', '拱墅区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (88, '2021S205190028', '330000', '浙江省', '330500', '湖州市', '330523', '安吉县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (89, '2021S205190028', '370000', '山东省', '370500', '东营市', '370523', '广饶县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (90, '2021S205190028', '150000', '内蒙古自治区', '150600', '鄂尔多斯市', '150623', '鄂托克前旗', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (91, '2021S205190028', '340000', '安徽省', '341100', '滁州市', '341126', '凤阳县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (92, '2021S205190028', '360000', '江西省', '361000', '抚州市', '361022', '黎川县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (93, '2021S205190028', '370000', '山东省', '370300', '淄博市', '370321', '桓台县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (94, '2021S205190028', '370000', '山东省', '370700', '潍坊市', '370724', '临朐县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (95, '2021S205190028', '370000', '山东省', '371300', '临沂市', '371321', '沂南县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (96, '2021S205190028', '360000', '江西省', '360400', '九江市', '360483', '庐山市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (97, '2021S205190028', '340000', '安徽省', '340300', '蚌埠市', '340304', '禹会区', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (98, '2021S205190028', '370000', '山东省', '371100', '日照市', '371121', '五莲县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (99, '2021S205190028', '370000', '山东省', '371700', '菏泽市', '371728', '东明县', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (100, '2021S205190028', '370000', '山东省', '370700', '潍坊市', '370783', '寿光市', 2, '');
INSERT INTO "public"."jctb_quality_check_overview" VALUES (101, '2021S205190028', '370000', '山东省', '371300', '临沂市', '371323', '沂水县', 2, '');

-- ----------------------------
-- Primary Key structure for table jctb_quality_check_overview
-- ----------------------------
ALTER TABLE "public"."jctb_quality_check_overview" ADD CONSTRAINT "jctb_quality_check_overview_pkey" PRIMARY KEY ("id");
