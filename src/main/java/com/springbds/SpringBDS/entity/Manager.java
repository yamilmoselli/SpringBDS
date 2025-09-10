package com.springbds.SpringBDS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "managers",
        uniqueConstraints = @UniqueConstraint(name = "unique_manager_dni", columnNames = "manager_dni"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// This annotation helps to stop the infinite cycle when printing a Local due to toString() method in Lombok.
// Is recommended to write this annotation in the child's class (the one who has mappedBy=..).
@ToString(exclude = "local")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "manager_id")
    private Long managerId;

    @NotBlank(message = "Empty first name is not valid")
    @Column(name = "manager_first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Empty last name is not valid")
    @Column(name = "manager_last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Empty dni is not valid")
    @Column(name = "manager_dni", nullable = false)
    private String dni;

    // "manager" references to attribute "private Manager manager" in Local class.
    @OneToOne(mappedBy = "manager", cascade = CascadeType.PERSIST)
    private Local local;


}
