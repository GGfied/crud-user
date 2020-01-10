package com.derrick.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username", nullable = false, unique = true)
    @NonNull
    @NotBlank(message = "Username is required")
    private String username;

    @Column(name = "name", nullable = false)
    @NonNull
    @NotBlank(message = "Name is required")
    private String name;
}
