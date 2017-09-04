package com.shop.util;

import java.math.BigDecimal;

/**
 * Created by TW on 2017/7/24.
 */
public class MathUtil {

    /**
     * 四舍五入精确到两位
     * @param amount
     * @return
     */
    public static BigDecimal setScale(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
