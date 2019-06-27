
package com.exploring.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.exploring.model.Employee;

public class App {
    public static void main(String[] args) {
      /*  Persistence.createEntityManagerFactory will provide EntityManagerFactory instance using the persistence-unit that
          we have provided in the persistence.xml file */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Starting Transaction");
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setName("Pankaj");
        System.out.println("Saving Employee to Database");

        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println("Generated Employee ID = " + employee.getEmployeeId());

        // get an object using primary key.
        Employee emp = entityManager.find(Employee.class, employee.getEmployeeId());
        System.out.println("got object " + emp.getName() + " " + emp.getEmployeeId());

        // close the entity manager
        entityManager.close();
        entityManagerFactory.close();

    }
}

