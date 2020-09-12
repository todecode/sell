package com.imooc.vo;

import lombok.Data;

/**
 * @className: ResultVO
 * @description: http返回最外层对象
 * @author: cyd
 * @date: 2020/9/1 上午12:18
 **/
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 返回具体内容 */
    private T data;
}
