package study.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 定义一个切面
 * @author xueshiqi
 * @since 2018/9/13
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(study.annotation.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        final Class clazz = joinPoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        method.getParameters();
        method.getAnnotations();
        Action action = method.getAnnotation(Action.class);
        System.out.println("输出注解："+method.getAnnotation(Action.class).name());
        System.out.println("输出注解："+action.name());
    }
}
