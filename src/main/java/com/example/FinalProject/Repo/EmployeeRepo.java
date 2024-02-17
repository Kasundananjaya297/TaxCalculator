package com.example.FinalProject.Repo;

import com.example.FinalProject.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    @Query(value = "SELECT MAX(empID) FROM Employee", nativeQuery = true)
    String maxID();

    @Query(value = "SELECT * FROM Employee WHERE NIC = (:nic)", nativeQuery = true)
    Employee existsEmployeeByNIC(@Param("nic") String nic);
}
