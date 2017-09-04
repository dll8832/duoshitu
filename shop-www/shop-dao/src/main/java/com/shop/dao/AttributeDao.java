package com.shop.dao;

import com.shop.model.Attribute;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/17.
 */
public interface AttributeDao {

    @Select("SELECT id, `name`, `options`,property_index,product_category " +
            "FROM xx_attribute WHERE product_category = #{categoryId}")
    List<Attribute> findCategoryAttributes(@Param(value = "categoryId") Integer categoryId);
}
