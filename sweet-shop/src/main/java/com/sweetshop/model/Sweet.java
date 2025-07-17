package com.sweetshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sweets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sweet {

    @Id
    private long id;

    private String name;
    private String category;
    private double price;
    private int quantity;
}
