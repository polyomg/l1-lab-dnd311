package sof3022.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai4FragmentController {

    @RequestMapping("/bai3/form")
    public String bai3Form(){
        return "bai3-trangchu";
    }

    @GetMapping("/bai3/trangchu")
    public String bai3TrangChu(){
        return "bai3-trangchu";
    }

    @GetMapping("/bai3/gioithieu")
    public String bai3GioiThieu(){
        return "bai3-gioithieu";
    }
}
