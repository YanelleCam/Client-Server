package server;

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

public class StudentComplaintDriver {
	
//	public static final Logger logger = LogManager.getLogger(StudentComplaintDriver.class);
	
	private static SessionFactory factory; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
//			logger.trace("Building Session Factory.");
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	    	  ex.printStackTrace();
//	    	  logger.error("Failed to create sessionFactory object." + ex);
//	         System.err.println("Failed to create sessionFactory object." + ex);
//	         throw new ExceptionInInitializerError(ex); 
	      }
		ArrayList <StudentComplaint> listarr = new ArrayList<StudentComplaint>();
		StudentComplaintDriver complaintAdder = new StudentComplaintDriver();
		
		listarr= complaintAdder.listMyComplaints(17038483);
//		logger.trace("Complaints List");
		for(int i=0; i<listarr.size(); i++) {
			System.out.println(listarr.toString());
		}
//		complaintAdder.update(1, 17038483);
//		Integer compID = complaintAdder.addComplaint(17038483, 18039475, "Test", "Test Details");
		
	}
	
	public Integer addComplaint(int stid, int reid, String complaint_Type, String complaint_description, String service) {
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Building Session Factory in addComplaint.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         //System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		Session session = fact.openSession();
	      Transaction trans = null;
	      Integer complaintID = null;
	      Integer complaintIDtrack = null;
		
	      try {
//	    	  logger.trace("Starting transaction in addComplaint function.");
	    	  trans = session.beginTransaction();
	    				List myComplaints = session.createQuery("FROM StudentComplaint").list();
	    				for (Iterator iterator = myComplaints.iterator(); iterator.hasNext();) {
	    					StudentComplaint complaint = (StudentComplaint) iterator.next();
	    					complaintIDtrack=complaint.getComplaintID();
	    				}
//	    				 logger.trace("SERVICE" + service);
	    				System.out.println("SERVICE" + service);
	    	  StudentComplaint sudentComp = new StudentComplaint(stid, reid, complaint_Type, complaint_description, service);
	    	  complaintID = (Integer) session.save(sudentComp);
	    	  trans.commit();
//	    	  logger.trace("Transaction Committed.");
//	    	  System.out.println("FROM ADD FUNCTION COMPID" + complaintID);
	    	  return complaintIDtrack+1;
  	  
	      }
	      catch(HibernateException e) {
//	    	  logger.error("Hibernate erro in addComplaint");
	    	  if (trans != null) {
	    		  trans.rollback();
	    	  }
	    	  e.printStackTrace();
	      } finally {
//	    	  logger.error("Error in transaction in addComplaint. Session closed.");
	    	  session.close();
	      }
	      
	      return null;
	}
	
	public ArrayList<StudentComplaint> listMyComplaints(int stid) {
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Building Session Factory in listMyComplaints.");
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
//			logger.trace("Starting transaction in listMyComplaint function.");
			trans = session.beginTransaction();
			List myComplaints = session.createQuery("FROM StudentComplaint").list();
			for (Iterator iterator = myComplaints.iterator(); iterator.hasNext();) {
				StudentComplaint complaint = (StudentComplaint) iterator.next();
				if(complaint.getStudentID()==stid) {
					listarr.add(complaint);
				}
			}
			trans.commit();
//			logger.trace("Transaction Committed.");
			return listarr;
//			StudentComplaint student = (StudentComplaint)session.get(StudentComplaint.class, stid);
			
		}catch(HibernateException e) {
//			logger.error("Hibernate error in listMyComplaint");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in listMyComplaint. Session closed.");
			session.close();
		}
//		return listarr;
		return null;
	}
	
	
	public StudentComplaint readNewComplaint(Integer complaintID) {
		
		
		final SessionFactory fact; 
		
		try {
//			logger.trace("Building Session Factory in readNewComplaints.");
	         fact = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
//	    	  logger.error("Failed to create sessionFactory object." + ex);
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		Session session = fact.openSession();
		Transaction trans = null;
		try {
//			logger.trace("Starting transaction in readNewComplaint function.");
			trans = session.beginTransaction();
			List myComplaints = session.createQuery("FROM StudentComplaint").list();
			for (Iterator iterator = myComplaints.iterator(); iterator.hasNext();) {
				StudentComplaint complaint = (StudentComplaint) iterator.next();
				if(complaint.getComplaintID()==complaintID) {	
					return complaint;
					//want it to go in the table
				}
			}
			trans.commit();
//			logger.trace("Transaction Committed.");
			
		}catch(HibernateException e) {
//			logger.error("Hibernate error in readNewComplaint");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in readNewComplaint. Session closed.");
			session.close();
		}
		return null;
	}
	
	
	public void update(Integer complaintID, int stid) {
		Session session = factory.openSession();
	     Transaction trans = null;
	     
	    try {
//	    	logger.trace("Starting transaction in update function.");
	    	 trans = session.beginTransaction();
	    	 StudentComplaint complaint = (StudentComplaint)session.get(StudentComplaint.class, complaintID);
	    	 //insert GUI stuff
	    	 complaint.setTypeOfIssue("Assignment");
	    	 session.update(complaint);
//	    	 logger.trace("Complaint update");
	    	 trans.commit(); 
//	    	 logger.trace("Transaction Committed.");
	    }catch(HibernateException e) {
//	    	logger.error("Hibernate error in update function");
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
//	    	 logger.trace("Starting transaction in update function.");
	    	 trans = session.beginTransaction();
	    	 StudentComplaint complaint = (StudentComplaint)session.get(StudentComplaint.class, complaintID);
	    	 session.delete(complaint);
	    	 trans.commit(); 	 
//	    	 logger.trace("Transaction Committed.");
	    }catch(HibernateException e) {
//	    	logger.error("Hibernate error in delete function");
			if(trans!=null) trans.rollback();
			e.printStackTrace();
		} finally {
//			logger.error("Error in transaction in delete function. Session closed.");
			session.close();
		}	     
	}

}
