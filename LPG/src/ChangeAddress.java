import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
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
import java.awt.event.ActionEvent;

public class ChangeAddress extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textFieldFlno;
	private JTextField textFieldBrapt;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldDistrict;
	private JTextField textFieldPin;
	protected JTextField textFieldUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeAddress frame = new ChangeAddress();
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
	public ChangeAddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHouseflatNo = new JLabel("HOUSE/FLAT NO.");
		lblHouseflatNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHouseflatNo.setBounds(10, 126, 120, 25);
		contentPane.add(lblHouseflatNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 127, 175, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBuildingapt = new JLabel("BUILDING/APT.");
		lblBuildingapt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuildingapt.setBounds(366, 126, 120, 25);
		contentPane.add(lblBuildingapt);
		
		textField_3 = new JTextField();
		textField_3.setBounds(496, 127, 175, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStreetName = new JLabel("STREET NAME");
		lblStreetName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblStreetName.setBounds(10, 167, 120, 25);
		contentPane.add(lblStreetName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 168, 175, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCitytown = new JLabel("CITY/TOWN");
		lblCitytown.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCitytown.setBounds(366, 167, 120, 25);
		contentPane.add(lblCitytown);
		
		textField_5 = new JTextField();
		textField_5.setBounds(496, 168, 175, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDistrict = new JLabel("DISTRICT");
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDistrict.setBounds(10, 205, 120, 25);
		contentPane.add(lblDistrict);
		
		textField_6 = new JTextField();
		textField_6.setBounds(140, 206, 175, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblState.setBounds(10, 247, 120, 25);
		contentPane.add(lblState);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Andhra Pradesh");
		comboBox.addItem("Arunachal Pradesh");
		comboBox.addItem("Assam");
		comboBox.addItem("Bihar");
		comboBox.addItem("Chhattisgarh");
		comboBox.addItem("Delhi");
		comboBox.addItem("Goa");
		comboBox.addItem("Gujarat");
		comboBox.addItem("Haryana");
		comboBox.addItem("Himachal Pradesh");
		comboBox.addItem("Jammu & Kashmir");
		comboBox.addItem("Jharkhand");
		comboBox.addItem("Karnataka");
		comboBox.addItem("Kerala");
		comboBox.addItem("Madhya Pradesh");
		comboBox.addItem("Maharashtra");
		comboBox.addItem("Manipur");
		comboBox.addItem("Meghalaya");
		comboBox.addItem("Mizoram");
		comboBox.addItem("Nagaland");
		comboBox.addItem("Odisha");
		comboBox.addItem("Punjab");
		comboBox.addItem("Rajasthan");
		comboBox.addItem("Sikkim");
		comboBox.addItem("Tamil Nadu");
		comboBox.addItem("Telangana");
		comboBox.addItem("Tripura");
		comboBox.addItem("Uttarakhand");
		comboBox.addItem("Uttar Pradesh");
		comboBox.addItem("West Bengal");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(140, 248, 175, 25);
		contentPane.add(comboBox);
		
		JLabel lblPincode = new JLabel("PIN CODE");
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPincode.setBounds(366, 205, 120, 25);
		contentPane.add(lblPincode);
		
		textField_7 = new JTextField();
		textField_7.setBounds(496, 206, 175, 25);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPreviousAddress = new JLabel("PREVIOUS ADDRESS");
		lblPreviousAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPreviousAddress.setBounds(10, 90, 225, 25);
		contentPane.add(lblPreviousAddress);
		
		JLabel lblNewAddress = new JLabel("NEW ADDRESS");
		lblNewAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewAddress.setBounds(10, 293, 225, 25);
		contentPane.add(lblNewAddress);
		
		JLabel lblHouseflatNo_1 = new JLabel("HOUSE/FLAT NO.");
		lblHouseflatNo_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHouseflatNo_1.setBounds(10, 329, 120, 25);
		contentPane.add(lblHouseflatNo_1);
		
		textFieldFlno = new JTextField();
		textFieldFlno.setBounds(140, 329, 175, 25);
		contentPane.add(textFieldFlno);
		textFieldFlno.setColumns(10);
		
		JLabel lblBuildingapt_1 = new JLabel("BUILDING/APT");
		lblBuildingapt_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuildingapt_1.setBounds(366, 329, 120, 25);
		contentPane.add(lblBuildingapt_1);
		
		textFieldBrapt = new JTextField();
		textFieldBrapt.setBounds(496, 330, 175, 25);
		contentPane.add(textFieldBrapt);
		textFieldBrapt.setColumns(10);
		
		JLabel lblStreetNo = new JLabel("STREET NO.");
		lblStreetNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblStreetNo.setBounds(10, 368, 120, 25);
		contentPane.add(lblStreetNo);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setBounds(140, 368, 175, 25);
		contentPane.add(textFieldStreet);
		textFieldStreet.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(496, 369, 175, 25);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblCitytown_1 = new JLabel("CITY/TOWN");
		lblCitytown_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCitytown_1.setBounds(366, 368, 120, 25);
		contentPane.add(lblCitytown_1);
		
		JLabel lblDistrict_1 = new JLabel("DISTRICT");
		lblDistrict_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDistrict_1.setBounds(10, 405, 120, 25);
		contentPane.add(lblDistrict_1);
		
		textFieldDistrict = new JTextField();
		textFieldDistrict.setBounds(140, 405, 175, 25);
		contentPane.add(textFieldDistrict);
		textFieldDistrict.setColumns(10);
		
		JLabel lblPinCode = new JLabel("PIN CODE");
		lblPinCode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPinCode.setBounds(366, 405, 120, 25);
		contentPane.add(lblPinCode);
		
		textFieldPin = new JTextField();
		textFieldPin.setBounds(496, 405, 175, 25);
		contentPane.add(textFieldPin);
		textFieldPin.setColumns(10);
		
		JLabel lblState_1 = new JLabel("STATE");
		lblState_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblState_1.setBounds(10, 443, 120, 25);
		contentPane.add(lblState_1);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Andhra Pradesh");
		comboBox_1.addItem("Arunachal Pradesh");
		comboBox_1.addItem("Assam");
		comboBox_1.addItem("Bihar");
		comboBox_1.addItem("Chhattisgarh");
		comboBox_1.addItem("Delhi");
		comboBox_1.addItem("Goa");
		comboBox_1.addItem("Gujarat");
		comboBox_1.addItem("Haryana");
		comboBox_1.addItem("Himachal Pradesh");
		comboBox_1.addItem("Jammu & Kashmir");
		comboBox_1.addItem("Jharkhand");
		comboBox_1.addItem("Karnataka");
		comboBox_1.addItem("Kerala");
		comboBox_1.addItem("Madhya Pradesh");
		comboBox_1.addItem("Maharashtra");
		comboBox_1.addItem("Manipur");
		comboBox_1.addItem("Meghalaya");
		comboBox_1.addItem("Mizoram");
		comboBox_1.addItem("Nagaland");
		comboBox_1.addItem("Odisha");
		comboBox_1.addItem("Punjab");
		comboBox_1.addItem("Rajasthan");
		comboBox_1.addItem("Sikkim");
		comboBox_1.addItem("Tamil Nadu");
		comboBox_1.addItem("Telangana");
		comboBox_1.addItem("Tripura");
		comboBox_1.addItem("Uttarakhand");
		comboBox_1.addItem("Uttar Pradesh");
		comboBox_1.addItem("West Bengal");
		comboBox_1.setSelectedItem(null);
		comboBox_1.setBounds(140, 441, 175, 25);
		contentPane.add(comboBox_1);
		
		JButton btnUpdateAddress = new JButton("UPDATE ADDRESS");
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("In Button");
				try {
					if(textFieldUser.getText().isEmpty() || textFieldFlno.getText().isEmpty() || textFieldBrapt.getText().isEmpty() || textFieldStreet.getText().isEmpty() || textFieldCity.getText().isEmpty() || textFieldDistrict.getText().isEmpty() || textFieldPin.getText().isEmpty() || comboBox_1.getSelectedItem().toString().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please Enter all the Details Properly.");
						//System.out.println(textFieldUser.getText()+"In if part.");
					}
					else
					{
						
						//System.out.println("In else part");
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Statement stmt=con.createStatement();
						String tab="Update custaddr set flat='"+textFieldFlno.getText()+"', brapt='"+textFieldBrapt.getText()+"', street='"+textFieldStreet.getText()+"', city='"+textFieldCity.getText()+"', district='"+textFieldDistrict.getText()+"', pincode'"+textFieldPin.getText()+"', state='"+comboBox_1.getSelectedItem().toString()+"' where u_id='"+textFieldUser.getText()+"';";
						//Statement stmt=con.prepareStatement(tab);
						ResultSet rs=stmt.executeQuery(tab);
						if(rs.next())
						{
								//stmt.executeUpdate(sql);
								JOptionPane.showMessageDialog(null,"Update Successfull..!!!");
								
								textFieldFlno.setText(null);
								textFieldBrapt.setText(null);
								textFieldStreet.setText(null);
								textFieldCity.setText(null);
								textFieldDistrict.setText(null);
								textFieldPin.setText(null);
								comboBox_1.setSelectedItem(null);
								Cust ct=new Cust();
								ct.setVisible(true);
								ct.textField.setText(textFieldUser.getText());
								dispose();
								
								//dispose();
								
								
						}
						else
						{
							//System.out.println("In error part");
							JOptionPane.showMessageDialog(null,"Error in Update");
							//textFieldUserid.setText(null);
							
						}
						con.close();
					}
				}catch(Exception e)
				{
					
				}
			}
		});
		btnUpdateAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdateAddress.setBounds(242, 490, 200, 35);
		contentPane.add(btnUpdateAddress);
		
		textFieldUser = new JTextField();
		textFieldUser.setEditable(false);
		textFieldUser.setBounds(604, 11, 120, 30);
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
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(10, 520, 120, 30);
		contentPane.add(btnBack);
	}
}
