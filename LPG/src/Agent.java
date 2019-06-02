import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Agent extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldCap;
	private JTable table;
	private JTextField textFieldCaptcha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agent frame = new Agent();
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
	public Agent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 43, 964, 357);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("SHOW BOOKINGS", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 11, 752, 307);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					int row=table.getSelectedRow();
					String uid=(table.getModel().getValueAt(row,0)).toString();
					textFieldUser.setText(uid);
					
				}catch(Exception e)
				{
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnLoadBookings = new JButton("Load Bookings");
		btnLoadBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
					Statement stmt=con.createStatement();
					String sql="select b.user_id,b.bookingdate,b.bookingtime,c.flat,c.brapt as building,c.street,c.city,c.district,c.pincode,c.state from bookings b INNER JOIN custaddr c ON (b.user_id=c.u_id and b.deliverydate is null);";
					ResultSet rs=stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e)
				{
					
				}
			}
		});
		btnLoadBookings.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLoadBookings.setBounds(10, 93, 140, 35);
		panel.add(btnLoadBookings);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNext.setBounds(10, 178, 100, 30);
		panel.add(btnNext);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("DELIVERY SYSTEM", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblConsumerNo = new JLabel("USER-ID");
		lblConsumerNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblConsumerNo.setBounds(144, 27, 150, 40);
		panel_1.add(lblConsumerNo);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(323, 32, 225, 35);
		panel_1.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblCustomersBookingId = new JLabel("CAPTCHA");
		lblCustomersBookingId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomersBookingId.setBounds(144, 168, 150, 40);
		panel_1.add(lblCustomersBookingId);
		
		textFieldCap = new JTextField();
		textFieldCap.setBounds(323, 173, 225, 35);
		panel_1.add(textFieldCap);
		textFieldCap.setColumns(10);
		
		JButton btnConfirmDelivery = new JButton("CONFIRM DELIVERY");
		btnConfirmDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					if(textFieldCaptcha.getText().equals(textFieldCap.getText())==false)
					{
						JOptionPane.showMessageDialog(null, "Captcha didn't match");
					}
					else
					{
						//JOptionPane.showMessageDialog(null, "Captcha  match");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
				Statement stmt=con.createStatement();
				String chk="Update bookings  set deliverydate=curdate() ,deliverytime=curtime() where user_id='"+textFieldUser.getText()+"' and deliverydate is null;";
				int rs=stmt.executeUpdate(chk);
				if(rs==1)
				{
					JOptionPane.showMessageDialog(null,"Delivery Confirmed...!!!");
					textFieldUser.setText(null);
					textFieldCap.setText(null);
					tabbedPane.setSelectedIndex(1);
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
		btnConfirmDelivery.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnConfirmDelivery.setBounds(232, 219, 225, 40);
		panel_1.add(btnConfirmDelivery);
		
		textFieldCaptcha = new JTextField();
		textFieldCaptcha.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textFieldCaptcha.setEditable(false);
		textFieldCaptcha.setBounds(323, 98, 225, 46);
		panel_1.add(textFieldCaptcha);
		textFieldCaptcha.setColumns(10);
		
		JButton btnGeneratecaptcha = new JButton("GENERATECAPTCHA");
		btnGeneratecaptcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand=new Random();
				String z="";
				
				for(int i=0;i<5;i++)
				{
					char t='A';
					//char u='Z';
					int k=rand.nextInt(51);
					
					for(int j=1;j<=k;j++)
						t++;
					/*for(int j=1;j<=k;j++)
						u--;
					*/
					z=z+t;
				}
				textFieldCaptcha.setText(z);
			}
		});
		btnGeneratecaptcha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGeneratecaptcha.setBounds(94, 100, 200, 40);
		panel_1.add(btnGeneratecaptcha);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LpgFront lg=new LpgFront();
				lg.frmLpg.setVisible(true);
			}
		});
		btnSignOut.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignOut.setBounds(10, 11, 130, 29);
		contentPane.add(btnSignOut);
	}
}
