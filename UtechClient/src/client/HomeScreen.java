package client;

import java.awt.BorderLayout;
import java.io.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.image.*;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class HomeScreen extends JFrame implements ActionListener{
	
//	Logger logger = LogManager.getLogger(HomeScreen.class);

	private JPanel contentPane;
	BufferedReader inp;
	PrintWriter outp;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeScreen frame = new HomeScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HomeScreen(BufferedReader in,  PrintWriter out) {
		inp=in;
		outp=out;
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 297, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/LOGIN.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 5, 240, 430);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gloucester MT Extra Condensed", Font.BOLD | Font.ITALIC, 31));
		lblNewLabel_1.setBounds(334, 44, 328, 181);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Are you a Student or a Representative?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(334, 268, 328, 79);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 20));
		btnNewButton.setBounds(362, 369, 143, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("Representative");
		btnNewButton_1.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 20));
		btnNewButton_1.setBounds(515, 369, 133, 47);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("Sign in to see your dashboard. But first.. ");
		lblNewLabel_3.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(377, 170, 253, 55);
		contentPane.add(lblNewLabel_3);
	}
	
			public void actionPerformed(ActionEvent e){ 
				this.setVisible(false);
				outp.println(e.getActionCommand().toString());
				new Login(e.getActionCommand().toString(), inp, outp);
		}  
}
