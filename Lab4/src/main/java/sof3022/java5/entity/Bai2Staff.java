package sof3022.java5.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Bai2Staff {
    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    String id;

    @NotBlank(message = "Chưa nhập họ và tên")
    String fullname;

    @NotNull(message = "Chưa chọn giới tính")
    Boolean gender;

    @Builder.Default
    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date birthday = new Date();

    @Builder.Default
    String photo = "lab4.jpg";

    @Builder.Default
    Integer level = 0;

    @Min(value = 1000, message = "Lương tối thiểu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
    Double salary;
}
