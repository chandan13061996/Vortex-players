package com.dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dev.beans.User;
@Repository
public class UserJpaImpl implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addUser(User user) {
		boolean state = false;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			state = true;
		}catch(Exception e) {
			e.printStackTrace();
			state = false;
		}
		finally{
			em.close();
		}
		return state;
	}

	@Override
	public List<User> searchByName(String name) {
		
		EntityManager em = emf.createEntityManager();
		String names[] = null;
		if(name.contains(" ")) {
			names = name.split(" ");
		}else {
			names = new String[1];
			names[0] = name;
//			names[1] = name;
		}
		String jpql = "SELECT p FROM User p WHERE p.username=:name";
		TypedQuery<User> query = em
				.createQuery(jpql,User.class);
		query.setParameter("name", names[0]);
//		query.setParameter("lname", names[1]);
		
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deleteUser(String name) {
		
		EntityManager em = null;
		boolean state = true;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			//String jpql = "DELETE  FROM User p WHERE p.username=:name";
			Query query = em.createQuery(
				      "DELETE  FROM User p WHERE p.username=:name");
			 int count = query.setParameter("name", name).executeUpdate();
			
			
//			TypedQuery<User> query = em
//					.createQuery(jpql,User.class);
			// query.setParameter("name", name).executeUpdate();
			 if(count>0){
				 state = true;
				 em.getTransaction().commit();
			
			 }
		}catch(Exception e){
			e.printStackTrace();
			state = false;
		}finally{
			em.close();
		}
		return state;
		
	}

	@Override
	public boolean updateUser(User user) {
		EntityManager em = null;
		boolean state = true;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery(
				      "UPDATE User u SET u.password=:pwd, u.mobileNo=:mob, u.role=:role " +
				      "WHERE u.username=:name");
			       
//			        u.setMobileNo(u.getMobileNo());
//			        u.setRole(u.getRole());
//			        u.setUsername(u.getUsername());
				  query.setParameter("pwd", user.getPassword());
				  query.setParameter( "mob",user.getMobileNo());
				  query.setParameter("role",user.getRole());
			      query.setParameter("name",user.getUsername() );
				  int count= query.executeUpdate();
				    
				 
				    if(count>0){
					  state = true;
					  //em.persist(u);
					  em.getTransaction().commit();
					 
				  }
		}catch(Exception e){
			e.printStackTrace();
			state = false;
		}finally{
			if(em != null)
				em.close();
		}
		
		return state;
	}	

}
