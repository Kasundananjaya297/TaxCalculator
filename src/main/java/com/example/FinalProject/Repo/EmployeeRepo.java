package com.example.FinalProject.Repo;

import com.example.FinalProject.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    @Query(value = "SELECT MAX(empID) FROM Employee", nativeQuery = true)
    String maxID();

    @Query(value = "SELECT * FROM Employee WHERE NIC = (:nic)", nativeQuery = true)
    Employee existsEmployeeByNIC(@Param("nic") String nic);

    @Query(value = "SELECT * FROM Employee WHERE emp_name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Employee> findByEmpName(@Param("name") String name);
}
