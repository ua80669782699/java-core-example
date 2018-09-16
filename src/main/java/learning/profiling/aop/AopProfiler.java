package learning.profiling.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopProfiler {
    private static final Logger log = LoggerFactory.getLogger(AopProfiler.class);

    @Value("${parus.profiling.unable}")
    boolean profilingIsUnable;

    @Value("${parus.profiling.ifTimeLess:0}")
    int ifTimeLess;

    @Around("@annotation(learning.profiling.Profiling))")
    public Object profiling(ProceedingJoinPoint joinpoint) throws Throwable {
        Object output;
        if (profilingIsUnable){
            long start = System.nanoTime();
            output = joinpoint.proceed();
            long time = (System.nanoTime() - start) / 1000000;
            if(time>ifTimeLess){
                log.info(joinpoint.getSignature().getDeclaringType() + "." + joinpoint.getSignature().getName() + " milliSeconds " + time);
            }
        }else{
            output = joinpoint.proceed();
        }
        return output;
    }

}
