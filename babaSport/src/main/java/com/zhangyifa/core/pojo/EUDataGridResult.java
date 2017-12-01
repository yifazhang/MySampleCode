package com.zhangyifa.core.pojo;

import java.util.List;

/**
 * Created by zyf on 2017/8/9.
 */
public class EUDataGridResult {

    private long total;
    private int pageSize;
    private int pages;
    private List<?> rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
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


}
