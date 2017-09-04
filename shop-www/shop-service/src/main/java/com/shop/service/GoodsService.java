package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.GoodsDao;
import com.shop.util.AssertUtil;
import com.shop.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/25.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 获取分类下的热销商品
     * @param productCategoryId
     * @param limit
     * @return
     */
    public List<GoodsVo> findHotProductCategoryGoods(Integer productCategoryId,
                                                     Integer limit) {
        if (limit == null) {
            limit = Constant.TEN;
        }
        List<GoodsVo> goods = null;
        if (productCategoryId != null) {
            goods = goodsDao.findCategoryHotGoods(productCategoryId, limit);
        } else {
            goods = goodsDao.findHotGoods(limit);
        }
        return goods;
    }
}
