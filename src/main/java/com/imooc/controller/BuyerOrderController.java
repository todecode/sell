package com.imooc.controller;

import com.imooc.config.SellException;
import com.imooc.convert.OrderFrom2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.from.OrderFrom;
import com.imooc.services.OrderService;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: BuyerOrderController
 * @description:
 * @author: cyd
 * @date: 2020/9/2 下午9:54
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderFrom
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,Object>> create(@Valid  OrderFrom orderFrom, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderFrom={}",orderFrom);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFrom2OrderDTOConverter.converter(orderFrom);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO orderReturn = this.orderService.create(orderDTO);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("orderId",orderReturn.getOrderId());

        return ResultVOUtil.success(resultMap);
    }

    // 订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(
            @RequestParam("openid") String openid,
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOS = this.orderService.findList(openid,pageRequest);
        return ResultVOUtil.success(orderDTOS.getContent());
    }

    // 取消订单

    // 订单详情
}
