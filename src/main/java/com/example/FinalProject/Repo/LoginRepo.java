package com.example.FinalProject.Repo;

import com.example.FinalProject.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepo extends JpaRepository<Admin, String>{

    @Modifying
    @Query("UPDATE Admin SET password = :newPassword WHERE userName = :userName")
    int changePassword(@Param("userName") String userName, @Param("newPassword") String newPassword);
}
