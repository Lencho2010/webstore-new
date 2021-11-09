package com.geoway.webstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ReportType)实体类
 *
 * @author makejava
 * @since 2021-11-02 14:39:15
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportType implements Serializable {
    private static final long serialVersionUID = -50421216438592188L;
    
    private Long id;
    
    private String name;
    /**
    * week;month;year
    */
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}