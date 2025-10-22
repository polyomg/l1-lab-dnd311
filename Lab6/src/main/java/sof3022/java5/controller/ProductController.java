package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sof3022.java5.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //====== Bài 3 ======//

    @RequestMapping("/product/form")
    public String productForm(Model model) {
        model.addAttribute("productList", productService.getAllProductsWithFieldSort("price"));
        return "product-form";
    }

    @RequestMapping("/product/form/field-sort/{fieldSort}")
    public String productForm(
            Model model,
            @PathVariable("fieldSort") String fieldSort) {
        model.addAttribute("productList", productService.getAllProductsWithFieldSort(fieldSort));
        return "product-form";
    }

    //====== Bài 4 ======//

    @RequestMapping("/product/pagination")
    public String productPagination(Model model)
    {
        model.addAttribute("page", productService.getAllProductsWithPagination(0));
        return "pagination-product";
    }

    @RequestMapping("/product/pagination/{page-number}")
    public String productPagination(
            Model model,
            @PathVariable("page-number") Integer pageNumber)
    {
        model.addAttribute("page", productService.getAllProductsWithPagination(pageNumber));
        return "pagination-product";
    }

    //====== Bài 5 ======//

    @RequestMapping("/product/pagination-and-sort")
    public String productPaginationAndSort(
            Model model,
            @RequestParam(value = "page-number", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "direction-sort",defaultValue = "ASC") String directionSort,
            @RequestParam(value = "field-sort", defaultValue = "id") String fieldSort)
    {

        model.addAttribute("page", productService.getAllProductsWithPaginationAndSort(pageNumber, directionSort, fieldSort));
        model.addAttribute("directionSortCurrent", directionSort);
        model.addAttribute("fieldSortCurrent", fieldSort);
        model.addAttribute("directionSortRevert", directionSort);
        return "pagination-and-sort";

    }


}
