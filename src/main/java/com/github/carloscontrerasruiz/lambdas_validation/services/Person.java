package com.github.carloscontrerasruiz.lambdas_validation.services;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String lastName;
    private String address;
    private int age;
}
