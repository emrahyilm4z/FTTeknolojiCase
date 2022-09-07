package com.emrah.ftteknoloji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comments")
public class Comment {
    @NotNull
    private int id;
    @NotNull
    @Size(max = 500)
    private String comment;
    @NotNull
    private LocalDate commentDate;
    @NotNull
    private int productId;
    @NotNull
    private int userId;
}
