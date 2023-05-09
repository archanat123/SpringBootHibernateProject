package com.example.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pojo.User;
import com.example.repository.UserDao;

@Service
public class UserService implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(User user)
	{
		Session session = sessionFactory.openSession();
		try {
			session.save(user);
		}catch(Exception e)
		{
			
		}
		finally
		{
			session.close();
		}
		
		
	}
	@Override
	public void update(User user)
	{
		Session session = sessionFactory.openSession();
		Query query=null;
		String sql="";
		try {
			sql="UPDATE User set name=:name ,email=:email where id=:id";
			query=session.createQuery(sql);
	
			query.setParameter("name",user.getName());
			query.setParameter("email",user.getEmail());
			query.setParameter("id",user.getId());
			
			query.executeUpdate();
		}catch(Exception e) {
			
		}
		finally
		{
			session.close();
		}
		
		
	}
	
	@Override
	public void delete(Integer id) 
	{
		Session session = sessionFactory.openSession();
		Query query=null;
		String sql="";
		try {
			sql="DELETE User where id=:id";
			query=session.createQuery(sql);
			query.setParameter("id",id);
			
			query.executeUpdate();
		}catch(Exception e) {
			
		}
		finally
		{
			session.close();
		}
	}
	
	@Override
	public List<User> get()
	{
		Session session = sessionFactory.openSession();
		
		try {
			
			
			return (List<User>) session.createQuery("from user").list();
			
			
		}catch(Exception e) {
			
		}
		finally
		{
			session.close();
		}	
		
	
		return null;
	}
	
	
	
	
	
}
