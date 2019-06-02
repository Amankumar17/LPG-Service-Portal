import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.ImageIcon;

public class NewConnection extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JLabel lblDob;
	private JTextField textFieldDob;
	private JLabel lblDdmmyyyy;
	private JLabel lblGender;
	private JTextField textFieldFlno;
	private JTextField textFieldBrapt;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldDistrict;
	private JTextField textFieldPin;
	private JTextField textFieldMobile;
	private JTextField textFieldEmail;
	private JTextField textFieldBank;
	private JTextField textFieldBkname;
	private JTextField textFieldaccno;
	private JTextField textFieldIfsc;
	protected JTextField textFieldUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewConnection frame = new NewConnection();
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
	public NewConnection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 60, 714, 349);
		contentPane.add(tabbedPane);
		
		final JPanel panel = new JPanel();
		tabbedPane.addTab("PERSONAL DETAILS", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFullName.setBounds(42, 36, 130, 30);
		panel.add(lblFullName);
		
		lblDob = new JLabel("D-O-B");
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDob.setBounds(42, 94, 130, 30);
		panel.add(lblDob);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(181, 37, 300, 30);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDob = new JTextField();
		textFieldDob.setBounds(181, 94, 150, 30);
		panel.add(textFieldDob);
		textFieldDob.setColumns(10);
		
		lblDdmmyyyy = new JLabel("yyyy-mm-dd");
		lblDdmmyyyy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDdmmyyyy.setBounds(341, 97, 100, 30);
		panel.add(lblDdmmyyyy);
		
		lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(42, 162, 130, 30);
		panel.add(lblGender);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		btnNext.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		btnNext.setBounds(229, 225, 150, 40);
		panel.add(btnNext);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_4.setBounds(181, 162, 119, 30);
		panel.add(comboBox_4);
		comboBox_4.addItem("MALE");
		comboBox_4.addItem("FEMALE");
		comboBox_4.setSelectedItem(null);
		
		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("CONTACT DETAILS", null, panel_1, null);
		tabbedPane.setEnabledAt(1, true);
		panel_1.setLayout(null);
		
		JLabel lblHouseflatNo = new JLabel("HOUSE/FLAT NO.");
		lblHouseflatNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHouseflatNo.setBounds(10, 50, 120, 25);
		panel_1.add(lblHouseflatNo);
		
		textFieldFlno = new JTextField();
		textFieldFlno.setBounds(142, 50, 175, 25);
		panel_1.add(textFieldFlno);
		textFieldFlno.setColumns(10);
		
		JLabel lblBuildingapt = new JLabel("BUILDING/APT.");
		lblBuildingapt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuildingapt.setBounds(366, 54, 120, 25);
		panel_1.add(lblBuildingapt);
		
		textFieldBrapt = new JTextField();
		textFieldBrapt.setBounds(505, 50, 175, 25);
		panel_1.add(textFieldBrapt);
		textFieldBrapt.setColumns(10);
		
		JLabel lblStreetName = new JLabel("STREET NAME");
		lblStreetName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblStreetName.setBounds(10, 100, 120, 25);
		panel_1.add(lblStreetName);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setBounds(142, 100, 175, 25);
		panel_1.add(textFieldStreet);
		textFieldStreet.setColumns(10);
		
		JLabel lblCitytown = new JLabel("CITY/TOWN");
		lblCitytown.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCitytown.setBounds(366, 100, 120, 25);
		panel_1.add(lblCitytown);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(505, 100, 175, 25);
		panel_1.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblDistrict = new JLabel("DISTRICT");
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDistrict.setBounds(10, 150, 120, 25);
		panel_1.add(lblDistrict);
		
		textFieldDistrict = new JTextField();
		textFieldDistrict.setBounds(142, 150, 175, 25);
		panel_1.add(textFieldDistrict);
		textFieldDistrict.setColumns(10);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblState.setBounds(10, 200, 120, 25);
		panel_1.add(lblState);
		
		final JComboBox comboBox = new JComboBox();
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
		comboBox.setBounds(142, 200, 175, 25);
		panel_1.add(comboBox);
		
		JLabel lblPincode = new JLabel("PIN CODE");
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPincode.setBounds(366, 150, 120, 25);
		panel_1.add(lblPincode);
		
		textFieldPin = new JTextField();
		textFieldPin.setBounds(506, 150, 175, 25);
		panel_1.add(textFieldPin);
		textFieldPin.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMobileNo.setBounds(10, 250, 120, 25);
		panel_1.add(lblMobileNo);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(142, 250, 175, 25);
		panel_1.add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JLabel lblEmailid = new JLabel("EMAIL-ID");
		lblEmailid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmailid.setBounds(366, 250, 120, 25);
		panel_1.add(lblEmailid);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(506, 250, 175, 25);
		panel_1.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnNewButton.setBounds(295, 280, 100, 25);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("CONNECTION DETAILS", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblType = new JLabel("TYPE ");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblType.setBounds(50, 50, 120, 25);
		panel_2.add(lblType);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_1.addItem("Domestic");
		comboBox_1.addItem("Commercial");
		comboBox_1.setBounds(250, 50, 175, 25);
		panel_2.add(comboBox_1);
		
		JLabel lblNoOfCylinder = new JLabel("NO. OF CYLINDER");
		lblNoOfCylinder.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNoOfCylinder.setBounds(50, 100, 155, 25);
		panel_2.add(lblNoOfCylinder);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		comboBox_2.setBounds(250, 100, 175, 25);
		panel_2.add(comboBox_2);
		comboBox_2.addItem("1");
		comboBox_2.addItem("2");
		comboBox_2.setSelectedItem(null);
		
		JLabel lblIfYouWant = new JLabel("IF YOU WANT SUBSIDY CHOOSE 'YES' ELSE CHOOSE 'NO'.");
		lblIfYouWant.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIfYouWant.setBounds(50, 150, 540, 20);
		panel_2.add(lblIfYouWant);
		
		JLabel lblSubsidy = new JLabel("SUBSIDY");
		lblSubsidy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSubsidy.setBounds(50, 200, 120, 25);
		panel_2.add(lblSubsidy);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(250, 200, 125, 25);
		panel_2.add(comboBox_3);
		comboBox_3.addItem("YES");
		comboBox_3.addItem("NO");
		comboBox_3.setSelectedItem(null);
		
		JButton btnNext_1 = new JButton("NEXT");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNext_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		btnNext_1.setBounds(277, 248, 120, 30);
		panel_2.add(btnNext_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("BANK DETAILS", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblBankName = new JLabel("BANK NAME");
		lblBankName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBankName.setBounds(78, 42, 125, 30);
		panel_3.add(lblBankName);
		
		textFieldBank = new JTextField();
		textFieldBank.setBounds(275, 42, 300, 30);
		panel_3.add(textFieldBank);
		textFieldBank.setColumns(10);
		
		JLabel lblAccHolderName = new JLabel("ACC. HOLDER NAME");
		lblAccHolderName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAccHolderName.setBounds(78, 92, 182, 30);
		panel_3.add(lblAccHolderName);
		
		textFieldBkname = new JTextField();
		textFieldBkname.setBounds(275, 92, 300, 30);
		panel_3.add(textFieldBkname);
		textFieldBkname.setColumns(10);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO.");
		lblAccountNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAccountNo.setBounds(78, 142, 182, 30);
		panel_3.add(lblAccountNo);
		
		textFieldaccno = new JTextField();
		textFieldaccno.setBounds(275, 142, 300, 30);
		panel_3.add(textFieldaccno);
		textFieldaccno.setColumns(10);
		
		JLabel lblIfscCode = new JLabel("IFSC CODE");
		lblIfscCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIfscCode.setBounds(78, 192, 125, 30);
		panel_3.add(lblIfscCode);
		
		textFieldIfsc = new JTextField();
		textFieldIfsc.setBounds(275, 192, 150, 35);
		panel_3.add(textFieldIfsc);
		textFieldIfsc.setColumns(10);
		
		JButton btnNext_2 = new JButton("NEXT");
		btnNext_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNext_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNext_2.setBounds(232, 249, 125, 35);
		panel_3.add(btnNext_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		tabbedPane.addTab("CONFIRM SUBMISSION", new ImageIcon("C:\\Users\\AmanKumar\\Pictures\\ok.png"), panel_4, null);
		tabbedPane.setEnabledAt(4, true);
		panel_4.setLayout(null);
		
		JLabel lblToTheBest = new JLabel("TO THE BEST OF MY KNOWLEDGE.");
		lblToTheBest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblToTheBest.setBounds(60, 80, 339, 45);
		panel_4.add(lblToTheBest);
		
		final JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setEnabled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textFieldUser.getText().isEmpty() || textFieldName.getText().isEmpty() || textFieldDob.getText().isEmpty() || comboBox_4.getSelectedItem().toString().isEmpty() || textFieldMobile.getText().isEmpty() || textFieldEmail.getText().isEmpty() || comboBox_1.getSelectedItem().toString().isEmpty() || comboBox_2.getSelectedItem().toString().isEmpty() || comboBox_3.getSelectedItem().toString().isEmpty() || textFieldBank.getText().isEmpty() || textFieldBkname.getText().isEmpty() || textFieldaccno.getText().isEmpty() || textFieldIfsc.getText().isEmpty() 
							|| textFieldFlno.getText().isEmpty() || textFieldBrapt.getText().isEmpty() || textFieldStreet.getText().isEmpty() || textFieldCity.getText().isEmpty() || textFieldDistrict.getText().isEmpty() || textFieldPin.getText().isEmpty() || comboBox.getSelectedItem().toString().isEmpty() 
							)
					{
						JOptionPane.showMessageDialog(null, "Please Enter all the Details Properly.");
					}
					else
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "Pihu4418");
						Statement stmt=con.createStatement();
						String chk="Insert into cust values('"+textFieldUser.getText()+"','"+textFieldName.getText()+"','"+textFieldDob.getText()+"','"+comboBox_4.getSelectedItem().toString()+"','"+textFieldMobile.getText()+"','"+textFieldEmail.getText()+"','"+comboBox_1.getSelectedItem().toString()+"','"+comboBox_2.getSelectedItem().toString()+"','"+comboBox_3.getSelectedItem().toString()+"','"+textFieldBank.getText()+"','"+textFieldBkname.getText()+"','"+textFieldaccno.getText()+"','"+textFieldIfsc.getText()+"',null);";
						int rs=stmt.executeUpdate(chk);
						//System.out.println(rs);
						Statement stmt1=con1.createStatement();
						String adr="Insert into custaddr values('"+textFieldUser.getText()+"','"+textFieldFlno.getText()+"','"+textFieldBrapt.getText()+"','"+textFieldStreet.getText()+"','"+textFieldCity.getText()+"','"+textFieldDistrict.getText()+"','"+textFieldPin.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+textFieldMobile.getText()+"','"+textFieldEmail.getText()+"');";
						int rs1=stmt1.executeUpdate(adr);
						//System.out.println(rs1);
						if(rs==1 && rs1==1)
						{
								//stmt.executeUpdate(sql);
								JOptionPane.showMessageDialog(null,"Registration Successfull..!!!");
								
								textFieldName.setText(null);
								textFieldDob.setText(null);
								textFieldMobile.setText(null);
								textFieldEmail.setText(null);
								textFieldBank.setText(null);
								textFieldBkname.setText(null);
								textFieldaccno.setText(null);
								textFieldIfsc.setText(null);
								textFieldFlno.setText(null);
								textFieldBrapt.setText(null);
								textFieldStreet.setText(null);
								textFieldCity.setText(null);
								textFieldDistrict.setText(null);
								textFieldPin.setText(null);
								comboBox.setSelectedItem(null);
								comboBox_1.setSelectedItem(null);
								comboBox_2.setSelectedItem(null);
								comboBox_3.setSelectedItem(null);
								comboBox_4.setSelectedItem(null);
								//dispose();
								Cust ct=new Cust();
								ct.setVisible(true);
								ct.textField.setText(textFieldUser.getText());
								dispose();
								
								
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Error in Registration");
							//textFieldUserid.setText(null);
							
						}
						con.close();
						con1.close();
					}
				}catch(Exception e)
				{
					
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSubmit.setBounds(249, 201, 150, 39);
		panel_4.add(btnSubmit);
		
		final JCheckBox chckbxConfirm = new JCheckBox("I HERE BY DECLARE THAT ALL THE DATA MENTIONED IS TRUE ");
		chckbxConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxConfirm.isSelected())
				{
					btnSubmit.setEnabled(true);
				}
				else if(chckbxConfirm.isSelected()==false)
				{
					btnSubmit.setEnabled(false);
				}
			}
		});
		chckbxConfirm.setToolTipText("");
		chckbxConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxConfirm.setBounds(40, 50, 611, 45);
		panel_4.add(chckbxConfirm);
		
		
		textFieldUser = new JTextField();
		textFieldUser.setEditable(false);
		textFieldUser.setBounds(606, 11, 118, 28);
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
		btnBack.setBounds(10, 11, 100, 35);
		contentPane.add(btnBack);
	}
}
