package com.zhangyifa.core.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zyf on 2017/7/6.
 */
public class BaseAction extends ActionSupport {

    protected String[] selectedRow;
    public String[] getSelectedRow() {
        return selectedRow;
    }
    public void setSelectedRow(String[] selectedRow) {
        this.selectedRow = selectedRow;
    }
}
