package com.example.FinalProject.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ResponseDTO {
    private String ResponseCode;
    private String ResponseMessage;
    private Object Data;

}
