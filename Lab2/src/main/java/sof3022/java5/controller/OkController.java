package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/ctrl")
public class OkController {
    @PostMapping("/ok")
    public String m1(Model model){
        model.addAttribute("result","ok1");
        return "ok";
    }

    @GetMapping("/ok")
    public String m2(Model model){
        model.addAttribute("result","ok2");
        return "ok";
    }
    @PostMapping(value="/ok", params="x")
    public String m3(Model model){
        model.addAttribute("result","ok3");
        return "ok";
    }

}
