package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Bankaccounts;

public class BankDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");  //pre requisite conditions
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();            
	
	public void save(Bankaccounts bankaccounts) {
		entityTransaction.begin();           // it will make the data ready
		entityManager.persist(bankaccounts); // it helps to transfer or traverse the data towards the table 
		entityTransaction.commit();          // it helps to commit the data or insert the data inside the database
	}

	public Bankaccounts find(long acon) {
		// TODO Auto-generated method stub
		return entityManager.find(Bankaccounts.class, acon);
	}

	public void update(Bankaccounts bankaccounts) {
		// TODO Auto-generated method stub
		entityTransaction.begin();           // it will make the data ready
		entityManager.merge(bankaccounts); // it helps to transfer or traverse the data towards the table 
		entityTransaction.commit();
	}

	public List<Bankaccounts> fetchall() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select x from Bankaccounts x").getResultList();
	}
}
