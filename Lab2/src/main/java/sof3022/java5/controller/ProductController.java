package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sof3022.java5.entity.Product;


@Controller
public class ProductController {

    @GetMapping("/product/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "form2";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("product", product);
        return "form2";
    }

}
