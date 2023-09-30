package com.in28minutes.ranga.socialmediaapplication.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private int id;
    @Size(min = 2,message = "Name should be minimum 2 character")
    private  String name;
    @Past(message = "Date should not be future date")
    private LocalDate birthDate;
}
