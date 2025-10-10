package sof3022.java5.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Staff {
    String id;
    String fullname;
    @Builder.Default
    String photo = "lab3_bai1.jpg";
    @Builder.Default
    Boolean gender = true;
    @Builder.Default
    Date birthday = new Date();
    @Builder.Default
    Double salary = 12345.6789;
    @Builder.Default
    Integer level = 0;
}
