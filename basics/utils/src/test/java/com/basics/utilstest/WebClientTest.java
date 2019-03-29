package com.basics.utilstest;

import com.basics.utils.Constants;
import com.basics.utils.WebClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xueshiqi
 * @since 2019/3/28
 */
public class WebClientTest {
    private static String url = "https://www.qichacha.com/search?key=%E6%B7%B1%E5%9C%B3%E8%BE%BE%E4%BA%BA%E8%B4%B7%E4%BA%92%E8%81%94%E7%BD%91%E9%87%91%E8%9E%8D%E6%9C%8D%E5%8A%A1%E4%BC%81%E4%B8%9A";
    Log log = LogFactory.getLog(WebClientTest.class);

    @Test
    public void webClientTestMain(){
        getWebContentByGetTest();
    }

    /**
     * 测试get请求方法
     */
    public void getWebContentByGetTest(){
        try {
            String content = WebClient.getWebContentByGet(url,Constants.CHAR_UTF,36000);
            log.info(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
