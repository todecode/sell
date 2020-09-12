package com.imooc.enums;

import lombok.Getter;

/**
 * @className: PayStatusEnum
 * @description:
 * @author: cyd
 * @date: 2020/9/1 上午12:36
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支持成功")
            ;
    private Integer code;
    private String message;
    PayStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
