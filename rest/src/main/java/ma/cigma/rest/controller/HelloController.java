package ma.cigma.rest.controller;
//Attention : ce package ne sera pas scané par @SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @RequestMapping(value = { "/hello", "/" })
    public String hello() {
        System.out.println("ce package ne sera pas scané par @SpringBootApplication");
        return "Hello World From my first API @RestControler";
    }
}