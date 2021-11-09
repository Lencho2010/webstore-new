package com.geoway.webstore.entity;

import java.util.Map;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 21:16
 * @Description:
 */
public class TransportTemplate {
    private String template;

    private Map<String, Object> templateMap;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getTemplateMap() {
        return templateMap;
    }

    public void setTemplateMap(Map<String, Object> templateMap) {
        this.templateMap = templateMap;
    }

}
