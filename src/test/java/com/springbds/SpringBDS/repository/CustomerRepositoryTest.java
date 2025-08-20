package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

// Esta anotacion crea una db en memoria + rollback, por lo que
// ejecutar los tests no impactan en la base de datos real.

/*
¿Por qué la info usada en tests NO debe guardarse permanentemente?
Contaminación de datos: Los tests crearían datos basura
Tests no repetibles: El segundo test podría fallar por datos del primero
Dependencias entre tests: Un test podría depender de datos de otro
Limpieza manual: Tendrías que limpiar manualmente después de cada test
 */
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest() {
        Customer c1 = Customer.builder()
                .firstName("Carlos")
                .lastName("Perez")
                .country("Argentina")
                .dni("12345678")
                .build();

        Customer savedCustomer = customerRepository.save(c1);
        assertEquals("Carlos", savedCustomer.getFirstName());
        assertNotNull(savedCustomer.getId());
    }

}