package sof3022.java5.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import sof3022.java5.entity.Bai2Staff;

@Controller
public class Bai2ValidationController {
    @GetMapping("/bai2/form")
    public String bai2Form(
            Model model,
            @ModelAttribute("bai2Staff") Bai2Staff bai2Staff) {
        model.addAttribute("message", "Điền thông tin vào form sau");
        return "bai2-validation-form";
    }

    @PostMapping("/bai2/form/validation")
    public String bai2FormValidation(
            Model model,
            @RequestPart("photo_file") MultipartFile photoFile,
            @Valid @ModelAttribute("bai2Staff") Bai2Staff bai2Staff,
            Errors errors) {

        if (!photoFile.isEmpty()) {
            bai2Staff.setPhoto(photoFile.getName());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng");
        }
        return "bai2-validation-form";
    }
}