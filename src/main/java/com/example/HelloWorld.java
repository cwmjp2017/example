package com.example;

/**
 * Created by chu on 2017/11/04.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloWorld {
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
