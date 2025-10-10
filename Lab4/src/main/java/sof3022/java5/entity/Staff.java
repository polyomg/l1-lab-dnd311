package sof3022.java5.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Staff {
    String id;

    String fullname;

    @Builder.Default
    String photo = "lab4.jpg";

    Boolean gender;

    @Builder.Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date birthday = new Date();

    @Builder.Default
    Double salary = 12345.6789;

    @Builder.Default
    Integer level = 0;

}
