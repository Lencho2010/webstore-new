package com.geoway.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/8 15:12
 * @Description:
 */
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    //总记录数
    private int total;
    //每页记录数
    private int pageSize;
    //总页数
    private int pages;
    //当前页数
    private int pageNum;
    //列表数据
    private List<?> list;

    /**
     * 分页
     * @param list        列表数据
     * @param total  总记录数
     * @param pageSize    每页记录数
     * @param pageNum    当前页数
     */
    public PageUtils(List<?> list, int total, int pageSize, int pageNum) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.pages = (int)Math.ceil((double) total /pageSize);
    }

    /**
     * 分页
     */
    public PageUtils(IPage<?> page) {
        this.list = page.getRecords();
        this.total = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.pageNum = (int)page.getCurrent();
        this.pages = (int)page.getPages();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
