package com.geoway.webstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.geoway.webstore.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (ReportTask)实体类
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportTask implements Serializable {
    private static final long serialVersionUID = 245005481044580606L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    private String name;
    /**
    * 责任人
    */
    private String chargePerson;
    /**
    * 描述
    */
    private String desc;
    /**
    * 统计类型(week,month,year)
    */
    private String statisticType;
    /**
    * 统计开始日期
    */
    @JsonFormat(pattern= Constant.DATE_FORMAT2, timezone = Constant.TIME_ZONE)
    private Date fromDate;
    /**
    * 统计结束日期
    */
    @JsonFormat(pattern= Constant.DATE_FORMAT2, timezone = Constant.TIME_ZONE)
    private Date toDate;
    /**
    * 统计批次(多项)
    */
    private String taskNames;
    /**
    * 导出文档(多项)
    */
    private String exportDocs;
    /**
    * 导出路径
    */
    private String exportPath;
    /**
    * 状态（-1：失败；0：未执行；1：成功；2：进行中）
    */
    private Integer status;
    /**
    * 任务创建时间
    */
    @JsonFormat(pattern= Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date createTime;
    /**
    * 导出开始时间
    */
    @JsonFormat(pattern= Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date startTime;
    /**
    * 导出结束时间
    */
    @JsonFormat(pattern= Constant.DATE_FORMAT, timezone = Constant.TIME_ZONE)
    private Date endTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTaskNames() {
        return taskNames;
    }

    public void setTaskNames(String taskNames) {
        this.taskNames = taskNames;
    }

    public String getExportDocs() {
        return exportDocs;
    }

    public void setExportDocs(String exportDocs) {
        this.exportDocs = exportDocs;
    }

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}