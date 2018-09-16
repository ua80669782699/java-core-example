package learning;

import learning.profiling.Profiling;
import org.springframework.stereotype.Component;

@Component
public class SomeServise {

    @Profiling
    public void doSome(){
        sleep(2000);
    }

    @Profiling
    public void doSomeTwo(){
        sleep(1000);
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
