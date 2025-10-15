package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/form")
    public String form(){
        return "form";
    }
    @PostMapping("/check")
    public String login(Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("") || password.equals("")){
            model.addAttribute("message", "Please enter username and password");
        }else if("poly".equals(username.trim()) && "123".equals(password.trim())){
            model.addAttribute("message", "Login successful");
        }else{
            model.addAttribute("message", "Login failed");
        }
        return "form";
    }

}
