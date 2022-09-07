package com.emrah.ftteknoloji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    @NotNull
    private int id;
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    @Size(max = 50)
    private String lastName;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    @Size(max = 15)
    private String telNo;

}
