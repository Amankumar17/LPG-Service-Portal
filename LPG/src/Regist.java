import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUserid;
	private JTextField textFieldEmail;
	private JTextField textFieldMobile;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Regist() {
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select User");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(53, 100, 115, 33);
		contentPane.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.addItem("Please Select User");
		comboBox.addItem("Customer");
		comboBox.addItem("Agent");
		comboBox.addItem("Administrative Staff");
		comboBox.setSelectedItem("Please Select User");
		comboBox.setBounds(226, 101, 225, 33);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(53, 159, 115, 31);
		contentPane.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldName.setBounds(226, 160, 473, 31);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New UserId");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(53, 333, 131, 31);
		contentPane.add(lblNewLabel_2);
		
		textFieldUserid = new JTextField();
		textFieldUserid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldUserid.setBounds(226, 334, 313, 31);
		contentPane.add(textFieldUserid);
		textFieldUserid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(53, 391, 156, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(53, 448, 163, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email-Id");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(53, 218, 118, 31);
		contentPane.add(lblNewLabel_5);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldEmail.setBounds(226, 219, 156, 31);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Number");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(53, 274, 140, 31);
		contentPane.add(lblNewLabel_6);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldMobile.setBounds(226, 275, 313, 31);
		contentPane.add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_1.addItem("gmail.com");
		comboBox_1.addItem("yahoo.com");
		comboBox_1.setSelectedItem(null);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(435, 221, 100, 31);
		contentPane.add(comboBox_1);
		
		JButton okbtn = new JButton("OK");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int flag=0;
					if(passwordField.getText().toString().equals(passwordFieldConfirm.getText().toString())==false)
					{
						JOptionPane.showMessageDialog(null,"Password did'nt match.");
						flag=1;
					}
					else if(textFieldName.getText().isEmpty() || textFieldUserid.getText().isEmpty() || passwordField.getText().toString().isEmpty() || textFieldMobile.getText().isEmpty() || textFieldEmail.getText().isEmpty() || comboBox_1.getSelectedItem().toString().isEmpty() || comboBox.getSelectedItem().toString().equalsIgnoreCase("please select user"))
					{
						JOptionPane.showMessageDialog(null,"Please Enter all the details.");
						flag=1;
					}
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String chk="Select user_id from users where user_id='"+textFieldUserid.getText()+"';";
					ResultSet rs=stmt.executeQuery(chk);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"User_id is not available");
						textFieldUserid.setText(null);
						
					}
					else if(flag==0)
					{
						String sql="insert into users(user,name,user_id,password,mobile_no,email)values('"+comboBox.getSelectedItem()+"',"
								+ "'"+textFieldName.getText()+"','"+textFieldUserid.getText()+"','"+passwordField.getText().toString()+"','"+textFieldMobile.getText()+"',"
										+ "'"+textFieldEmail.getText()+comboBox_1.getSelectedItem()+"');";
							int c=stmt.executeUpdate(sql);
							if(c==1)
							{
								JOptionPane.showMessageDialog(null,"Registration Successfull..!!!");
								comboBox.setSelectedItem("Please Select User");
								textFieldName.setText(null);
								textFieldUserid.setText(null);
								passwordField.setText(null);
								passwordFieldConfirm.setText(null);
								textFieldMobile.setText(null);
								textFieldEmail.setText(null);
								dispose();
								LpgFront lg=new LpgFront();
								lg.frmLpg.setVisible(true);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error...");
							}
					}
					con.close();
					}catch(Exception e) {System.out.println(e);}
			}
		});
		okbtn.setForeground(Color.BLACK);
		okbtn.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		okbtn.setBounds(310, 491, 131, 43);
		contentPane.add(okbtn);
		
		JButton backbtn = new JButton(" Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LpgFront lg=new LpgFront();
				lg.frmLpg.setVisible(true);
				
			}
		});
		backbtn.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		backbtn.setBounds(10, 527, 131, 43);
		contentPane.add(backbtn);
		
		JButton exitbtn = new JButton("  Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitbtn.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		exitbtn.setBounds(593, 523, 131, 47);
		contentPane.add(exitbtn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setBounds(226, 392, 313, 31);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordFieldConfirm.setBounds(226, 449, 313, 31);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblNewLabel_7 = new JLabel("      Enter Your Details");
		lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));
		lblNewLabel_7.setBounds(169, 24, 400, 52);
		contentPane.add(lblNewLabel_7);
		
		JLabel label = new JLabel("@");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(392, 216, 33, 33);
		contentPane.add(label);
		
		
	}
}
