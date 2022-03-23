package javacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hellocontroller {
    /*@Autowired
    private CRUD_Controller crud_controller;*/

    @GetMapping("/account")
    public String Account(){
        return "hello";
    }

    /*@RequestMapping(value = "/registeration", method = RequestMethod.POST)
    public ModelAndView register_progress(@ModelAttribute Account account){
        crud_controller.UpdateAccount(account);
        return new ModelAndView("redirect:/");
    }*/
}
