import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Complaints extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSub;
	protected JTextField textFieldUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaints frame = new Complaints();
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
	public Complaints() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourComplaint = new JLabel("ENTER YOUR COMPLAINT");
		lblEnterYourComplaint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterYourComplaint.setBounds(10, 11, 220, 37);
		contentPane.add(lblEnterYourComplaint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 414, 69);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
						if(textFieldSub.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Error...");
						}
						else
						{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Statement stmt=con.createStatement();
						String chk="Insert into servcom (user_id,cdatetime,csub,cbody) values ('"+textFieldUser.getText()+"',now(),'"+textFieldSub.getText()+"','"+textArea.getText()+"');";
						int rs=stmt.executeUpdate(chk);
						if(rs==1)
						{
							JOptionPane.showMessageDialog(null,"Your request has been recorded");
							//textFieldUserid.setText(null);
							Cust ct=new Cust();
							ct.setVisible(true);
							ct.textField.setText(textFieldUser.getText());
							dispose();
						}
						}
					
				}catch(Exception e)
				{
					
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSubmit.setBounds(130, 219, 150, 31);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("SUBJECT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 59, 80, 25);
		contentPane.add(lblNewLabel);
		
		textFieldSub = new JTextField();
		textFieldSub.setBounds(10, 85, 414, 25);
		contentPane.add(textFieldSub);
		textFieldSub.setColumns(10);
		
		JLabel lblBody = new JLabel("BODY");
		lblBody.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBody.setBounds(10, 118, 80, 14);
		contentPane.add(lblBody);
		
		textFieldUser = new JTextField();
		textFieldUser.setEditable(false);
		textFieldUser.setBounds(324, 11, 100, 25);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cust ct=new Cust();
				ct.setVisible(true);
				ct.textField.setText(textFieldUser.getText());
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(10, 255, 89, 23);
		contentPane.add(btnBack);
	}
}
