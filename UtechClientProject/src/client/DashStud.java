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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DashStud extends JFrame implements ActionListener{
	
//	Logger logger = LogManager.getLogger(DashStud.class);

	private JPanel contentPane;
	private JTable table;
	private int IDNumber;
	private int actionNum;
	private String serviceName;
	StudentComplaintDriver complaint;
	JTextArea textArea_2;
	JTextArea textArea_1;
	JTextArea textArea_3;
	JTextArea textArea_4;
	JTextArea textArea;
	JPanel panel_3;
	JPanel panel_4;
	JPanel panel_9;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	JTable table_1;
	private JTable table_2;
	private JTextField cid_textField;
	

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
	public DashStud(String name, int ID) {
		setIDNumber(ID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 271, 642);
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
		
//		JLabel lblStudent = new JLabel(name.toUpperCase());
//		lblStudent.setFont(new Font("Gloucester MT Extra Condensed", Font.BOLD | Font.ITALIC, 31));
//		lblStudent.setBounds(86, 86, 151, 37);
//		panel_1.add(lblStudent);
		
		JButton btnNewButton = new JButton("Make a Complaint");
		btnNewButton.setFont(new Font("HP Simplified", Font.BOLD, 16));
		btnNewButton.setBounds(0, 235, 271, 64);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("HP Simplified", Font.BOLD, 16));
		btnHome.setBounds(0, 172, 271, 64);
		panel_1.add(btnHome);
		btnHome.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		panel_2.setBounds(271, 0, 766, 82);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblStudentDashboard = new JLabel("STUDENT DASHBOARD");
		lblStudentDashboard.setBounds(213, 0, 287, 82);
		panel_2.add(lblStudentDashboard);
		lblStudentDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDashboard.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 19));
		
		panel_4 = new JPanel();
		panel_4.setBounds(300, 110, 715, 422);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type of Issue");
		lblNewLabel.setVisible(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 77, 87, 36);
		panel_4.add(lblNewLabel);
		
		JLabel lblD = new JLabel("Details of Issue");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblD.setBounds(21, 142, 105, 36);
		panel_4.add(lblD);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 174, 360, 200);
		panel_4.add(textArea);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(139, 387, 135, 25);
		panel_4.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));

		Object[] columnsName= new Object[3];
		columnsName[0] = "Complaint ID"; 
		columnsName[1]= "Type of Issue"; 
		columnsName[2]= "Details of Issue";
		model.setColumnIdentifiers(columnsName);

		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(374);
		table.setBounds(402, 29, 303, 383);
		panel_4.add(table);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(142, 77, 238, 36);
		panel_4.add(textArea_1);
		
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
		panel_9.setBounds(300, 116, 737, 526);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabelc = new JLabel("Complaint Tray");
		lblNewLabelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelc.setFont(new Font("HP Simplified", Font.BOLD, 18));
		lblNewLabelc.setBounds(307, 0, 355, 50);
		panel_3.add(lblNewLabelc);
		panel_9.add(lblNewLabelc);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(22, 102, 659, 232);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("There are no complaints to display. ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 77, 659, 24);
		panel_6.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("If you would like to make a complaint please select that option in the pane to the left.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 111, 659, 24);
		panel_6.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(234, 49, 251, 8);
		panel_3.add(separator_1);
		panel_9.add(lblNewLabelc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 60, 472, 294);
		panel_9.add(scrollPane);
		
		table_2 = new JTable() {
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
//		 table_2.setRowSelectionAllowed(true);
//	     table_2.setColumnSelectionAllowed(false);
		scrollPane.setViewportView(table_2);
		
//		table_1 = new JTable();
//		table_1.setBounds(99, 79, 700, 323);
//		
		Object[] columnsName2= new Object[4];
		columnsName2[0] = "Complaint ID"; 
		columnsName2[1]= "Type of Issue"; 
		columnsName2[2]= "Details of Issue";
		columnsName2[3]= "Response";
		model2.setColumnIdentifiers(columnsName2);
		

		
		table_2.setModel(model2);
		
		table_2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				table_2MouseClicked(evt);
			}
		});
		
		JLabel cidlblNewLabel = new JLabel("Complaint ID");
		cidlblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cidlblNewLabel.setBounds(10, 74, 83, 27);
		panel_9.add(cidlblNewLabel);
		
		cid_textField = new JTextField();
		cid_textField.setBounds(103, 71, 36, 36);
		panel_9.add(cid_textField);
		cid_textField.setColumns(10);
		
		JLabel typelblNewLabel_1 = new JLabel("Type of Issue");
		typelblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		typelblNewLabel_1.setBounds(10, 141, 83, 27);
		panel_9.add(typelblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 173, 216, 59);
		panel_9.add(scrollPane_1);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		
		JLabel deslblNewLabel = new JLabel("Description");
		deslblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		deslblNewLabel.setBounds(10, 257, 100, 27);
		panel_9.add(deslblNewLabel);
		
		JLabel reslblNewLabel = new JLabel("Last Response");
		reslblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		reslblNewLabel.setBounds(10, 370, 154, 46);
		panel_9.add(reslblNewLabel);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 409, 300, 107);
		panel_9.add(scrollPane_7);
		
		textArea_4 = new JTextArea();
		scrollPane_7.setViewportView(textArea_4);
