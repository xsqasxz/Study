package study.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import study.service.DemoPrototypeService;

/**
 * 这里指定了@Scope("prototype")
 * @author xueshiqi
 * @since 2018/9/14
 */
@Service
@Scope("prototype")
public class DemoPrototypeServiceImpl implements DemoPrototypeService {
}
