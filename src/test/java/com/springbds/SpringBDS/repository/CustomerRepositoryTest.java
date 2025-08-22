package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private TestEntityManager testEntityManager;

    private Customer savedC1;
    private Customer c2;
    private Customer c3;
    private Customer c4;

    @BeforeEach
    void setUp(){
        savedC1 = Customer.builder()
                .firstName("Carlos")
                .lastName("Perez")
                .country("Argentina")
                .dni("12345678")
                .build();

        c2 = Customer.builder()
                .firstName("Juan")
                .lastName("Moselli")
                .country("Argentina")
                .dni("23789456")
                .build();

        c3 = Customer.builder()
                .firstName("Camilo")
                .lastName("Gonzalez")
                .country("Peru")
                .dni("23784203")
                .build();

        c4 = Customer.builder()
                .firstName("Juan")
                .lastName("Gonzalez")
                .country("Chile")
                .dni("23784206")
                .build();

        testEntityManager.persist(savedC1);
        testEntityManager.persist(c2);
        testEntityManager.persist(c3);
        testEntityManager.persist(c4);
    }

    @Test
    public void saveCustomerTest() {

        assertEquals("Carlos", savedC1.getFirstName());
        assertNotNull(savedC1.getId());
    }

    @Test
    public void findByFirstNameContainingTest() {
        List<Customer> lista = customerRepository.findByFirstNameContaining("il");
        System.out.println(lista);
    }

    @Test
    public void findByCountryTest(){
        List<Customer> lista = customerRepository.findByCountry("Argentina");
        System.out.println(lista);
    }

    @Test
    public void getFirstNameByDniTest(){
        String first_name = customerRepository.getFirstNameByDni("23784206");
        System.out.println("firstName = " + first_name);
    }

    @Test
    public void getCountryByDniTest(){
        String returnedCountry = customerRepository.getCountryByDni("23784206");
        System.out.println("Country = " + returnedCountry);
    }

}