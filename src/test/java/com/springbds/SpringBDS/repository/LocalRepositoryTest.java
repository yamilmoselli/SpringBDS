package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Local;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;
    @Autowired
    TestEntityManager testEntityManager;

    // Creates a db in memory before execute tests
    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                .name("Sarkany")
                .floor(7)
                .code("sk007")
                .build();
        testEntityManager.persist(local);
    }

    @Test
    public void findLocalByNameIgnoreCaseFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Sarkany");
        assertEquals("Sarkany", local.get().getName());
    }

    @Test
    public void findLocalByNameIgnoreCaseFound2() {
        Local local = localRepository.findByNameIgnoreCase("Sarkany").get();
        assertEquals("Sarkany", local.getName());
    }

    @Test
    public void findLocalByNameIgnoreCaseNotFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Lacoste");
        assertEquals(Optional.empty(), local);
    }
}