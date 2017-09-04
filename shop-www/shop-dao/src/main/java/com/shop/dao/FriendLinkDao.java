package com.shop.dao;

import com.shop.model.FriendLink;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/15.
 */
public interface FriendLinkDao {

    @Select("SELECT id, `name`, logo, url FROM xx_friend_link order by orders limit #{limit}")
    List<FriendLink> findList(@Param(value = "limit") Integer limit);
}
