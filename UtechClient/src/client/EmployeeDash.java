//package clientServer;
//
//public class EmployeeDash {
//
//}

package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class EmployeeDash extends JFrame implements ActionListener{
	
//	Logger logger = LogManager.getLogger(EmployeeDash.class);

	private JPanel contentPane;
	private JTable table;
	private int IDNumber;
	private int actionNum;
	private String serviceName;
	StudentComplaintDriver complaint;
	JTextArea textArea_1;
	JTextArea textArea;
	JTextArea textArea_2;
	private JTextField textField;
	JPanel panel_3;
	JPanel panel_4;
	JPanel panel_9;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	JTable table_1;
	JTable table_2;
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getActionNum() {
		return actionNum;
	}

	public void setActionNum(int actionNum) {
		this.actionNum = actionNum;
	}

	/**
	 * Launch the application.
	 */


	public int getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(int iDNumber) {
		IDNumber = iDNumber;
	}

	/**
	 * Create the frame.
	 */
	public EmployeeDash(String name, int ID) {
		setIDNumber(ID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 271, 542);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.menu);
		panel_5.setLayout(null);
		panel_5.setBounds(0, 298, 271, 64);
		panel_1.add(panel_5);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setHorizontalAlignment(SwingConstants.CENTER);
		lblChat.setFont(new Font("HP Simplified", Font.BOLD, 16));
		lblChat.setBounds(48, 0, 173, 64);
		panel_5.add(lblChat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 127, 251, 8);
		panel_1.add(separator);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Gloucester MT Extra Condensed", Font.BOLD | Font.ITALIC, 31));
		lblWelcome.setBounds(30, 49, 143, 37);
		panel_1.add(lblWelcome);
		
		JLabel lblStudent = new JLabel(name.toUpperCase());
		lblStudent.setFont(new Font("Gloucester MT Extra Condensed", Font.BOLD | Font.ITALIC, 31));
		lblStudent.setBounds(86, 86, 151, 37);
		panel_1.add(lblStudent);
		
		JButton btnNewButton = new JButton("View queries by service");
		btnNewButton.setFont(new Font("HP Simplified", Font.BOLD, 16));
		btnNewButton.setBounds(0, 235, 271, 64);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnHome = new JButton("View all Queries");
		btnHome.setFont(new Font("HP Simplified", Font.BOLD, 16));
		btnHome.setBounds(0, 172, 271, 64);
		panel_1.add(btnHome);
		btnHome.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		panel_2.setBounds(271, 0, 766, 82);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEmployeeDashboard = new JLabel("EMPLOYEE DASHBOARD");
		lblEmployeeDashboard.setBounds(213, 0, 287, 82);
		panel_2.add(lblEmployeeDashboard);
		lblEmployeeDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDashboard.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 19));
		
		panel_4 = new JPanel();
		panel_4.setBounds(300, 110, 715, 422);
		panel.add(panel_4);
		panel_4.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Type of Issue");
//		lblNewLabel.setVisible(true);
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel.setBounds(21, 77, 87, 36);
//		panel_4.add(lblNewLabel);
//		
//		JLabel lblD = new JLabel("Details of Issue");
//		lblD.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblD.setBounds(21, 142, 105, 36);
//		panel_4.add(lblD);
//		
//		textArea = new JTextArea();
//		textArea.setBounds(20, 174, 360, 200);
//		panel_4.add(textArea);
//		
//		JButton btnNewButton_2 = new JButton("Submit");
//		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		btnNewButton_2.setBounds(139, 387, 135, 25);
//		panel_4.add(btnNewButton_2);
//		btnNewButton_2.addActionListener(this);
//		
//		table = new JTable();
//		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
//
//		Object[] columnsName= new Object[3];
//		columnsName[0] = "Complaint ID"; 
//		columnsName[1]= "Type of Issue"; 
//		columnsName[2]= "Details of Issue";
//		model.setColumnIdentifiers(columnsName);
//
//		table.setModel(model);
//		table.getColumnModel().getColumn(1).setPreferredWidth(170);
//		table.getColumnModel().getColumn(2).setPreferredWidth(374);
//		table.setBounds(402, 29, 303, 383);
//		panel_4.add(table);
//		
//		textArea_1 = new JTextArea();
//		textArea_1.setBounds(142, 77, 238, 36);
//		panel_4.add(textArea_1);
//		
		JLabel lblNewLabel_3 = new JLabel("Services");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 0, 105, 25);
		panel_4.add(lblNewLabel_3);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Set Id Appt");
		rdbtnNewRadioButton.setBounds(10, 29, 77, 21);
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Request Transcript");
		rdbtnNewRadioButton_1.setBounds(89, 27, 111, 21);
		panel_4.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(202, 27, 103, 21);
		panel_4.add(rdbtnOther);
		
		ActionListener sliceActionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
		        setServiceName(aButton.getText());
		        System.out.println("SELECTED SERVICE" + aButton.getText());
		        listByService(getServiceName());
		      }
		};
		
		group.add(rdbtnOther);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		rdbtnOther.addActionListener(sliceActionListener);
		rdbtnNewRadioButton_1.addActionListener(sliceActionListener);
		rdbtnNewRadioButton.addActionListener(sliceActionListener);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(300, 116, 711, 416);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.control);
		panel_9.setBounds(300, 116, 711, 416);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabelc = new JLabel("Service Tray");
		lblNewLabelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelc.setFont(new Font("HP Simplified", Font.BOLD, 18));
		lblNewLabelc.setBounds(178, 0, 355, 69);
		panel_3.add(lblNewLabelc);
		panel_9.add(lblNewLabelc);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(22, 102, 659, 232);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("There are no complaints in your tray. ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 77, 659, 24);
		panel_6.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(234, 49, 251, 8);
		panel_3.add(separator_1);
		panel_9.add(lblNewLabelc);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(20, 68, 669, 180);
		panel_4.add(scrollPane1);
	
		
		

//		JLabel cidlbl = new JLabel("Complaint ID");
//		cidlbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		cidlbl.setBounds(10, 74, 83, 27);
		
//		panel_9.add(cidlbl);
		
		table_1 = new JTable() {
			private static final long serialVersionUID = 1L;
			
	        public boolean isCellEditable(int row, int column) {   
//	        	logger.info("Table Created.");
	                return false;               
	        };
		};
		scrollPane1.setViewportView(table_1);
//		table_1.setBounds(20, 68, 669, 323);
		
		Object[] columnsName2= new Object[3];
		columnsName2[0] = "Complaint ID"; 
		columnsName2[1]= "Type of Issue"; 
		columnsName2[2]= "Details of Issue";
		model.setColumnIdentifiers(columnsName2);

		table_1.setModel(model);
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				table_1MouseClicked(evt);
			}
		});
