package com.example.rest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 代扣部分模拟方法
 * @author xueshiqi
 * @since 2018/12/7
 */
@RestController
public class WithholdingTest {

    /**
     * 扣款接口
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/drd-admin/rf/smallloan/deduct", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject smallloanDeduct(@RequestBody JSONObject jsonParam) {
        JSONObject result = new JSONObject();
        JSONObject resultOut = new JSONObject();
        result.put("orderNo", jsonParam.get("orderNo"));
        resultOut.put("orderNo", jsonParam.get("orderNo"));
        result.put("requestNo", jsonParam.get("requestNo"));
        resultOut.put("requestNo", jsonParam.get("requestNo"));
        List<Map> details = (List) jsonParam.get("details");
        List<Map> returnDetails = new ArrayList<>();
        List<Map> returnDetailsOut = new ArrayList<>();
        details.stream().forEach(m ->{
            Map map = new HashMap();
            Map mapOut = new HashMap();
            map.put("deductOrderNo",m.get("deductOrderNo"));
            mapOut.put("deductOrderNo",m.get("deductOrderNo"));
            map.put("message","订单待处理");
            mapOut.put("message","扣划成功！");
            map.put("status",2);
            mapOut.put("status",1);
            mapOut.put("deductDate",new Date());
            returnDetails.add(map);
            returnDetailsOut.add(mapOut);
        });
        resultOut.put("details", returnDetailsOut);
        System.out.print("扣款：");
        System.out.println(resultOut.toJSONString());
        result.put("details", returnDetails);
        return result;
    }

    /**
     * 清分接口
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/drd-admin/rf/smallloan/divide", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject smallloanDivide(@RequestBody JSONObject jsonParam) {
        JSONObject result = new JSONObject();
        JSONObject resultOut = new JSONObject();
        result.put("orderNo", jsonParam.get("orderNo"));
        resultOut.put("orderNo", jsonParam.get("orderNo"));
        result.put("requestNo", jsonParam.get("requestNo"));
        resultOut.put("requestNo", jsonParam.get("requestNo"));
        List<Map> details = (List) jsonParam.get("details");
        List<Map> returnDetails = new ArrayList<>();
        List<Map> returnDetailsOut = new ArrayList<>();
        details.stream().forEach(m ->{
            Map map = new HashMap();
            Map mapOut = new HashMap();
            map.put("deductOrderNo",m.get("deductOrderNo"));
            mapOut.put("deductOrderNo",m.get("deductOrderNo"));
            map.put("message","订单待处理");
            mapOut.put("message","分账成功！");
            map.put("status",1);
            mapOut.put("status",3);
            mapOut.put("divideDate",new Date());
            returnDetails.add(map);
            returnDetailsOut.add(mapOut);
        });
        resultOut.put("details", returnDetailsOut);
        System.out.print("清分：");
        System.out.println(resultOut.toJSONString());
        result.put("details", returnDetails);
        return result;
    }
}
