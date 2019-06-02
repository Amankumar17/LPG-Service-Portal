import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CusBookingHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	protected JTextField textFieldUser;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusBookingHistory frame = new CusBookingHistory();
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
	public CusBookingHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 80, 544, 320);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("LOAD HISTORY");
		btnNewButton.setBounds(382, 11, 174, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="Select bookingdate,bookingtime,deliverydate,deliverytime from bookings where user_id='"+textFieldUser.getText()+"';";
					ResultSet rs=stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(604, 16, 120, 30);
		textFieldUser.setEditable(false);
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
		btnBack.setBounds(10, 11, 120, 37);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnBack);
	}
}
