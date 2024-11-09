package com.ak.userservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Response {
    private String message;
    private boolean success;
    private HttpStatus status;
}
