package Tool;

import Tool.com.baidu.translate.demo.TransApi;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Map;


public class 百度翻译接口 {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170921000084428";
    private static final String SECURITY_KEY = "XNX_jedQVp21xH42KcX0";

    /**
     * 百度翻译接口翻译英文，返回中文
     * @param neiRong 需要翻译的英文
     * @return 返回翻译后的中文
     */
    public String fanyi(String neiRong){
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String fanhui = api.getTransResult(neiRong,"en","auto");
        Gson gson = new Gson();
        Map map = gson.fromJson(fanhui,Map.class);
        ArrayList list = (ArrayList) map.get("trans_result");
        if(CollectionUtils.isNotEmpty(list)) {
            LinkedTreeMap<String, String> linkedTreeMap = (LinkedTreeMap) list.get(0);
            return linkedTreeMap.get("dst");
        }
        return null;
    }
}
