package server;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.Date;

public final class ConnectionHandler extends Thread {

    private Socket socket;


    public ConnectionHandler(Socket socket){
          setName("ConnectionHandler");
          this.socket = socket;
    }


    public void run(){
          BufferedReader in = null;
          PrintWriter out = null;

          String request;

          try{
                // Get the input and output streams
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while( (request = in.readLine()) != null){

                      // Deliver the current date and time if the client sends GET_TIME
                      if(request.equals("GET_TIME"))
                            out.println(new Date().toString());

                      
                      else if(request.equals("LOGIN")) {
//                    	  out.println(in.readLine());
//                    	  if(in.readLine().equals("Student")) {
//                    		  System.out.println("Hello STudent");
                    	  String typeOfUser= in.readLine();
                    		  login(typeOfUser, in, out);
//                    	  }
                    	  //new login
                      }

                      // Exit the loop if the client sends CLOSE
                      else if(request.equals("CLOSE"))
                            break;

                }
          }
          catch(IOException e){
                e.printStackTrace();
          }
          finally{
                try{
                      if(socket != null)
                            socket.close(); // Close the socket (closing the socket also closes the input and output streams)
                }
                catch(IOException e){
                      e.printStackTrace();
                }
          }
    }
    
    
    public void login(String typeOfUser, BufferedReader in, PrintWriter out) {
    	Connection dconn=null;
    	try {
    		System.out.println("eNTER: " + dconn);
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("Connection here: " + dconn);
    		dconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","");
    		PreparedStatement ps=null;
    		System.out.println("Connection here after: " + dconn);
    		
    		if(dconn!=null) {
    			System.out.println("Connection Successful!");
				if(typeOfUser.equals("Student")) {
					ps = dconn.prepareStatement("select STUDENTIDENTIFICATION, STUDENT_FIRST_NAME, STUDENT_LAST_NAME from STUDENT where STUDENTIDENTIFICATION=? AND PASSWORD=?");
				}
				else {
					ps = dconn.prepareStatement("select STAFFIDENTIFICATION, STAFF_FIRST_NAME, STAFF_LAST_NAME from STAFF where STAFFIDENTIFICATION=? AND PASSWORD=?");
				}
			
				String idnum=in.readLine();
	    		String passwrd= in.readLine();
				ps.setString(1, idnum);
				ps.setString(2, passwrd);
				ResultSet log= ps.executeQuery();
				String studentName= "";
				
				while (log.next()) {
					System.out.println("login success");
		    		System.out.println("ID:"+ idnum);
					System.out.println("PASSWORD:"+ passwrd);
					System.out.println("STUDENT NAME: " + log.getString(2)); // pass to client
					studentName= log.getString(2);
					
					
				}	
				if(!studentName.equals("")) {
					out.println(studentName); //print to student dash or staff dash
					out.flush();
				}
				else {
					out.println("not found");
					out.flush();
				}
				
    		}
			dconn.close();		
			
			
    	}catch(SQLException sq) {
			//add to log file
			System.out.println("Connection Failure " + sq.getMessage());
		}
		catch(Exception e) {
			//add to log file
			System.out.println("An unexpected Exception occurred " + e.getMessage());
			e.printStackTrace();
		}
    }
}