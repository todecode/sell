package com.imooc.dto;

import lombok.Data;

/**
 * @className: CartDTO
 * @description:
 * @author: cyd
 * @date: 2020/9/1 下午3:41
 **/
@Data
public class CartDTO {
    /** 商品id */
    private String productId;
    /** 数量 */
    private Integer productQuantity;

    public CartDTO(){}

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
