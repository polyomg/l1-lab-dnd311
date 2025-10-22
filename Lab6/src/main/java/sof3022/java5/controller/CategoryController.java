package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sof3022.java5.entity.Category;
import sof3022.java5.service.CategoryService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping("/category/form")
    public String form(Model model){
        model.addAttribute("c", new Category());
        model.addAttribute("cl", categoryService.getAllCategories());
        return "category-form";
    }

    @PostMapping("/category/create")
    public String create(@ModelAttribute("c") Category category)
    {
        categoryService.createNewCategory(category);
        return "redirect:/form";
    }

    @PostMapping("/category/update/{id}")
    public String update(
            @PathVariable String id,
            @ModelAttribute("c") Category category)
    {
        categoryService.updateCategory(id, category);
        return "redirect:/edit/" + id;
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") String id)
    {
        categoryService.deleteCategoryById(id);
        return "redirect:/form";
    }

    @RequestMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        Optional<Category> optionalCategory = categoryService.getCategoryById(id);

        if(optionalCategory.isPresent()){
            model.addAttribute("c", optionalCategory.get());
            model.addAttribute("cl", categoryService.getAllCategories());
            return "category-form";
        }else{
            System.out.println("Category not found");
            return "redirect:/form";
        }



    }


}
