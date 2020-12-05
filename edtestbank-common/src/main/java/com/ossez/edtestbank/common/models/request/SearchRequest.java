package com.ossez.edtestbank.common.models.request;

import java.io.Serializable;


/**
 * SearchRequest Object, UI can send search String and related pagination
 *
 * @author YuCheng Hu
 */
public class SearchRequest implements Serializable {
    private static final long serialVersionUID = 6474765081240948885L;


    private String searchStr;
    private String orderBy;
    private String pageSize;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
