package com.imooc.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: OrderDTO
 * @description:
 * @author: cyd
 * @date: 2020/9/1 下午3:41
 **/
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单编号 */
    private String orderId;
    /** 买家名字 */
    private String buyerName;
    /** 买家电话 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家微信Openid */
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;
    /** 订单状态，默认为0新订单 */
    private Integer orderStatus;
    /** 支付状态，默认为0未支付 */
    private Integer payStatus;
    /** 订单创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /** 订单更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    private List<OrderDetail> orderDetailList = new ArrayList<>();
}
