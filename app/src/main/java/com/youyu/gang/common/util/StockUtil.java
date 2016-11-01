package com.youyu.gang.common.util;

/**
 * Created by Administrator on 2015/12/15.
 */
public class StockUtil {
    public static int getStockCount(String mallProductSkuStock){
        int count=0;
        try{
            String s = mallProductSkuStock.substring(1, mallProductSkuStock.length() - 1);
            String[] split = s.split(",");
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split(":");
                count+=(0>=Integer.parseInt(split1[1])?0:Integer.parseInt(split1[1]));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
