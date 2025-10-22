package sof3022.java5.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sof3022.java5.service.ProductService;

@Controller
@RequiredArgsConstructor

public class Bai5Controller {

    private final ProductService productService;

    @RequestMapping("/bai5")
    public String bai2( Model model,
                        @RequestParam(value = "productName", defaultValue = "a") String productName,
                        @RequestParam(value = "pageNumberCurrent", defaultValue="0") Integer pageNumberCurrent)
    {
        Integer pageNumber = pageNumberCurrent;
        model.addAttribute("productPage", productService.getAllProductsByProductNameAndPaginationDSL(productName, pageNumber));
        model.addAttribute("productName", productName);
        model.addAttribute("pageNumberCurrent", pageNumberCurrent);
        return "bai-5";
    }
}
