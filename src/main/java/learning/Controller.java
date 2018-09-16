package learning;

import learning.profiling.Profiling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Profiling
    @GetMapping("test")
    public String test(){
//        throw new RuntimeException("testEx");
        return "Ok";
    }
}
