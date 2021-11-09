package com.geoway.webstore.constant;

/**
 * @author Lencho
 * @create 2021-08-21 17:51
 */
public class Constant {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT2 = "yyyy-MM-dd";
    public static final String TIME_ZONE = "GMT+8";

    public static final String RESPONSE_OK = "ok";
    public static final String RESPONSE_ERROR = "error";

    public static final String GW_POSTGIS_PROVIDER = "gwPostGISProvider";
    public static final String GW_SQLITE_PROVIDER = "gwSqliteProvider";
    public static final String GW_ORACLE_PROVIDER = "gwOracleProvider";
    public static final String GW_OGR_PROVIDER = "gwOGRProvider";
    public static final String GW_KINGBASE_PROVIDER = "gwKingBaseProvider";

    public static final String CUR_DATABASE_KEY = "Key";

    public static final Long TRUE_VALUE = 1L;
    public static final Long FALSE_VALUE = 0L;

    public static final String FIELD_OBJECTID = "objectid";
    public static final String FIELD_OBJECTID_ALIAS = "ObjectID";
    public static final String FIELD_SHAPE = "shape";
    public static final String FIELD_SHAPE_ALIAS = "Shape";

    public static final String GW_FIELD_ID = "gw_objectid";
    public static final String GW_FIELD_ID_ALIAS = "objectid";
    public static final String GW_FIELD_SHAPE = "gw_shape";
    public static final String GW_FIELD_SHAPE_ALIAS = "Shape";

    public static final String FIELD_OID = "f_oid";
    public static final String FIELD_OID_ALIAS = "编号";

    public static final String SEPARATOR = ",";
    public static final String[] ID_FIELDS = {"objectcid", "objectid", "fid", "f_oid", "OBJECTID"};


    /**
     * 要素唯一标识字段
     */
    public static final String ST_FIELD_GUID = "F_GUID";

    /**
     * 要素时相
     */
    public static final String ST_FIELD_TIME = "F_TIME";

    /**
     * 更新类型
     */
    public static final String ST_FIELD_CHANGETYPE = "F_UPDATETYPE";
    /**
     * 更新时间
     */
    public static final String ST_FIELD_MODIFYTIME = "F_UPDATETIME";
    /**
     * 更新任务id（现势层）
     */
    public static final String ST_FIELD_TASKID = "F_TASKID";
    /**
     * 更新任务id（work层）
     */
    public static final String ST_FIELD_TASKID2 = "F_TASKID2";
    /**
     * 更新区域名称[测区或者行政区]
     */
    public static final String ST_FIELD_FRAME = "F_FRAME";


    public static final String ST_WORKLAYER_SUFFIX = "_WORK";


    public static final String FIELD_DATAID = "F_DATAID";
}
