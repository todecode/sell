package com.imooc.from;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @className: OrderFrom
 * @description:
 * @author: cyd
 * @date: 2020/9/2 下午9:58
 **/
@Data
public class OrderFrom {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "电话必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车必填")
    private String items;
}