//		table_1.getColumnModel().getColumn(1).setPreferredWidth(170);
//		table_1.getColumnModel().getColumn(2).setPreferredWidth(374);
//		table_1.setBounds(99, 79, 555, 323);
		
		
		scrollPane1.setViewportView(table_1);
		
//		panel_4.add(table_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 68, 669, 323);
		panel_9.add(scrollPane);
		
		table_2 = new JTable() {
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) { 
//	        	logger.info("Table Created.");
	                return false;               
	        };
		};
		scrollPane.setViewportView(table_2);
//		table_2.setBounds(20, 68, 669, 323);
		
		Object[] columnsName3= new Object[6];
		columnsName3[0] = "Student ID"; 
		columnsName3[1] = "Name"; 
		columnsName3[2] = "Email"; 
		columnsName3[3] = "Contact"; 
		columnsName3[4]= "Type of Issue"; 
		columnsName3[5]= "Details of Issue";
		model2.setColumnIdentifiers(columnsName3);
		table_2.setModel(model2);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(20, 200, 669, 50);
		panel_4.add(scrollPane2);
		
		JLabel cid = new JLabel("Complaint ID:");
		cid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cid.setBounds(38, 275, 77, 30);
		panel_4.add(cid);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResponse.setBounds(172, 278, 69, 25);
		panel_4.add(lblResponse);
		
		textField = new JTextField();
		textField.setBounds(118, 277, 44, 30);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(233, 263, 328, 75);
		panel_4.add(scrollPane_1);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		
		JButton btnAddResponse = new JButton("Add Response");
		btnAddResponse.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAddResponse.setBounds(571, 294, 90, 21);
		panel_4.add(btnAddResponse);
		btnAddResponse.addActionListener(this);
		
		
//		table_2.getColumnModel().getColumn(1).setPreferredWidth(80);
//		table_2.getColumnModel().getColumn(2).setPreferredWidth(150);
//		table_2.getColumnModel().getColumn(3).setPreferredWidth(200);
//		table_2.getColumnModel().getColumn(4).setPreferredWidth(170);
//		table_2.getColumnModel().getColumn(5).setPreferredWidth(374);
//		table_2.setBounds(99, 79, 555, 323);
		
//		panel_9.add(table_2);
//		table_2.setVisible(false);
		try {
			homeScreen();
		}catch(SQLException sq) {
//			logger.error("Connection Failure " + sq.getMessage());
			//System.out.println("Connection Failure " + sq.getMessage());
		}
		catch(Exception e) {
//			logger.error("An unexpected Exception occurred " + e.getMessage());
			//System.out.println("An unexpected Exception occurred " + e.getMessage());
		}
		
	}
	
		public void actionPerformed(ActionEvent e){	
			
			if(e.getActionCommand()=="View all Queries") {
				setActionNum(1);
				try {
					homeScreen();
				}catch(SQLException sq) {
//					logger.error("Connection Failure " + sq.getMessage());
					//System.out.println("Connection Failure " + sq.getMessage());
				}
				catch(Exception ex) {
//					logger.error("An unexpected Exception occurred " + ex.getMessage());
					//System.out.println("An unexpected Exception occurred " + ex.getMessage());
				}
			}else if(e.getActionCommand()=="View queries by service") {
//				logger.trace("View Queries.");
				setActionNum(2);
				listByService("Other");
			}else if(e.getActionCommand()=="Chat") {
//				logger.trace("Chat");
				setActionNum(3);
			}
			else if(e.getActionCommand()=="Add Response") {
//				logger.trace("Add response.");
				setActionNum(4);
				addResponse();
			}			
	}
		
		
