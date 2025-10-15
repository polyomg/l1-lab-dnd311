package sof3022.java5.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    // Đọc giá trị chuỗi của tham số
    public String getString(String name, String defaultValue){

        String value = request.getParameter(name);

        return value == null ? defaultValue : value;

    }

    // Đọc giá trị số nguyên của tham số
    public int getInteger(String name, int defaultValue){

        String valueString = request.getParameter(name);
        int value = Integer.parseInt(valueString);

        if(valueString == null) {
            return defaultValue;
        }else {
            return value;
        }

    }

    // Đọc giá trị số thực của tham số
    public double getDouble(String name, double defaultValue){

        String valueString = request.getParameter(name);
        double value = Double.parseDouble(valueString);

        if(valueString == null){
            return defaultValue;
        }else{
            return value;
        }
    }

    // Đọc giá trị boolean của tham số
    public boolean getBoolean(String name, boolean defaultValue){

        String valueString = request.getParameter(name);
        boolean value = Boolean.parseBoolean(valueString);

        if(valueString == null) {
            return defaultValue;
        }else{
            return value;
        }

    }

    // Đọc giá trị thời gian của tham số
    public Date getDate(String name, String pattern){
        String value = request.getParameter(name);
        if(value == null){
            return null;
        }

        try {
            return new SimpleDateFormat(pattern).parse(value);
        }catch(ParseException pe){
            throw new RuntimeException("Lỗi sai định dạng" + pe.getMessage());
        }

        }

    // Lưu file upload vào thư mục
    public File save(MultipartFile file, String path){
        if(file == null || file.isEmpty()){
            return null;
        }

        try{
            // Lấy đường dẫn tuyệt đối trong webapp
            String realPath = request.getServletContext().getRealPath(path);
            File dir = new File(realPath);
            if(!dir.exists()){
                dir.mkdirs(); //Tạo thư mục nếu chưa có
            }

            // Lưu File
            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);
            return savedFile;
        }catch(Exception ex){
            throw new RuntimeException("Lỗi lưu file" + ex.getMessage());
        }
    }


}
