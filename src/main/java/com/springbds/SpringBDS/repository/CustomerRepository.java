package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);
    // List<Customer> findByFirstNameContaining(String first_name);

}
