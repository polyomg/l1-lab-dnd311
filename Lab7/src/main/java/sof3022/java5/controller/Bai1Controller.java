package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sof3022.java5.service.ProductService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Bai1Controller {

    private final ProductService productService;

    @RequestMapping("/bai1/search")
    public String bai1(  Model model,
                            @RequestParam(value="min-price") Optional<Double> min,
                            @RequestParam(value = "max-price") Optional<Double> max)
    {
        Double minPrice = min.orElse(Double.MIN_VALUE);
        Double maxPrice = max.orElse(Double.MAX_VALUE);

//        model.addAttribute("productList", productService.getAllProductsByPriceBetween(minPrice, maxPrice));
        model.addAttribute("productList", productService.getAllProductsByPriceBetween(minPrice, maxPrice));
        return "bai-1";
    }



}
