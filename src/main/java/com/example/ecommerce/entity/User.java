package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "ecommerce")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String fullName;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
