package com.example.FinalProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String empID;
    @Column(length = 30)
    private String empName;
    @Column(length = 30)
    private String city;
    @Column(length = 15, nullable = false , unique = true)
    private String NIC;
}
