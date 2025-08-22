package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameContaining(String firstName);
    List<Customer> findByCountry(String country);

    // JPQL query
    @Query("SELECT c.firstName FROM Customer c WHERE c.dni=?1")
    String getFirstNameByDni(String dni);

    // Native query
    @Query(
            value = "SELECT country FROM customers WHERE dni=?1",
            nativeQuery = true
    )
    String getCountryByDni(String dni);
}
