package study.service.impl;

import org.springframework.stereotype.Service;
import study.service.DemoSingletonService;

/**
 * 这里不给 Scope 表示默认使用 @Scope("singleton")
 * @author xueshiqi
 * @since 2018/9/14
 */
@Service
public class DemoSingletonServiceImpl implements DemoSingletonService {
}
