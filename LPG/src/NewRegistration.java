import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
public class NewRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblDob;
	private JTextField textField_1;
	private JLabel lblDdmmyyyy;
	private JLabel lblGender;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRegistration frame = new NewRegistration();
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
	public NewRegistration() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourDetails = new JLabel("ENTER YOUR DETAILS");
		lblEnterYourDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterYourDetails.setBounds(201, 11, 301, 40);
		contentPane.add(lblEnterYourDetails);
		
		JLabel lblPersonalDetails = new JLabel("PERSONAL DETAILS");
		lblPersonalDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPersonalDetails.setBounds(10, 64, 200, 25);
		contentPane.add(lblPersonalDetails);
		
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFullName.setBounds(10, 93, 120, 25);
		contentPane.add(lblFullName);
		
		textField = new JTextField();
		textField.setBounds(142, 94, 400, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDob = new JLabel("D-O-B");
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDob.setBounds(10, 141, 120, 25);
		contentPane.add(lblDob);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 144, 120, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDdmmyyyy = new JLabel("dd-mm-yyyy");
		lblDdmmyyyy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDdmmyyyy.setBounds(272, 147, 69, 19);
		contentPane.add(lblDdmmyyyy);
		
		lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGender.setBounds(10, 181, 120, 25);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnMale.setBounds(142, 183, 109, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnFemale.setBounds(269, 183, 109, 23);
		contentPane.add(rdbtnFemale);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 218, 750, 2);
		contentPane.add(separator);
		
		JLabel lblContactDeatils = new JLabel("CONTACT DEATILS");
		lblContactDeatils.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContactDeatils.setBounds(10, 231, 200, 25);
		contentPane.add(lblContactDeatils);
		
		JLabel lblHouseflatNo = new JLabel("HOUSE/FLAT NO.");
		lblHouseflatNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHouseflatNo.setBounds(10, 267, 120, 25);
		contentPane.add(lblHouseflatNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 267, 175, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBuildingapt = new JLabel("BUILDING/APT.");
		lblBuildingapt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuildingapt.setBounds(366, 267, 120, 25);
		contentPane.add(lblBuildingapt);
		
		textField_3 = new JTextField();
		textField_3.setBounds(506, 270, 175, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStreetName = new JLabel("STREET NAME");
		lblStreetName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblStreetName.setBounds(10, 311, 120, 25);
		contentPane.add(lblStreetName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 314, 175, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCitytown = new JLabel("CITY/TOWN");
		lblCitytown.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCitytown.setBounds(366, 317, 120, 25);
		contentPane.add(lblCitytown);
		
		textField_5 = new JTextField();
		textField_5.setBounds(505, 314, 175, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDistrict = new JLabel("DISTRICT");
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDistrict.setBounds(10, 353, 120, 25);
		contentPane.add(lblDistrict);
		
		textField_6 = new JTextField();
		textField_6.setBounds(142, 354, 175, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblState.setBounds(10, 400, 120, 25);
		contentPane.add(lblState);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 401, 175, 25);
		contentPane.add(comboBox);
		
		JLabel lblPincode = new JLabel("PIN CODE");
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPincode.setBounds(366, 353, 120, 25);
		contentPane.add(lblPincode);
		
		textField_7 = new JTextField();
		textField_7.setBounds(506, 354, 175, 25);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMobileNo.setBounds(10, 443, 120, 25);
		contentPane.add(lblMobileNo);
		
		textField_8 = new JTextField();
		textField_8.setBounds(142, 443, 175, 25);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEmailid = new JLabel("EMAIL-ID");
		lblEmailid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmailid.setBounds(366, 443, 120, 25);
		contentPane.add(lblEmailid);
		
		textField_9 = new JTextField();
		textField_9.setBounds(506, 443, 175, 25);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 481, 750, 2);
		contentPane.add(separator_1);
		
		JLabel lblConnectionDetails = new JLabel("CONNECTION DETAILS");
		lblConnectionDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblConnectionDetails.setBounds(10, 496, 200, 25);
		contentPane.add(lblConnectionDetails);
		
		JLabel lblType = new JLabel("TYPE ");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblType.setBounds(10, 532, 120, 25);
		contentPane.add(lblType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(142, 532, 175, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblNoOfCylinder = new JLabel("NO. OF CYLINDER");
		lblNoOfCylinder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNoOfCylinder.setBounds(10, 575, 120, 25);
		contentPane.add(lblNoOfCylinder);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(142, 576, 175, 25);
		contentPane.add(comboBox_2);
		
		JLabel lblIfYouWant = new JLabel("IF YOU WANT SUBSIDY CHOOSE 'YES' ELSE CHOOSE 'NO'.");
		lblIfYouWant.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblIfYouWant.setBounds(10, 611, 500, 20);
		contentPane.add(lblIfYouWant);
		
		JLabel lblSubsidy = new JLabel("SUBSIDY");
		lblSubsidy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSubsidy.setBounds(10, 638, 120, 25);
		contentPane.add(lblSubsidy);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(142, 640, 125, 25);
		contentPane.add(comboBox_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 677, 750, 2);
		contentPane.add(separator_2);
		
		final JScrollBar scrollBar = new JScrollBar();
		scrollBar.setValueIsAdjusting(true);
		scrollBar.setMinimum(100);
		scrollBar.setMaximum(300);
		scrollBar.setUnitIncrement(10);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				scrollBar.getAutoscrolls();
			}
		});
		scrollBar.setBounds(735, 0, 24, 441);
		contentPane.add(scrollBar);
		
	}
}
