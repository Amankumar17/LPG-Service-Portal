import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class ForgotPass extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserId;
	private JTextField textFieldRegMobile;
	private JPasswordField passwordFieldNew;
	private JPasswordField PasswordFieldConfirm;

	/**
	 * Launch the application.
	 */
	int f=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass frame = new ForgotPass();
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
	public ForgotPass() {
		setTitle("Password Reset");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(214, 83, 226, 40);
		contentPane.add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		textFieldRegMobile = new JTextField();
		textFieldRegMobile.setBounds(214, 153, 226, 40);
		contentPane.add(textFieldRegMobile);
		textFieldRegMobile.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("     User Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 79, 150, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Registered Mobile No.");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 153, 194, 40);
		contentPane.add(lblNewLabel_1);
		
		final JButton btnReset = new JButton("Reset Password");
		btnReset.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnReset.setBounds(154, 381, 169, 30);
		contentPane.add(btnReset);
		btnReset.setEnabled(false);
		//final Image img1=new ImageIcon(this.getClass().getResource("/Button-Info-icon1")).getImage();
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int flag=0;
					if(passwordFieldNew.getText().toString().equals(PasswordFieldConfirm.getText().toString())==false)
					{
						JOptionPane.showMessageDialog(null,"Both the passwords are different.");
						flag=1;
					}
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String chk="Update users set password='"+PasswordFieldConfirm.getText().toString()+"' where user_id='"+textFieldUserId.getText()+"';";
					if(flag==0)
					{
						stmt.executeUpdate(chk);
						JOptionPane.showMessageDialog(null,"Password Reset Successfull");
						textFieldUserId.setText(null);
						passwordFieldNew.setText(null);
						PasswordFieldConfirm.setText(null);
						textFieldRegMobile.setText(null);
						dispose();
						LpgFront lf=new LpgFront();
						lf.frmLpg.setVisible(true);
					}
					con.close();
					}catch(Exception e) {System.out.println(e);}
				
				}
		});
	
		JButton btnVerify = new JButton("Verify\r\n");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String chk="Select user_id from users where user_id='"+textFieldUserId.getText()+"' and mobile_no='"+textFieldRegMobile.getText()+"';";
					ResultSet rs=stmt.executeQuery(chk);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"Verification Successfull");
						passwordFieldNew.setEnabled(true);
						PasswordFieldConfirm.setEnabled(true);
						btnReset.setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"No such User_Id found.");
						textFieldUserId.setText(null);
						textFieldRegMobile.setText(null);
					}
					con.close();
					}catch(Exception e) {System.out.println(e);}
			}
		});
		btnVerify.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnVerify.setBounds(167, 204, 119, 30);
		contentPane.add(btnVerify);
		
		JLabel lblNewLabel_2 = new JLabel("Enter New Password");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(25, 253, 179, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_3.setBounds(35, 317, 169, 40);
		contentPane.add(lblNewLabel_3);
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setBounds(214, 257, 226, 40);
		contentPane.add(passwordFieldNew);
		passwordFieldNew.setEnabled(false);
		
		PasswordFieldConfirm = new JPasswordField();
		PasswordFieldConfirm.setBounds(214, 321, 226, 40);
		contentPane.add(PasswordFieldConfirm);
		PasswordFieldConfirm.setEnabled(false);
		
		JLabel lblNewLabel_4 = new JLabel("Reset Password");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel_4.setBounds(100, 11, 300, 40);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LpgFront lf=new LpgFront();
				lf.frmLpg.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(10, 420, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(374, 420, 100, 30);
		contentPane.add(btnNewButton_1);
		
		
		

		
	}
}
