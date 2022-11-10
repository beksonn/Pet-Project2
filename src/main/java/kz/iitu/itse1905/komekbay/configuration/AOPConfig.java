package kz.iitu.itse1905.komekbay.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPConfig {
    @Pointcut(value = "execution(* kz.iitu.itse1905.komekbay.service.Service.getFile(..))")
    public void method1(){ }

    @Before(value = "method1()")
    public void beforeMethod1(JoinPoint joinPoint){
        System.out.println("Logging getting file method #1: " + joinPoint.getSignature().getName());
    }


    @After(value = "method1()")
    public void afterMethod1(JoinPoint joinPoint){
        System.out.println("getting file method #1: " +
                joinPoint.getSignature().getName() + " has been successfully invoked");
    }

    @Pointcut(value = "execution(* kz.iitu.itse1905.komekbay.service.Service.saveFile(..))" )
    public void method2(){ }

    @AfterReturning(value = "method2()")
    public void beforeMethod2(JoinPoint joinPoint){
        System.out.println("Logging bank account method #2: " + joinPoint.getSignature().getName());
    }

    @Around(value = "method2()")
    public void afterMethod2(JoinPoint joinPoint){
        System.out.println("bank account method #2: " +
                joinPoint.getSignature().getName() + " has been successfully invoked");
    }

    @AfterThrowing(value = "method2()")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("bank account method #2: " +
                joinPoint.getSignature().getName() + " has been successfully invoked");
    }
}
