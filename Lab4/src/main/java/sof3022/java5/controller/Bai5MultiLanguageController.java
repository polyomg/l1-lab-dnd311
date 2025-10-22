package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai5MultiLanguageController {

    @GetMapping("/bai5/home")
    public String bai5Home(){
        return "bai5-home";
    }

    @GetMapping("/bai5/about")
    public String bai5About(){
        return "bai5-about";
    }

}
