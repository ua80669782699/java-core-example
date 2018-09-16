package learning.profiling.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopProfiler {
    private static final Logger log = LoggerFactory.getLogger(AopProfiler.class);

    @Around("@annotation(learning.profiling.Profiling))")
    public Object profiling(ProceedingJoinPoint joinpoint) {
        Object output = null;
        long start = System.nanoTime();
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info(joinpoint.getSignature().getDeclaringType() + joinpoint.getSignature().getName() + " milliSeconds " + ((System.nanoTime() - start) / 1000000));
        return output;
    }

}
