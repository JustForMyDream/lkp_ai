package com.lkp.bean;

import java.util.List;

/**
 *
 */
public class QueryResult<T>  {
    /**
     * 符合条件的总记录数
     */
    private long totalRecord = 0;

    private List<T> list;

    public QueryResult() {
    }

    public QueryResult(long totalRecord, List<T> list) {
        this.totalRecord = totalRecord;
        this.list = list;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord > 0 ? totalRecord : 0;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
