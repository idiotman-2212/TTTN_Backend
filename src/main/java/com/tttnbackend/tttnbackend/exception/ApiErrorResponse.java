package com.tttnbackend.tttnbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class ApiErrorResponse {
    int statusCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dateTime;
    String message;
}
