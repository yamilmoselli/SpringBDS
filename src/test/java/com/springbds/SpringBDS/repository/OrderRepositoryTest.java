package com.springbds.SpringBDS.repository;

import com.springbds.SpringBDS.entity.Local;
import com.springbds.SpringBDS.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrder() {
        Local local1 = Local.builder()
                .name("nike")
                .floor(3)
                .code("nk03")
                .build();

        Order order1 = Order.builder()
                .description("air max 90")
                .totalPrice(90.0)
                .local(local1)
                .build();

        orderRepository.save(order1);

    }

}