package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class Calculator {
    @GetMapping("/form")
    public String form(){
        return "calculator";
    }

    @PostMapping("/area")
    public String area(@RequestParam("length") Double length,
                       @RequestParam("width") Double width,
                       Model model) {
        model.addAttribute("result", length * width);
        return "calculator";
    }

    @PostMapping("/perimeter")
    public String perimeter(@RequestParam("length") Double length,
                            @RequestParam("width") Double width,
                            Model model){
        model.addAttribute("result", (length + width) * 2);
        return "calculator";
    }





}
