import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CylinderBooking extends JFrame {

	private JPanel contentPane;
	protected JTextField textFieldid;
	private JTextField textFieldCap;
	protected JTextField textFieldUser;
	private JButton btnBack;
	private JTextField textFieldCaptcha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CylinderBooking frame = new CylinderBooking();
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

	public CylinderBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(63, 72, 130, 30);
		contentPane.add(lblNewLabel);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(211, 72, 200, 30);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		JButton btnGenerateCaptcha = new JButton("REFRESH");
		btnGenerateCaptcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand=new Random();
				String z="";
				
				for(int i=0;i<5;i++)
				{
					char t='A';
					//char u='Z';
					int k=rand.nextInt(50);
					
					for(int j=1;j<=k;j++)
						t++;
					
					z=z+t;
				}
				textFieldCaptcha.setText(z);
				
			}
		});
		btnGenerateCaptcha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnGenerateCaptcha.setBounds(345, 118, 104, 30);
		contentPane.add(btnGenerateCaptcha);
		
		JLabel lblEnterCaptcha = new JLabel("ENTER CAPTCHA");
		lblEnterCaptcha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterCaptcha.setBounds(63, 162, 140, 30);
		contentPane.add(lblEnterCaptcha);
		
		textFieldCap = new JTextField();
		textFieldCap.setBounds(211, 163, 200, 30);
		contentPane.add(textFieldCap);
		textFieldCap.setColumns(10);
		
		JButton btnBookCylinder = new JButton("BOOK CYLINDER");
		btnBookCylinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					if(textFieldCaptcha.getText().equals(textFieldCap.getText())==false)
					{
						JOptionPane.showMessageDialog(null, "Captcha didn't match");
					}
					else if(textFieldCap.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please enter captcha");
					}
					else
					{
						//JOptionPane.showMessageDialog(null, "Captcha  match");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
				Statement stmt=con.createStatement();
				String chk="Insert into bookings (user_id,bookingdate,bookingtime) values ('"+textFieldUser.getText()+"',curdate(),curtime());";
				int rs=stmt.executeUpdate(chk);
				if(rs==1)
				{
					JOptionPane.showMessageDialog(null,"Booking Confirmed...!!!");
					textFieldid.setText(null);
					textFieldCap.setText(null);
					Cust ct=new Cust();
					ct.setVisible(true);
					ct.textField.setText(textFieldUser.getText());
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error in Booking.");
				}
					}
					}catch(Exception e)
				{
					
				}
			}
		});
		btnBookCylinder.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBookCylinder.setBounds(144, 208, 175, 30);
		contentPane.add(btnBookCylinder);
		
		textFieldUser = new JTextField();
		textFieldUser.setEditable(false);
		textFieldUser.setBounds(329, 11, 120, 30);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cust ct=new Cust();
				ct.setVisible(true);
				ct.textField.setText(textFieldUser.getText());
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		
		textFieldCaptcha = new JTextField();
		textFieldCaptcha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		textFieldCaptcha.setEditable(false);
		textFieldCaptcha.setBounds(211, 118, 120, 30);
		contentPane.add(textFieldCaptcha);
		textFieldCaptcha.setColumns(10);
	}
}
