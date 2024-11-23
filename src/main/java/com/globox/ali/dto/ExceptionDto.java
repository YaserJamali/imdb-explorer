package com.yaser.edu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd'T'HH:mm:ss")
    private Date timeStamp;
    private String message;
//    private int errorCode;
}
