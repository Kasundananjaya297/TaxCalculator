package com.example.FinalProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name = "userName",length = 45)
    private String userName;

    @Column(name= "password",length = 255)
    private String password;
}
