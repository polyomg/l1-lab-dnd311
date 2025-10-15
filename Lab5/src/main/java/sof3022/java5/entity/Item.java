package sof3022.java5.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Integer id;
    String name;
    double price;
    int qty = 1;
}
