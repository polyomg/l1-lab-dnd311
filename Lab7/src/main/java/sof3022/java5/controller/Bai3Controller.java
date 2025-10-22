package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sof3022.java5.dto.ReportInventoryByCategoryName;
import sof3022.java5.repository.ProductRepository;
import sof3022.java5.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Bai3Controller {

    private final ProductService productService;

    @RequestMapping("/bai3")
    public String bai3(Model model){
        List<ReportInventoryByCategoryName> reportInventoryList = productService.getAllInventoryByCategoryName();
        model.addAttribute("inventoryList",reportInventoryList);
        return "bai-3";
    }

}
