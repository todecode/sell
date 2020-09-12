package com.imooc.utils;

import java.util.Random;

/**
 * @className: KeyUtil
 * @description: 数据库索引，约束
 * @author: cyd
 * @date: 2020/9/1 下午3:49
 **/
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+六位随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;//生成六位随机数
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
