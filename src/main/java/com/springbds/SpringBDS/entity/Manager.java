package com.springbds.SpringBDS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "managers",
        uniqueConstraints = @UniqueConstraint(name = "unique_manager_dni", columnNames = "manager_dni"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manager_id")
    private Long id;

    @NotBlank(message = "Empty first name is not valid")
    @Column(name = "manager_first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Empty last name is not valid")
    @Column(name = "manager_last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Empty dni is not valid")
    @Column(name = "manager_dni", nullable = false)
    private String dni;


}
