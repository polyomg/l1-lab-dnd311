package sof3022.java5.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final HttpSession session;

    public SessionService(HttpSession session){
        this.session = session;
    }

    @SuppressWarnings("unchecked") // Bỏ qua cảnh báo unchecked cast
    public<T> T get(String name){ // <T> để khai báo là kiểu tổng quát (Generic Type Parameter) và T là kiểu trả về (Return Type)
        // Trả về kết quả quả từ ép kiểu trực tiếp.
        return (T) session.getAttribute(name);
    }

    public void set(String name, Object value){
        session.setAttribute(name, value);
    }

    public void remove(String name){
        session.removeAttribute(name);
    }

}
