package com.shop.dao;

import com.shop.model.Navigation;
import com.shop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
public interface ProductCategoryDao {

    @Select("SELECT id, `name` FROM xx_product_category WHERE grade = 0 ORDER BY orders limit #{limit}")
    List<ProductCategory> findRootList(@Param(value = "limit") Integer limit);

    @Select("SELECT id, `name` FROM xx_product_category WHERE parent = #{parentId} ORDER BY orders limit #{limit}")
    List<ProductCategory> findChildrenList(@Param(value = "parentId") Integer parentId, @Param(value = "limit") Integer limit);

    @Select("select id, name, tree_path, grade, parent from xx_product_category where id = #{id}")
    ProductCategory findById(@Param(value = "id") Integer categoryId);

    @Select("select id, name, tree_path, grade, parent from xx_product_category where id in (${ids})")
    List<ProductCategory> findByIds(@Param(value = "ids") String ids);

}
