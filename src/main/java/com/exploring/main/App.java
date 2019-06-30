package com.exploring.main;

//javax.persistence is coming from hibernate

import com.exploring.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App {
    public static void main(String[] args) {
      /*  Persistence.createEntityManagerFactory will provide EntityManagerFactory instance using the persistence-unit that
          we have provided in the persistence.xml file */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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

        Query query = entityManager.createNativeQuery("SELECT e.employee_id, e.employee_name FROM Employee e");
        List<Object[]> employees = query.getResultList();
        for (Object[] employee1 : employees) {
            System.out.println("Employee "
                    + employee1[0]
                    + " "
                    + employee1[1]);
        }

        // close the entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}

