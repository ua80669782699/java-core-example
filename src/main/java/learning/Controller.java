package learning;

import learning.profiling.Profiling;
import learning.profiling.RootProfiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SomeServise someServise;

    @RootProfiling
    @GetMapping("test")
    public String test(){
        someServise.doSome();
        someServise.doSomeTwo();
        return "Ok";
    }


//    @Profiling//не будет работать
//    public void doSome(){
//    }
}
