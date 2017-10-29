package com.avaliev.stackoverflowsearch;

/**
 * Created by Айрат on 13.08.2017.
 */
public class SearchParams {

    String key;

    Integer page;

    Integer limit;

    String sort = "relevance";


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
