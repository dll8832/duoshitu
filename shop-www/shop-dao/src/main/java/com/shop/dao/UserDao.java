package com.shop.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by TW on 2017/8/22.
 */
public interface UserDao {
    @Select("select * from t_user")
    PageList<User> find(PageBounds pageBounds);
}
