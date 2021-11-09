package com.geoway.webstore.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/5 9:03
 * @Description:
 */
@Data
@ToString
public class ExportWordConfigDetail {

    private String docPath;

    private String outPath;

    private List<SqlItem> sqlItem;
}


