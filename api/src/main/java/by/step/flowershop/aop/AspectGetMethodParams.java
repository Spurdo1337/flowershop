package by.step.flowershop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
public class AspectGetMethodParams {

    @Pointcut("execution (public * by.step.flowershop.service.FlowerService.*(..))")
    private void test() {
    }


    @Before("test()")
    public void getAllMethods(JoinPoint joinPoint) {
        List<Object> collect = Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList());
        System.out.println("****LoggingAspect.logBeforeAllMethods() : "
                + collect);
    }


    @AfterThrowing(pointcut = "execution ( public * by.step.flowershop.service.FlowerService.*(..))", throwing = "exception")
    public void loggingExceptionControllerLayer(JoinPoint joinPoint, Throwable exception) {

        List<Object> collect = Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList());
        System.out.println("****LoggingAspect.exception() : "
                + collect + "" + exception.getMessage());
    }

}
