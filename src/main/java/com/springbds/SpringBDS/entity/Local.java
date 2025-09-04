package com.springbds.SpringBDS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Table(name = "locals",
        uniqueConstraints = {
            @UniqueConstraint(name = "unique_name", columnNames = "name"),
            @UniqueConstraint(name = "unique_code", columnNames = "code")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can not be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @NotBlank(message = "Code can not be empty")
    @Column(name = "code", nullable = false)
    @Size(min = 2, max = 10)
    private String code;

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    private Manager manager;

}
