package learning.profiling.postProcessor;

import learning.profiling.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

//@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

//    @Value("parus.profiling")
    boolean profilingIsUnable = true;

    Map<String, Class> map = new HashMap<>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(Profiling.class)){
            map.put(beanName,beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(profilingIsUnable) {
                        System.out.println("Profiling start");
                        long befor = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println(proxy.getClass() + "Profiling finish " +  method.getName() + (after - befor));
                        return retVal;
                    }else{
                        return method.invoke(bean, args);
                    }
                }
            });

        }
        return bean;
    }

}
