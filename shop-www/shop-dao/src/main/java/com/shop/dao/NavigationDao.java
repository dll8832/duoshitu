package com.shop.dao;

import com.shop.model.Navigation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
public interface NavigationDao {

    @Select("SELECT t.id, t.`name`, t.is_blank_target, t.url " +
            " FROM xx_navigation t where position = #{position} order by orders")
    List<Navigation> findByPosition(@Param(value = "position") int position);

}
