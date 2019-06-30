package com.exploring.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceContext;

@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test

    public void shouldPrintEmployees() {
        System.out.println(employeeRepository.getAll());
    }
}