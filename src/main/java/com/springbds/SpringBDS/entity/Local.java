package com.springbds.SpringBDS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;


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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    // With nullable=true, when I create a local, its manager would be null.
    // But then I have to set that attribute, sending a manager entire object.
    // This is a way to reduce coupling between these two tables.
    // name = .. is the name who would be on the column
    // referencedColumnName is the attribute name on class manager
    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "managerId", nullable = true)
    private Manager manager;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private List<Order> orderList;

}
