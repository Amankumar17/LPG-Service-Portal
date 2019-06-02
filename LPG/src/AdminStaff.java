import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AdminStaff extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_3;
	private JTextField textFieldUserId;
	private JTextField textFieldName;
	private JTextField textFieldMobile;
	private JTextField textFieldEmail;
	private JTextField textFieldUserIdc;
	private JTextField textFieldSub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStaff frame = new AdminStaff();
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
	public AdminStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 57, 964, 343);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("NEW BOOKINGS", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 11, 740, 293);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowBookings = new JButton("SHOW  BOOKINGS");
		btnShowBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select b.user_id,b.bookingdate,b.bookingtime,c.flat,c.brapt as building,c.street,c.city,c.district,c.pincode,c.state from bookings b INNER JOIN custaddr c ON (b.user_id=c.u_id and b.deliverydate is null);";
					ResultSet rs=stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}catch(Exception e)
				{
					
				}
			}
		});
		btnShowBookings.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnShowBookings.setBounds(10, 11, 161, 50);
		panel.add(btnShowBookings);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("COMPLAINTS", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 532, 255);
		panel_2.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(552, 166, 397, 138);
		panel_2.add(textArea);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					int row=table_1.getSelectedRow();
					String uid=(table_1.getModel().getValueAt(row,0)).toString();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select user_id,cdatetime,csub,cbody from servcom where user_id='"+uid+"';";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						textFieldUserIdc.setText(rs.getString("user_id"));
						textFieldSub.setText(rs.getString("csub"));
						textArea.setText(rs.getString("cbody"));
					}con.close();
					
				}catch(Exception e)
				{
					
				}
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select user_id,cdatetime,csub from servcom;";
					ResultSet rs=stmt.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}catch(Exception e)
				{
					
				}
			}
		});
		btnLoadData.setBounds(10, 11, 106, 31);
		panel_2.add(btnLoadData);
		
		JLabel lblUserid = new JLabel("USER-ID");
		lblUserid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserid.setBounds(552, 61, 77, 24);
		panel_2.add(lblUserid);
		
		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSubject.setBounds(552, 96, 77, 24);
		panel_2.add(lblSubject);
		
		textFieldUserIdc = new JTextField();
		textFieldUserIdc.setBounds(639, 62, 151, 22); 
		panel_2.add(textFieldUserIdc);
		textFieldUserIdc.setColumns(10);
		
		textFieldSub = new JTextField();
		textFieldSub.setBounds(639, 98, 310, 22);
		panel_2.add(textFieldSub);
		textFieldSub.setColumns(10);
		
		JLabel lblBody = new JLabel("BODY");
		lblBody.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBody.setBounds(552, 131, 77, 24);
		panel_2.add(lblBody);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("MANAGE RECORDS", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(374, 11, 575, 293);
		panel_3.add(scrollPane_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.addItem("Customer");
		comboBox.addItem("Agent");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(95, 60, 150, 25);
		panel_3.add(comboBox);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					int row=table_3.getSelectedRow();
					String uid=(table_3.getModel().getValueAt(row,1)).toString();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select user,user_id,name,mobile_no,email from users where user_id='"+uid+"';";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						comboBox.setSelectedItem(rs.getString("user"));
						textFieldUserId.setText(rs.getString("user_id"));
						textFieldName.setText(rs.getString("name"));
						textFieldMobile.setText(rs.getString("mobile_no"));
						textFieldEmail.setText(rs.getString("email"));
					}con.close();
					
				}catch(Exception e)
				{
					
				}
				
			}
		});
		scrollPane_3.setViewportView(table_3);
		
		JButton btnLoadRecords = new JButton("LOAD RECORDS");
		btnLoadRecords.setBounds(10, 11, 177, 37);
		btnLoadRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select user,user_id,name,mobile_no,email from users where user!='administrative staff';";
					ResultSet rs=stmt.executeQuery(sql);
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}catch(Exception e)
				{
					
				}
			}
		});
		btnLoadRecords.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_3.add(btnLoadRecords);
		
		JLabel lblName = new JLabel("USER-ID");
		lblName.setBounds(10, 95, 75, 25);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblName);
		
		JLabel lblName_1 = new JLabel("NAME");
		lblName_1.setBounds(10, 130, 75, 25);
		lblName_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblName_1);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setBounds(10, 165, 75, 25);
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblMobile);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(10, 200, 75, 25);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblEmail);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(10, 60, 75, 25);
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblUser);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setEditable(false);
		textFieldUserId.setBounds(95, 95, 150, 25);
		panel_3.add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
	
		
		textFieldName = new JTextField();
		textFieldName.setBounds(95, 130, 150, 25);
		panel_3.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(95, 165, 150, 25);
		panel_3.add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 200, 150, 25);
		panel_3.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnSave = new JButton("UPDATE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="update users set name='"+textFieldName.getText()+"',mobile_no='"+textFieldMobile.getText()+"',email='"+textFieldEmail.getText()+"' where user_id='"+textFieldUserId.getText()+"';";
					int f=stmt.executeUpdate(sql);
					if(f==1)
					{
						JOptionPane.showMessageDialog(null, "Data Updated Succesfully..!!");
						String ref="select user,user_id,name,mobile_no,email from users where user!='administrative staff';";
						ResultSet rs=stmt.executeQuery(ref);
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
						textFieldUserId.setText(null);
						textFieldMobile.setText(null);
						textFieldEmail.setText(null);
						textFieldName.setText(null);
						comboBox.setSelectedItem(null);
					}
					con.close();
				}catch(Exception e)
				{
					
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSave.setBounds(20, 233, 115, 30);
		panel_3.add(btnSave);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					int flag=JOptionPane.showConfirmDialog(null, "All the data will be deleted from our records.", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
					System.out.println(flag);
					if(flag==0)
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Statement stmt=con.createStatement();
						
						String s2="delete from cust where u_id='"+textFieldUserId.getText()+"';";
						int l=stmt.executeUpdate(s2);
						//System.out.println(l);
						String s3="delete from custaddr where u_id='"+textFieldUserId.getText()+"';";
						int a=stmt.executeUpdate(s3);
						//System.out.println(a);
						
						String s4="delete from bookings where user_id='"+textFieldUserId.getText()+"';";
						int g=stmt.executeUpdate(s4);
						String s5="delete from servcom where user_id='"+textFieldUserId.getText()+"';";
						int s=stmt.executeUpdate(s5);
						
						String s1="delete from users where user_id='"+textFieldUserId.getText()+"';";
						int f=stmt.executeUpdate(s1);
						System.out.println(f);
						if(f==1 && l==1 && a==1)
						{
							JOptionPane.showMessageDialog(null, "Data Deleted Succesfully..!!");
							String ref="select user,user_id,name,mobile_no,email from users where user!='administrative staff';";
							ResultSet rs=stmt.executeQuery(ref);
							table_3.setModel(DbUtils.resultSetToTableModel(rs));
							textFieldUserId.setText(null);
							textFieldMobile.setText(null);
							textFieldEmail.setText(null);
							textFieldName.setText(null);
							comboBox.setSelectedItem(null);
						}
						con.close();
					}
				}catch(Exception e)
				{
					
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.setBounds(161, 233, 115, 30);
		panel_3.add(btnDelete);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LpgFront lg=new LpgFront();
				lg.frmLpg.setVisible(true);
			}
		});
		btnSignOut.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSignOut.setBounds(10, 11, 149, 35);
		contentPane.add(btnSignOut);
	}
}
