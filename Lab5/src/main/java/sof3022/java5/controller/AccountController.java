package sof3022.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import sof3022.java5.service.CookieService;
import sof3022.java5.service.ParamService;
import sof3022.java5.service.SessionService;

import java.io.File;

@Controller
public class AccountController {

    private final ParamService paramService;
    private final CookieService cookieService;
    private final SessionService sessionService;

    public AccountController(ParamService paramService, CookieService cookieService, SessionService sessionService) {
        this.paramService = paramService;
        this.cookieService = cookieService;
        this.sessionService = sessionService;
    }

    @GetMapping("/account/login")
    public String login1(Model model){
        String username = cookieService.getValue("user");
        model.addAttribute("username", username);
        return "login";
    }

    @PostMapping("/account/login")
    public String login2(Model model){
        String un = paramService.getString("username", "");
        String pwd = paramService.getString("password", "");
        boolean rmbMe = paramService.getBoolean("remember-me", false);

        if(("").equals(un) || ("").equals(pwd)) {
            model.addAttribute("message", "Enter username and password");
            return "login";
        }else if(("poly").equals(un) && ("123").equals(pwd)){
            model.addAttribute("message", "Login Successfully !!!");
            sessionService.set("username", un);
            if(!rmbMe){
                cookieService.remove("user");
            }else{
                cookieService.add("user", un, 10 * 24);
            }
            return "login";
        }else{
            model.addAttribute("message", "Username or password is incorrect...");
            return "login";
        }
    }

    @GetMapping("account/register")
    public String register1(){
        return "register";
    }

    @PostMapping("account/register")
    public String register2(
            Model model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("avatar") MultipartFile avatar)
    {

        if(username == null || password == null || email == null || avatar == null){
            model.addAttribute("message", "Enter username, password and email");
        }else{
            try{
                // Gọi phương thức save() của lớp ParamService đã định nghĩa để lưu file upload
                File savedFile = paramService.save(avatar, "/images");

                if(savedFile != null){
                    // Lấy đường dẫn hiển thị file
                    String imgPath = "/images/" + savedFile.getName();

                    // Trả dữ liệu về view
                    model.addAttribute("username", username);
                    model.addAttribute("email", email);
                    model.addAttribute("imgPath", imgPath);
                    model.addAttribute("message", "Register Successfully !!!");
                }else{
                    model.addAttribute("message", "Choose your avatar");
                }

            }catch(Exception ex){
                model.addAttribute("message", "Lỗi khi lưu ảnh: " + ex.getMessage());
            }
        }

        return "register";

    }

}