//		public void makeComplaint() {
//			
//		}
		
		public void listByService(String service) {
			model.setRowCount(0);
//			panel_3.setVisible(true);
			panel_9.setVisible(false);
//			StudentComplaint comp;
			EmployeeDriver e= new EmployeeDriver();
			ArrayList <StudentComplaint> listarr;
			listarr= e.listAllComplaintsbyService(service);
			if(listarr==null) {
				panel_3.setVisible(true);
			}
			else {
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_9.setVisible(false);
				Object[] rowData = new Object[3];
				listarr= e.listAllComplaintsbyService(service);
				for (int i=0; i<listarr.size(); i++) {
					rowData[0] = listarr.get(i).getComplaintID();
					rowData[1] = listarr.get(i).getTypeOfIssue();
					rowData[2] = listarr.get(i).getDetailsOfIssue();
					model.addRow(rowData);
				}
			}
			
		}
		
		public void homeScreen() throws SQLException, ClassNotFoundException{

//			Connection dconn =null;
			Connection dconn=null;
			PreparedStatement ps = null;
			PreparedStatement pe = null;
			PreparedStatement pc = null;
			String UserName = null;
			String email = null;
			String contactdet = null;
		
					Class.forName("com.mysql.jdbc.Driver");
//					logger.trace("Connecting to Database: ");
					//System.out.println("Connecting to Database: ");
					//System.out.println("Connection here: " + dconn);
					dconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","");
//					logger.trace("Connection here after: " + dconn);
					//System.out.println("Connection here after: " + dconn);
					
					if(dconn!=null) {
//						logger.trace("Connection Successful!");
						//System.out.println("Connection Successful!");

							ps = dconn.prepareStatement("select STUDENT_FIRST_NAME, STUDENT_LAST_NAME from STUDENT where STUDENTIDENTIFICATION=?");
							pe=dconn.prepareStatement("select EMAIL_INFO from STUDENTEMAIL where STUD_ID=?");
							pc=dconn.prepareStatement("select CONTACT_INFO from STUDENTCONTACT where STUD_ID=?");
							
					}
			
			table_2.setVisible(true);
			EmployeeDriver e= new EmployeeDriver();
//			StudentComplaint comp;
			ArrayList <StudentComplaint> listarr;
			panel_4.setVisible(false);
			listarr= e.test(); //REMOVE THIS
			if(listarr==null) {
				panel_3.setVisible(true);
			}
			else {
				panel_3.setVisible(false);
				panel_9.setVisible(true);
//				listarr= d.listMyComplaints(getIDNumber());
				Object[] rowData = new Object[6];
				for (int i=0; i<listarr.size(); i++) {
					rowData[0] = listarr.get(i).getStudentID();
//					rowData[0] = listarr.get(i).;
					
					
					ps.setInt(1, listarr.get(i).getStudentID());
					pe.setInt(1, listarr.get(i).getStudentID());
					pc.setInt(1, listarr.get(i).getStudentID());
					ResultSet name = ps.executeQuery();
					ResultSet emailadd = pe.executeQuery();
					ResultSet contact = pc.executeQuery();
					
					if (name.next()){
						UserName= name.getString(1) + " " + name.getString(2);	
//						System.out.println("Name: " + name.getString(1) + " " + name.getString(2));
						System.out.println("Name new: " + UserName);
					}
					if (emailadd.next()){
						email = emailadd.getString(1);
					}
					if (contact.next()){
						contactdet = contact.getString(1);
					}
					
					rowData[1] = UserName;
					rowData[2] = email;
					rowData[3] = contactdet;
					rowData[4] = listarr.get(i).getTypeOfIssue();
					rowData[5] = listarr.get(i).getDetailsOfIssue();
					model2.addRow(rowData);
					
				}
			}
//			logger.trace("Connection closed.");
			dconn.close();
		}
		
		
		private void table_1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)table_1.getModel();

	        // get the selected row index
	       int selectedRowIndex = table_1.getSelectedRow();
	       
	        // set the selected row data into jtextfields
	       textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
//	       textArea_2.setText(model.getValueAt(selectedRowIndex, 1).toString());       
	    }  
		
		public void addResponse() {
			EmployeeDriver e= new EmployeeDriver();
			
			LocalDateTime responsetime = LocalDateTime.now();
			String time= responsetime.toString();
//			textArea_2.setText(responsetime.toString());
			String r = textArea_2.getText();
//			textArea_2.setText("Response time: " + time + "Response: " + r);
//			logger.trace("Response added.");
			e.update(Integer.valueOf(textField.getText()), "Response time: " + time + "\nResponse: " + r);
		}
		
	
	public JTable getTable() {
		return table;
	}
}