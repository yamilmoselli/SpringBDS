package com.springbds.SpringBDS.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer floor;
    private String code;

}
