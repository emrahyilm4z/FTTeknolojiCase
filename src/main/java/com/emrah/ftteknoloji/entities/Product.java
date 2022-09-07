package com.emrah.ftteknoloji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private double price;
    private LocalDate expiredDate; // yyyy-mm-dd
}
