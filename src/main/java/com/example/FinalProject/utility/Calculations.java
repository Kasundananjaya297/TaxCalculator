package com.example.FinalProject.utility;


import org.springframework.stereotype.Service;


@Service
public class Calculations {

    public double TexCalculate(double grossSalary){
        double finalTax=0;
        if(grossSalary > 308333){
            finalTax = grossSalary * 0.36;
        } else if (grossSalary > 266667) {
            finalTax = grossSalary * 0.30;
        }else if (grossSalary > 225000) {
            finalTax = grossSalary * 0.24;
        }else if (grossSalary > 183333) {
            finalTax = grossSalary * 0.18;
        }else if (grossSalary > 141667) {
            finalTax = grossSalary * 0.12;
        }else if (grossSalary > 100000) {
            finalTax = grossSalary * 0.06;
        }else{
            finalTax = grossSalary * 0.0;
        }
        return finalTax;
    }
    public double getEmployeeContribution(double grossSalary){
        return grossSalary*0.08;
    }
    public double getEmployerContribution(double grossSalary){
        return grossSalary * 0.12;
    }
    public double getTotalEpf(double grossSalary){
        return getEmployeeContribution(grossSalary) + getEmployerContribution(grossSalary);
    }
    public double getETF(double grossSalary){
        return grossSalary*0.03;
    }
    public double TakeHomeSal(double grossSalary){
        return grossSalary - (TexCalculate(grossSalary)+getEmployeeContribution(grossSalary)+getETF(grossSalary));
    }
}
