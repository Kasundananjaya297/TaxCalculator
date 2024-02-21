package com.example.FinalProject.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ChangePwDTO {
    private String userName;
    private String currentPassword;
    private String newPassword;

}
