package com.in28minutes.ranga.socialmediaapplication.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExceptionMessage {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
