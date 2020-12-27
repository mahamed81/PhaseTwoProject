package com.hibername;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Registration;
import com.utility.HibernateUtility;

public class AddUsers {

	private Session session = null;

	public Session getSession() {
		return this.session = HibernateUtility.getSession();
	}

	// puts the user info in the database	
	public int Register(Registration r) {
		Transaction tx = getSession().beginTransaction();
		int status = 0;
		try {
			r.getName();
			r.getUsername();
			r.getEmail();
			r.getPassword();
			session.save(r);
			tx.commit();
			status++;
			System.out.println("Success");

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	// checks is the username and password is in the databse 
	public boolean verifyUser(String username, String passwored) {
		Query query = getSession().createQuery("from Registration");
		boolean found = false;

		List<Registration> list = query.list();

		for (Registration emp : list) {

			if (emp.getUsername().equals(username) && emp.getPassword().equals(passwored)) {
				found = true;
			} else {
				found = false;
			}
		}

		return found;
	}

}
