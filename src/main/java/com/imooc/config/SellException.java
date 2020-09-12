package com.imooc.config;

import com.imooc.enums.ResultEnum;

/**
 * @className: SellException
 * @description:
 * @author: cyd
 * @date: 2020/9/1 下午3:48
 **/
public class SellException extends RuntimeException {

    private Integer code;
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
