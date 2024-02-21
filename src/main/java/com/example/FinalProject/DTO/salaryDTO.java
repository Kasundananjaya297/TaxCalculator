package com.example.FinalProject.DTO;


import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class salaryDTO {
    private String  empID;
    private String Month;
    private double grossSalary;
    private double deductedTax;
    private double EmployeeContribution;
    private double EmployerContribution;
    private double ETF;
    private double totalEpf;
    private double takeHomeSal;
}
