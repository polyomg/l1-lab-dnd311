package sof3022.java5.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public CookieService(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }

    public Cookie get(String name){
        // 1. Lấy tất cả cookie từ request
        Cookie[] cookies = req.getCookies();

        // 2. Kiểm tra xem có cookie nào được gửi lên không
        if(cookies != null){
            // 3. Lặp qua từng cookie
            for(Cookie cookie : cookies){
                // 4. So sánh tên cookie
                if(cookie.getName().equalsIgnoreCase(name)){
                    // 5. Nếu khớp, trả về đối tượng Cookie
                    return cookie;
                }
            }
        }
        // Nếu không tìm thấy hoặc cookies == null, trả về null
        return null;
    }

    public String getValue(String name){
        // Tái sử dụng phương thức get()
        Cookie cookie = get(name);
        if(cookie != null){
            return cookie.getValue(); // Trả về giá trị của cookie
        }
        return ""; // Trả về rỗng nếu không tìm thấy
    }

    public Cookie add(String name, String value, int hours){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(hours * 3600);
        resp.addCookie(cookie);
        return cookie;
    }

    public void remove(String name){
        Cookie cookie = get(name);
        if(cookie != null){ 
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }


}
