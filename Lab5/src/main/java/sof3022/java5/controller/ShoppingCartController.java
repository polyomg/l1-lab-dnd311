package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sof3022.java5.service.ShoppingCartService;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/view")
    public String view(Model model){
        model.addAttribute("shoppingCart", shoppingCartService);
        return "shoppingcart";
    }

    @RequestMapping("/add/{itemId}")
    public String add(@PathVariable("itemId") Integer itemId){
        shoppingCartService.add(itemId);
        return "redirect:/shoppingcart/view";
    }

    @PostMapping("/update/{itemId}")
    public String update(@PathVariable("itemId") Integer itemId,
                         @RequestParam("qty") int qty){
        shoppingCartService.update(itemId, qty);
        return "redirect:/shoppingcart/view";
    }

    @RequestMapping("/remove/{itemId}")
    public String remove(@PathVariable("itemId") Integer itemId){
        shoppingCartService.remove(itemId);
        return "redirect:/shoppingcart/view";
    }

    @RequestMapping("/clear")
    public String clear(){
        shoppingCartService.clear();
        return "redirect:/shoppingcart/view";
    }



}
