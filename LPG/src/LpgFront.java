import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class LpgFront {

	protected JFrame frmLpg;
	protected JTextField user1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LpgFront window = new LpgFront();
					window.frmLpg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public LpgFront() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLpg = new JFrame();
		frmLpg.getContentPane().setBackground(UIManager.getColor("InternalFrame.borderColor"));
		frmLpg.setBackground(Color.ORANGE);
		frmLpg.setTitle("LPG");
		frmLpg.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AmanKumar\\Pictures\\Button-Info-icon1.png"));
		frmLpg.getContentPane().setFont(new Font("Monotype Corsiva", Font.BOLD, 12));
		frmLpg.setBounds(100, 100, 650, 450);
		frmLpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLpg.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("     User ID");
		lblUserId.setFont(new Font("Verdana", Font.BOLD, 15));
		lblUserId.setBounds(48, 145, 131, 37);
		frmLpg.getContentPane().add(lblUserId);
		
		user1 = new JTextField();
		user1.setBounds(212, 147, 288, 37);
		frmLpg.getContentPane().add(user1);
		user1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		comboBox.addItem("Please Select User");
		comboBox.addItem("Customer");
		comboBox.addItem("Agent");
		comboBox.addItem("Administrative Staff");
		//comboBox.getInputContext()
		comboBox.setSelectedItem("Please Select User");
		comboBox.setBounds(212, 75, 200, 37);
		frmLpg.getContentPane().add(comboBox);
		
		JLabel lblPassword = new JLabel("   Password");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPassword.setBounds(58, 209, 121, 37);
		frmLpg.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 211, 288, 37);
		frmLpg.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton(" LogIn");
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		Image img=new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="Select user,user_id,password from users where  user='"+comboBox.getSelectedItem().toString()+"' and user_id='"+user1.getText()+"' and password='"+passwordField.getText().toString()+"';";
					ResultSet rs=stmt.executeQuery(sql);
					boolean cd=rs.next();

					if(cd)
					{
						JOptionPane.showMessageDialog(null,"Login Successfully...!!!");
						frmLpg.hide();;
						if(comboBox.getSelectedItem().toString().equalsIgnoreCase("customer"))
						{
							Cust cst=new Cust();
							cst.setVisible(true);
							cst.textField.setText(user1.getText());
						}
						else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("agent"))
						{
							Agent ag=new Agent();
							ag.setVisible(true);
						}
						else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("administrative staff"))
						{
							AdminStaff adst=new AdminStaff();
							adst.setVisible(true);
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid User_Id or Password");
					con.close();
							}catch(Exception e) {System.out.println(e);}
				passwordField.setText(null);
				user1.setText(null);
			}
		});
		
		
		btnLogin.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		btnLogin.setBounds(245, 270, 131, 37);
		frmLpg.getContentPane().add(btnLogin);
		
		JButton btnNewReg = new JButton("Register");
		btnNewReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLpg.dispose();
				Regist ng=new Regist();
				ng.setVisible(true);
			}
		});
		btnNewReg.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnNewReg.setBounds(151, 318, 148, 29);
		frmLpg.getContentPane().add(btnNewReg);
		
		JButton btnFgtPswd = new JButton("Forgot Password");
		btnFgtPswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLpg.dispose();
				ForgotPass fg=new ForgotPass();
				fg.setVisible(true);
				
			}
		});
		btnFgtPswd.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnFgtPswd.setBounds(309, 318, 148, 29);
		frmLpg.getContentPane().add(btnFgtPswd);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm=JOptionPane.showConfirmDialog(null, "Do you really want to Exit", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if(confirm==0)
				{
				System.exit(0);
				}
			}
		});
		
		btnQuit.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnQuit.setBounds(513, 371, 111, 29);
		frmLpg.getContentPane().add(btnQuit);

		
		JLabel lblSelectUser = new JLabel("    Select User");
		lblSelectUser.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSelectUser.setBounds(48, 73, 131, 37);
		frmLpg.getContentPane().add(lblSelectUser);
		
		JLabel lblTitle = new JLabel("    LPG SERVICE PORTAL");
		lblTitle.setBackground(new Color(0, 255, 0));
		lblTitle.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
		lblTitle.setBounds(193, 11, 274, 37);
		frmLpg.getContentPane().add(lblTitle);
		
		JLabel labelUser = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		labelUser.setIcon(new ImageIcon(img1));
		labelUser.setBounds(34, 145, 53, 37);
		frmLpg.getContentPane().add(labelUser);
		
		JLabel lblKey = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/key.png")).getImage();
		lblKey.setIcon(new ImageIcon(img2));
		lblKey.setBounds(34, 209, 53, 37);
		frmLpg.getContentPane().add(lblKey);
	}
}
