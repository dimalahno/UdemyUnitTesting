package com.in28minutes.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.in28minutes.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll() {
        List<Item> items =  repository.findAll();
        assertEquals(3, items.size());
    }
}
