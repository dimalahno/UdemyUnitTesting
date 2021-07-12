package com.in28minutes.unittesting.unittesting.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void retrieveAllItems_strict_false() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
    }

    @Test
    public void retrieveAllItems_strict_true() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001,name:Item1,price:10,quantity:20,value:200}," +
                                        "{id:10002,name:Item2,price:5,quantity:10,value:50}," +
                                        "{id:10003,name:Item3,price:15,quantity:2,value:30}]", response, true);
    }
}
