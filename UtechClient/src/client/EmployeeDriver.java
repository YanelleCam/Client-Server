//package clientServer;
//
//public class EmployeeDriver {
//
//}

package client;

//import java.util.List; 
//import java.util.Date;
//import java.util.Iterator; 
// 
import java.util.*;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import javassist.bytecode.Descriptor.Iterator;

import java.util.List;
import java.util.Iterator;

public class EmployeeDriver {
	
//	public static final Logger logger = LogManager.getLogger(EmployeeDriver.class);
	
	private static SessionFactory factory; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
//			logger.trace("Creating session factory.");
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		ArrayList <StudentComplaint> listarr = new ArrayList<StudentComplaint>();
		StudentComplaintDriver complaintAdder = new StudentComplaintDriver();
		
		listarr= complaintAdder.listMyComplaints(17038483);
		for(int i=0; i<listarr.size(); i++) {
			System.out.println(listarr.toString());
		}
	}
	
	
	public ArrayList<StudentComplaint> listAllComplaintsbyService(String service) {
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Creating sessionFactory object in listAllComplaintsbyService.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		Session session = fact.openSession();
		Transaction trans = null;
		ArrayList <StudentComplaint> listarr = new ArrayList<StudentComplaint>();
		try {
//			logger.trace("Transaction started in listAllComplaintsbyService.");
			trans = session.beginTransaction();
			List AllComplaintsbyService = session.createQuery("FROM StudentComplaint").list();
//			logger.trace("List complaints by service");
			for (Iterator iterator = AllComplaintsbyService.iterator(); iterator.hasNext();) {
				StudentComplaint complaint = (StudentComplaint) iterator.next();
				if(complaint.getService().equals(service)) {
//					logger.info("LIS ARR "+listarr);
					System.out.println("LIS ARR "+listarr);
					listarr.add(complaint);
				}
			}
			trans.commit();
//			logger.trace("Transaction committed.");
			return listarr;
//			StudentComplaint student = (StudentComplaint)session.get(StudentComplaint.class, stid);
			
		}catch(HibernateException e) {
//			logger.error("Hibernate error in listAllComplaintsbyService.");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in listAllComplaintsbyService. Session closed.");
			session.close();
		}
//		return listarr;
		return null;
	}
	
	public ArrayList<StudentComplaint> listAllComplaints(String status) {
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Creating new sessionFactory object in listAllComplaints.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		Session session = fact.openSession();
		Transaction trans = null;
		ArrayList <StudentComplaint> listarr = new ArrayList<StudentComplaint>();
		try {
			trans = session.beginTransaction();
//			logger.trace("Starting transaction by listAllComplaints");
			List AllComplaints = session.createQuery("FROM StudentComplaint").list();
			for (Iterator iterator = AllComplaints.iterator(); iterator.hasNext();) {
				StudentComplaint complaint = (StudentComplaint) iterator.next();
				if(complaint.getService()==status) { //FIX THIS GETSTATUS (RESOLVED/ UNRESOLVED)
					listarr.add(complaint);
				}
			}
			trans.commit();
//			logger.trace("Transaction committed.");
			return listarr;
//			StudentComplaint student = (StudentComplaint)session.get(StudentComplaint.class, stid);
			
		}catch(HibernateException e) {
//			logger.error("Hibernate error listAllComplaints");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in listAllComplaints. Session closed.");
			session.close();
		}
//		return listarr;
		return null;
	}
	
	
public ArrayList<StudentComplaint> test() {
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Building Session Factory.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		Session session = fact.openSession();
		Transaction trans = null;
		ArrayList <StudentComplaint> listarr = new ArrayList<StudentComplaint>();
		try {
			trans = session.beginTransaction();
//			logger.trace("Strating transaction.");
			List AllComplaints = session.createQuery("FROM StudentComplaint").list();
			for (Iterator iterator = AllComplaints.iterator(); iterator.hasNext();) {
				StudentComplaint complaint = (StudentComplaint) iterator.next();
					listarr.add(complaint);
			}
			trans.commit();
//			logger.trace("Transaction committed.");
			return listarr;
//			StudentComplaint student = (StudentComplaint)session.get(StudentComplaint.class, stid);
			
		}catch(HibernateException e) {
//			logger.error("Hibernate error.");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction. Session closed.");
			session.close();
		}
//		return listarr;
		return null;
	}
	
	
	public void update(Integer complaintID, String response) {
		final SessionFactory fact; 
		
		try {
//			logger.trace("Building Session Factory in update.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		Session session = fact.openSession();
		Transaction trans = null;
	     
	    try {
//	    	logger.trace("Starting session.");
	    	 trans = session.beginTransaction();
	    	 StudentComplaint complaint = (StudentComplaint)session.get(StudentComplaint.class, complaintID);
	    	 //insert GUI stuff
	    	 complaint.setResponse(response);
	    	 session.update(complaint);
	    	 trans.commit(); 
//	    	 logger.trace("Transaction committed");
	    }catch(HibernateException e) {
//	    	logger.error("Hibernate Error in update function");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in update function. Session closed.");
			session.close();
		}
	}
	
	public void delete(Integer complaintID) {
		Session session = factory.openSession();
	     Transaction trans = null;
	     
	     try {
//	    	 logger.trace("Starting session.");
	    	 trans = session.beginTransaction();
	    	 StudentComplaint complaint = (StudentComplaint)session.get(StudentComplaint.class, complaintID);
	    	 session.delete(complaint);
	    	 trans.commit(); 	
//	    	 logger.trace("Transaction committed");
	    }catch(HibernateException e) {
//	    	logger.error("Hibernate Error in delete function");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in update function. Session closed.");
			session.close();
		}	     
	}

}

