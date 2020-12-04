package client;

import javax.swing.*;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.EventQueue;


public class Login extends JFrame implements ActionListener{
	
	BufferedReader inpl;
	PrintWriter outpl;
	
//	Logger logger = LogManager.getLogger(Login.class);
	
  JButton loginButton;
  JPanel loginpanel;
  JTextField txuser;
  JPasswordField Password;
  JButton newUSer;
  JLabel username;
  JLabel password;
  String typeOfUser;

  public Login(String type, BufferedReader inp, PrintWriter outp){
	  super("Login Autentification");
	  
	  inpl= inp;
	  outpl=outp;

    loginButton = new JButton("Login");
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    Password = new JPasswordField(25);
//    newUSer = new JButton("New User?");
    if(type=="Student") {
    	typeOfUser= "Student";
//    	logger.trace("Change to Student Database.");
    	//here there should be a change in database based on selection
    	username = new JLabel("Student ID: ");
    }
    else {
//    	logger.trace("Change to Representative Database.");
    	typeOfUser= "Representative";
    	username = new JLabel("Staff ID: ");
    }
    password = new JLabel("Password:  ");

    setSize(600,500);
    setLocation(500,280);
    loginpanel.setLayout (null); 
    
    txuser.setBounds(230,170,200, 25);
    Password.setBounds(230,205,200,25);
    loginButton.setBounds(290,240,80,20);
//    newUSer.setBounds(110,300,80,20);
    username.setBounds(150,168,80,20);
    password.setBounds(150,203,80,20);

    loginpanel.add(loginButton);
    loginpanel.add(txuser);
    loginpanel.add(Password);
//    loginpanel.add(newUSer);
    loginpanel.add(username);
    loginpanel.add(password);
    loginButton.addActionListener(this);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }
  
  public void actionPerformed(ActionEvent e)

  {
      verifyLoginDetails(typeOfUser);
  }
  
  public void verifyLoginDetails(String typeOfUser) {	
					String idnum= txuser.getText();
					char[] pw= Password.getPassword();
					String psswrd= new String(pw);	
					outpl.println(idnum);
					outpl.println(psswrd);
					try {
						String userName= inpl.readLine();
						int id= Integer.parseInt(idnum);
						if(userName != null) {
							if(typeOfUser.equals("Student")) {
								this.setVisible(false);
								DashStud frame = new DashStud(userName, id);
								frame.setVisible(true);
							}
							else {
								System.out.println("staff");
							}
						}
						else {
							IncorrectDataScreen frame = new IncorrectDataScreen();
							frame.setVisible(true);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
  }

}


