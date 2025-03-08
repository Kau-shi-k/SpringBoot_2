package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Auth_Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is Required")
    private String firstName;

    @NotBlank(message = "Last Name is Required")
    private String lastname;

    @Email(message = "Invalid Email format")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is Required")
    private String password;

}
