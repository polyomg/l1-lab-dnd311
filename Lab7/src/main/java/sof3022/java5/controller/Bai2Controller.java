package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sof3022.java5.service.ProductService;

@Controller
@RequiredArgsConstructor
public class Bai2Controller {

    private final ProductService productService;

    @RequestMapping("/bai2/search-and-pagination")
    public String bai2( Model model,
                        @RequestParam(value = "productName", defaultValue = "a") String productName,
                        @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber)
    {
        model.addAttribute("productName", productName);
        model.addAttribute("productPage", productService.getAllProductsByProductNameAndPagination(productName, pageNumber));
        return "bai-2";
    }

}
