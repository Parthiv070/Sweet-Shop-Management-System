package com.sweetshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counter {
    @Id
    private String id; // collection name (like "sweet")
    private long seq;  // sequence number
}
