package com.imooc.enums;

import lombok.Getter;

/**
 * @className: ProductStatusEnum
 * @description: 商品状态
 * @author: cyd
 * @date: 2020/8/31 下午11:03
 **/
@Getter
public enum ProductStatusEnum {

    UP("在架",0),
    DOWN("下架",1);

    private Integer code;
    private String message;
    ProductStatusEnum(String message,Integer code){
        this.code = code;
        this.message= message;
    }
}