//		textArea_4.setBounds(10, 409, 233, 107);
//		panel_9.add(textArea_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 294, 216, 59);
		panel_9.add(scrollPane_2);
		
		textArea_3 = new JTextArea();
		scrollPane_2.setViewportView(textArea_3);
//		textArea_3.setBounds(20, 294, 195, 59);
//		panel_9.add(textArea_3);
		
		homeScreen();
	}
	
		public void actionPerformed(ActionEvent e){	
			
			if(e.getActionCommand()=="Home") {
//				logger.trace("Home was selected.");
				setActionNum(1);
				homeScreen();
			}else if(e.getActionCommand()=="Make a Complaint") {
//				logger.trace("Make a Complaint was selected.");
				setActionNum(2);
				makeComplaint();
			}else if(e.getActionCommand()=="Chat") {
//				logger.trace("Chat was selected.");
				setActionNum(3);
			}else if(e.getActionCommand()=="Submit") {
//				logger.trace("Submit was selected.");
				setActionNum(4);
				saveComplaint();
			}			
	}
		
		public void saveComplaint() {
			StudentComplaint comp;
			StudentComplaint c = new StudentComplaint();
			if(!textArea_1.getText().isEmpty() && !textArea.getText().isEmpty()) {
				//write code for generating a random employee assignment
					// add total number of employees while next and generate a random value based on that range
				StudentComplaintDriver d= new StudentComplaintDriver();
				Integer compID = d.addComplaint(getIDNumber(), 18039475, textArea_1.getText(), textArea.getText(), getServiceName());			
				comp= d.readNewComplaint(compID);			
				Object[] rowData = new Object[3];
				rowData[0] = comp.getComplaintID();
				rowData[1] = comp.getTypeOfIssue();
				rowData[2] = comp.getDetailsOfIssue();
				model2.addRow(rowData);
				table_2.setModel(model2);
//				logger.trace("Complaint is saved.");
				
			}
			else {
//				logger.error("Complaint text field is empty.");
				System.out.println("Cannot be empty");
				
				//PUT GUI
			}
		}
		
		
		private void table_2MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)table_2.getModel();

	        // get the selected row index
	       int selectedRowIndex = table_2.getSelectedRow();
	       
	        // set the selected row data into jtextfields
	       cid_textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
	       textArea_2.setText(model.getValueAt(selectedRowIndex, 1).toString());
	       textArea_3.setText(model.getValueAt(selectedRowIndex, 2).toString());
	       textArea_4.setText(model.getValueAt(selectedRowIndex, 3).toString());
	        
	    }                        
		
		public void makeComplaint() {
			panel_4.setVisible(true);
			panel_9.setVisible(false);
			panel_3.setVisible(false);
		}
		
		public void homeScreen() {
			StudentComplaintDriver d= new StudentComplaintDriver();
			StudentComplaint comp;
			ArrayList <StudentComplaint> listarr;
			panel_4.setVisible(false);
			listarr= d.listMyComplaints(getIDNumber());
			if(listarr==null) {
				panel_3.setVisible(true);
				return;
			}
			else {
				panel_3.setVisible(false);
				panel_9.setVisible(true);
				listarr= d.listMyComplaints(getIDNumber());
				Object[] rowData = new Object[4];
				for (int i=0; i<listarr.size(); i++) {
					rowData[0] = listarr.get(i).getComplaintID();
					rowData[1] = listarr.get(i).getTypeOfIssue();
					rowData[2] = listarr.get(i).getDetailsOfIssue();
					rowData[3] = listarr.get(i).getResponse();
					model2.addRow(rowData);
				}
			}
			
		}
		
	
	public JTable getTable() {
		return table;
	}
}

