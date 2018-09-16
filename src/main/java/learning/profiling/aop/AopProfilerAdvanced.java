package learning.profiling.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Aspect
public class AopProfilerAdvanced {
    private static final Logger log = LoggerFactory.getLogger(AopProfilerAdvanced.class);

    @Value("${parus.profiling.unable}")
    boolean profilingIsUnable;

    @Value("${parus.profiling.ifTimeLess:-1}")
    int ifTimeLess;

    public static final Map<String, Map> THREAD_METRIX = new HashMap<>();

    @Around("@annotation(learning.profiling.Profiling))")
    public Object profiling(ProceedingJoinPoint joinpoint) throws Throwable {
        Object output;
        if (profilingIsUnable){
            long start = System.nanoTime();
            output = joinpoint.proceed();
            long time = (System.nanoTime() - start) / 1000000;
            if(time > ifTimeLess){
                String nameMethod = joinpoint.getSignature().getDeclaringType() + "." + joinpoint.getSignature().getName();
                log.info(nameMethod + " milliSeconds " + time);
                Map<String, Long> map = THREAD_METRIX.get(Thread.currentThread().getName());
                if(map != null){
                    if(map.containsKey(nameMethod)){
                        Long allTime = map.get(nameMethod);
                        map.put(nameMethod, allTime + time);
                    }else{
                        map.put(nameMethod, time);
                    }
                }
            }
        }else{
            output = joinpoint.proceed();
        }
        return output;
    }

    @Around("@annotation(learning.profiling.RootProfiling))")
    public Object profilingRoot(ProceedingJoinPoint joinpoint) throws Throwable {
        Object output;
        if (profilingIsUnable){
            THREAD_METRIX.put(Thread.currentThread().getName(), new HashMap<String, Long>());
            output = joinpoint.proceed();
            Map map = THREAD_METRIX.get(Thread.currentThread().getName());
            countTime(map);
        }else{
            output = joinpoint.proceed();
        }
        return output;
    }

    private void countTime(Map<String, Long> map) {
        AtomicLong count = new AtomicLong(0);
        map.forEach((name, time) -> count.addAndGet(time));
        map.forEach((name, time) -> log.info(name + " Time% " + ( time * 100 / count.get()) + ", milisec " + time));
    }


}
