package study.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import study.service.DemoService;

/**
 * @author xueshiqi
 * @since 2018/9/14
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Value("其他类的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
