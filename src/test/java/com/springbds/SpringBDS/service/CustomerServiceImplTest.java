package com.springbds.SpringBDS.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/*
    Con @SpringBootTest cargamos toodo el contexto de la app, incluida la db.
    Pero con @Transactional evitamos que los tests impacten sobre la db, ya
    que hace un rollback.
*/
@SpringBootTest
@Transactional
class CustomerServiceImplTest {

}