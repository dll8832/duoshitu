package com.shop.dao;

import com.shop.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
public interface BrandDao {

    @Select("SELECT id, name, logo FROM xx_brand t1 LEFT JOIN xx_product_category_brand t2 " +
            " on t1.id = t2.brands where t2.product_categories=#{categoryId} ORDER BY " +
            " t1.orders LIMIT #{limit}")
    public List<Brand> findCategoryBrandList(@Param(value = "categoryId") Integer categoryId,
                                             @Param(value = "limit") Integer limit);

    @Select("SELECT id, name, logo FROM xx_brand ORDER BY orders LIMIT #{limit}")
    List<Brand> findBrands(@Param(value = "limit") Integer limit);
}
