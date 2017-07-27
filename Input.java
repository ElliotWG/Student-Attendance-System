package info;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Input extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Input() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u5F55\u5165\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(20, 15, 60, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_1.setBounds(20, 60, 60, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(20, 105, 60, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u73ED\u522B\uFF1A");
		lblNewLabel_3.setBounds(20, 150, 60, 30);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u804C\u4F4D\uFF1A");
		lblNewLabel_4.setBounds(20, 195, 60, 30);
		contentPane.add(lblNewLabel_4);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u4FE1\u5DE5", "\u7269\u7535", "\u751F\u79D1",
				"\u4F53\u9662", "\u7F8E\u9662", "\u7ECF\u7BA1", "\u97F3\u4E50" }));
		comboBox.setBounds(80, 62, 117, 21);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setBounds(80, 20, 117, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		

		textField_1 = new JTextField();
		textField_1.setBounds(80, 107, 117, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(80, 152, 117, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(80, 200, 117, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//
				String S_number,S_colleges,S_class,S_name,S_positon;
				S_number = textField.getText();
				S_colleges = comboBox.getSelectedItem().toString();
				S_name = textField_1.getText();
				S_positon = textField_3.getText();
				S_class = textField_2.getText();
				String SQL = "INSERT INTO 学生表 VALUES('"+S_number+"','"+S_colleges+"','"+S_class+"','"+S_name+"','"+S_positon+"')";	
			    int  a;
				a = Db_List.R_int(SQL);
				JOptionPane.showMessageDialog(null, "Love", "也许这就是爱吧", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(262, 198, 93, 23);
		contentPane.add(btnNewButton);
	}
}
