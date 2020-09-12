package com.imooc.utils;

import com.imooc.vo.ResultVO;

/**
 * @className: ResultVOUtil
 * @description:
 * @author: cyd
 * @date: 2020/9/1 上午12:29
 **/
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVO success() {
        return success(null);
    }
    public static ResultVO error(Integer code,String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
