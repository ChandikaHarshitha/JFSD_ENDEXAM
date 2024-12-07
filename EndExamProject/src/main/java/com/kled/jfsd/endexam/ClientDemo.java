package com.kled.jfsd.endexam;

	import org.hibernate.*;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.criterion.*;

	import java.util.List;

	public class ClientDemo {
	    public static void main(String[] args) {
	        Configuration cfg = new Configuration().configure();
	        SessionFactory factory = cfg.buildSessionFactory();
	        Session session = factory.openSession();

	        insertRecords(session);

	        applyCriteriaQueries(session);

	        session.close();
	        factory.close();
	    }

	    private static void insertRecords(Session session) {
	        Transaction transaction = session.beginTransaction();

	        Customer customer1 = new Customer();
	        customer1.setName("Harshitha");
	        customer1.setEmail("Harshitha31336@gmail.com");
	        customer1.setAge(20);
	        customer1.setLocation("Vijayawada");

	        Customer customer2 = new Customer();
	        customer2.setName("Alice");
	        customer2.setEmail("Alice22@gmail.com");
	        customer2.setAge(22);
	        customer2.setLocation("Los Angeles");

	        Customer customer3 = new Customer();
	        customer3.setName("Charlie");
	        customer3.setEmail("charlie282@gmail.com");
	        customer3.setAge(25);
	        customer3.setLocation("Chicago");

	        session.save(customer1);
	        session.save(customer2);
	        session.save(customer3);

	        transaction.commit();
	    }

	    private static void applyCriteriaQueries(Session session) {
	        Criteria criteria;

	        System.out.println("\n--- Customers with age > 30 ---");
	        criteria = session.createCriteria(Customer.class);
	        criteria.add(Restrictions.gt("age", 30));
	        List<Customer> customers = criteria.list();
	        customers.forEach(c -> System.out.println(c.getName() + " - " + c.getAge()));

	        System.out.println("\n--- Customers with location = 'Chicago' ---");
	        criteria = session.createCriteria(Customer.class);
	        criteria.add(Restrictions.eq("location", "Chicago"));
	        customers = criteria.list();
	        customers.forEach(c -> System.out.println(c.getName() + " - " + c.getLocation()));

	        System.out.println("\n--- Customers with name like 'A%' ---");
	        criteria = session.createCriteria(Customer.class);
	        criteria.add(Restrictions.like("name", "A%"));
	        customers = criteria.list();
	        customers.forEach(c -> System.out.println(c.getName()));
	    }
	}