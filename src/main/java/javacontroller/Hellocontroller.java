package javacontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hellocontroller {
    private Account_CRUD_imp account_crud_imp;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
