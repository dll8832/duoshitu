package com.shop.dao;

import com.shop.model.Promotion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/25.
 */
public interface PromotionDao {

    @Select("SELECT id, `name`, image FROM xx_promotion t1 " +
            " LEFT JOIN xx_product_category_promotion t2 on t1.id = t2.promotions " +
            " where t2.product_categories = #{productCategoryId} ORDER BY orders limit #{limit}")
    List<Promotion> findProductCategoryPromotions(@Param(value = "productCategoryId") Integer productCategoryId,
                                                  @Param(value = "limit") Integer limit);

    @Select("SELECT id, image, title, begin_date, end_date  " +
            "FROM xx_promotion WHERE   " +
            "(begin_date is null AND (NOW() - end_date < 0 or end_date is NULL) )  " +
            "OR (NOW() - begin_date > 0 AND (NOW() - end_date < 0 or end_date is NULL)) limit #{limit}")
    List<Promotion> findPromotions(@Param(value = "limit")Integer limit);
}
