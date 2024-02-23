package com.example.FinalProject.Repo;

import com.example.FinalProject.Entity.Employee;
import com.example.FinalProject.Entity.SalarayProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface salaryRepo extends JpaRepository<SalarayProcess,String> {

    @Modifying
    @Query(value ="INSERT INTO salary_process(f_empID, Month, gross_salary, deducted_tax, employee_contribution, employer_contribution, ETF, total_epf, take_home_sal) values(:empID, :Month, :grossSalary, :deductedTax, :EmployeeContribution, :EmployerContribution, :ETF, :totalEpf, :takeHomeSal)", nativeQuery = true)
    int saveSalary(@Param("empID") String empID, @Param("Month") String month, @Param("grossSalary") double grossSalary, @Param("deductedTax") double deductedTax, @Param("EmployeeContribution") double employeeContribution, @Param("EmployerContribution") double employerContribution, @Param("ETF") double ETF, @Param("totalEpf") double totalEpf, @Param("takeHomeSal") double takeHomeSal);

    @Query(value = "SELECT COUNT(*) FROM salary_process WHERE Month = :month AND f_empID =:f_empID",nativeQuery = true)
    int existsAllByMonthAndId(@Param("month") String month,@Param("f_empID") String f_empID);
    @Query(value = "SELECT * FROM salary_process WHERE f_empid = (:id)", nativeQuery = true)
    List<SalarayProcess> findByEmpID(@Param("id") String id);
}
