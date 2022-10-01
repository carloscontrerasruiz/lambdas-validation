package com.github.carloscontrerasruiz.lambdas_validation.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheServiceTest {

    TheService service;

    @BeforeEach
    void setup() {
        service = new TheService();
    }

    @Test
    void insertPerson1() {

        try {
            Person person = this.service.insertPerson1(Person.builder().build());
            assertNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("parametrso incorrectos", ex.getMessage());
        }

        try {
            Person person = this.service.insertPerson1(Person.builder()
                    .name("name")
                    .address("adress")
                    .lastName("lastname")
                    .age(5)
                    .build());
            assertNotNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("", ex.getMessage());
        }


    }

    @Test
    void insertPerson2() {
        try {
            Person person = this.service.insertPerson2(Person.builder().build());
            assertNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("parametrso incorrectos", ex.getMessage());
        }

        try {
            Person person = this.service.insertPerson2(Person.builder()
                    .name("name")
                    .address("adress")
                    .lastName("lastname")
                    .age(5)
                    .build());
            assertNotNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("", ex.getMessage());
        }
    }

    @Test
    void insertPerson3() {
        try {
            Person person = this.service.insertPerson3(Person.builder().build());
            assertNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("parametrso incorrectos", ex.getMessage());
        }

        try {
            //no es mayor a 5
            Person person = this.service.insertPerson3(Person.builder()
                    .name("name")
                    .address("adress")
                    .lastName("lastname")
                    .age(5)
                    .build());
            assertNotNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("parametrso incorrectos", ex.getMessage());
        }

        try {
            //no es menor a 50
            Person person = this.service.insertPerson3(Person.builder()
                    .name("name")
                    .address("adress")
                    .lastName("lastname")
                    .age(60)
                    .build());
            assertNotNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("parametrso incorrectos", ex.getMessage());
        }

        try {
            //no es menor a 50
            Person person = this.service.insertPerson3(Person.builder()
                    .name("name")
                    .address("adress")
                    .lastName("lastname")
                    .age(10)
                    .build());
            assertNotNull(person);
        } catch (IllegalArgumentException ex) {
            assertEquals("", ex.getMessage());
        }

    }
}