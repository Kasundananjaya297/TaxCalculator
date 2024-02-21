package com.example.FinalProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SalaryProcess")
@NoArgsConstructor
@AllArgsConstructor
public class SalarayProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_empID", referencedColumnName = "empID")
    private Employee employee;


    @Column(length = 10, nullable = false)
    private String month;


    @Column(name = "grossSalary")
    private double grossSalary;

    @Column(name = "deductedTax")
    private double deductedTax;

    @Column(name = "EmployeeContribution")
    private double employeeContribution;

    @Column(name = "EmployerContribution")
    private double employerContribution;

    @Column(name = "totalEpf")
    private double totalEpf;

    @Column(name = "takeHomeSal")
    private double takeHomeSal;

    @Column(name = "ETF")
    private double ETF;

}
