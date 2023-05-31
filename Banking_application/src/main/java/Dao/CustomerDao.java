package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Bankaccounts;
import Dto.Customer;
import java.util.List;


public class CustomerDao {                 //5th
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public List<Customer> check(long mobile)
	{
		return entityManager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile).getResultList();
	}
	
	public List<Customer> check(String email)
	{
		return entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}

	public Customer login(int custid) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, custid);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}

	public List<Bankaccounts> fetchall() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select x from Bankaccounts x").getResultList();
	}
}