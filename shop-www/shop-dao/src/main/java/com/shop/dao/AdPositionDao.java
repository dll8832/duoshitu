package com.shop.dao;

import com.shop.model.AdPosition;
import org.apache.ibatis.annotations.Param;


public interface AdPositionDao {
	
	AdPosition findById(@Param(value = "positionId") Integer positionId);
	
}
