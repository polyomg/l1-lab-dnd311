package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import sof3022.java5.entity.Staff;

@Controller
public class StaffController {
    @RequestMapping("/staff/create")
    public String staffCreate(
            Model model,
            @ModelAttribute("staff") Staff staff)
    {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên");
        return "staff-create";
    }

    @RequestMapping("/staff/create/save")
    public String creatSave(
            Model model,
            @ModelAttribute("staff") Staff staff,
            @RequestPart("photo_file")MultipartFile photoFile)
    {
        // Gán tên file upload cho thuộc tính photo của bean nếu có upload file
        if(!photoFile.isEmpty()){
            staff.setPhoto(photoFile.getName());
        }

        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "staff-create";
    }
}
