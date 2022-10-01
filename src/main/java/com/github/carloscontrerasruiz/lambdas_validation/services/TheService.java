package com.github.carloscontrerasruiz.lambdas_validation.services;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TheService {

    public Person insertPerson1(Person person) {
        if (person == null || person.getName() == null || person.getName().isBlank() ||
                person.getLastName() == null || person.getLastName().isBlank() ||
                person.getAddress() == null || person.getAddress().isBlank() || person.getAge() == 0) {
            throw new IllegalArgumentException("parametrso incorrectos");
        }

        return person;
    }

    public Person insertPerson2(Person person) {
        if (!isValidPerson(person)) {
            throw new IllegalArgumentException("parametrso incorrectos");
        }

        return person;
    }

    private boolean isValidPerson(Person person) {
        if (person == null || person.getName() == null || person.getName().isBlank() ||
                person.getLastName() == null || person.getLastName().isBlank() ||
                person.getAddress() == null || person.getAddress().isBlank() || person.getAge() == 0) {
            return false;
        }
        return true;
    }

    public Person insertPerson3(Person person) {
        Predicate<Person> firstValidation = (e) -> e.getAge() < 50;

        List<Predicate<Person>> predicates = Arrays.asList(
                firstValidation,
                (e) -> e.getAge() > 5
        );

        if (!isValidPerson(person, predicates)) {
            throw new IllegalArgumentException("parametrso incorrectos");
        }

        return person;
    }

    private boolean isValidPerson(Person person, List<Predicate<Person>> extraValidations) {
        if (!isValidPerson(person)) {
            return false;
        }

        for (Predicate<Person> validation : extraValidations) {
            if (!validation.test(person)) return false;
        }

//        List<Predicate<Person>> collect = extraValidations.stream().filter(validation -> !validation.test(person))
//                .collect(Collectors.toList());
//        if (!collect.isEmpty()) return false;

        return true;
    }
}
