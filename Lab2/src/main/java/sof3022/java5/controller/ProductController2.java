package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sof3022.java5.entity.Product;


import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController2 {
    @GetMapping("/product2/form")
    public String form(Model model){
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("product1", p);
        model.addAttribute("product2", new Product());
        return "form3";
    }

    @PostMapping("/product2/save")
    public String save(@ModelAttribute("product2") Product p, Model model){
        model.addAttribute("product2", p);
        model.addAttribute("product1", new Product("iPhone 30", 5000.0));
        return "form3";
    }

    @ModelAttribute("items")
    public List<Product> getItems(){
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        );
    }

}
