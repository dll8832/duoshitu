package com.shop.base;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by TW on 2017/6/10.
 */
public class BaseDto implements Serializable {

    private Integer page;
    private Integer pageSize;
    private String sort;

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public PageBounds buildPageBounds() {
        if (this.page == null || this.page < 1) {
            this.page = 1;
        }
        if (this.pageSize == null || this.pageSize < 1) {
            this.pageSize = 10;
        }

        PageBounds pageBounds = new PageBounds(this.page, this.pageSize);
        if (StringUtils.isNotBlank(this.sort)) {
            pageBounds.setOrders(Order.formString(this.sort));
        }
        return pageBounds;
    }

}
