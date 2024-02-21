package com.example.FinalProject.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class salCalculateEmployee {
    private double grossSalary;
    private String empID;
    private String month;
}
