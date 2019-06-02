import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cust extends JFrame {

	private JPanel contentPane;
	protected JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cust frame = new Cust();
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
	
	
	public Cust() {
		setTitle("Cutsomer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnNewButton = new JButton("New Connection");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewConnection nct=new NewConnection();
				nct.setVisible(true);
				nct.textFieldUser.setText(textField.getText());
				dispose();
				/*try {
					
				}catch(exception e) {
					
				}
				*/
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(36, 73, 215, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Address");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ChangeAddress chad=new ChangeAddress();
			chad.textFieldUser.setText(textField.getText());
			chad.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(36, 153, 215, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Booking History");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CusBookingHistory cbh=new CusBookingHistory();
				cbh.setVisible(true);
				cbh.textFieldUser.setText(textField.getText());
				dispose();
			
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(36, 233, 215, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Servicing");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm=JOptionPane.showConfirmDialog(null, "Do you really want Servicing", "Confirm Servicing", JOptionPane.YES_NO_OPTION);
				try
				{
					if(confirm==0)
					{
						if(textField.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Error...");
						}
						else
						{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Statement stmt=con.createStatement();
						String chk="Insert into servcom (user_id,sdatetime) values ('"+textField.getText()+"',now());";
						int rs=stmt.executeUpdate(chk);
						if(rs==1)
						{
							JOptionPane.showMessageDialog(null,"Your request has been recorded");
							//textFieldUserid.setText(null);
							
						}
						}
					}
				}catch(Exception e)
				{
					
				}
				/*Servicing srv=new Servicing();
				srv.setVisible(true);
				srv.textFieldUser.setText(textField.getText());*/
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_3.setBounds(348, 153, 215, 50);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Complaints");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Complaints cs=new Complaints();
				cs.setVisible(true);
				cs.textFieldUser.setText(textField.getText());
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_4.setBounds(348, 233, 215, 50);
		contentPane.add(btnNewButton_4);
		
		
		
		JButton btnNewButton_5 = new JButton("SignOut");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm=JOptionPane.showConfirmDialog(null, "Do you really want to Sign Out", "Sign Out", JOptionPane.YES_NO_OPTION);
				if(confirm==0)
				{
				
				LpgFront lg=new LpgFront();
				lg.frmLpg.setVisible(true);
				//lg.textField.setText(textField.getText());
				dispose();
				} 
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_5.setBounds(464, 356, 160, 44);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Gas Cylinder Booking");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CylinderBooking cybk=new CylinderBooking();
				cybk.setVisible(true);
				cybk.textFieldUser.setText(textField.getText());
				cybk.textFieldid.setText(textField.getText());
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_6.setBounds(349, 73, 215, 50);
		contentPane.add(btnNewButton_6);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(524, 11, 100, 30);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
