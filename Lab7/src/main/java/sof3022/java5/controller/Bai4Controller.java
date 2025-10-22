package sof3022.java5.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sof3022.java5.dto.ReportInventoryByCategoryName;
import sof3022.java5.service.ProductService;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Bai4Controller {

    private final ProductService productService;

    @RequestMapping("/bai4")
    public String bai1(  Model model,
                         @RequestParam(value="min-price") Optional<Double> min,
                         @RequestParam(value = "max-price") Optional<Double> max)
    {
        Double minPrice = min.orElse(Double.MIN_VALUE);
        Double maxPrice = max.orElse(Double.MAX_VALUE);

        model.addAttribute("productList", productService.getAllProductsByPriceBetweenDSL(minPrice, maxPrice));
        return "bai-4";
    }
}
