package com.pets.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
@Slf4j
@SuppressWarnings("JavadocType")
public class LoggableAspect {

    @Pointcut("execution(* com.pets.api.services.*.*(..))")
    public void anyMethodInService() {
        //pointcut jsonObject, should be empty
    }

    @Pointcut("execution(* com.pets.api.assertions.*.*(..))")
    public void anyMethodInAssertion() {
        //pointcut jsonObject, should be empty
    }

    @Before("anyMethodInService() || anyMethodInAssertion()")
    public void step(JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // -> (1)
        final String name = joinPoint.getArgs().length <= 0 ? methodSignature.getName() + "()"
                : String.format( "%s (%s)", methodSignature.getName(), arrayToString(joinPoint.getArgs()));

        log.info(name);

    }

    private static String arrayToString(final Object... array) {
        return Stream.of(array)
                .map(object -> {
                    if (object.getClass().isArray()) {
                        return arrayToString((Object[]) object);
                    }
                    return Objects.toString(object);
                })
                .collect(Collectors.joining(", "));
    }
}
