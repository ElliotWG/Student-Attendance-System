package info;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	public static List<String> list2 = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 96, 698, 393);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String SQL ="SELECT * FROM ��¼��";
				
				
				
				
				
				
				ArrayList<Map<String, Object>> list = null;
				list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
				list2.clear();// ��תlist

				for (int i = 0; i < list.size(); i++) {
					String temp2, temp3, temp4, temp6, temp7, temp9, temp10, temp11, temp;
					int temp1, temp5;
					Date temp8;
					temp1 = (int) list.get(i).get("��¼��");
					temp2 = (String) list.get(i).get("ѧԺ");
					temp3 = (String) list.get(i).get("���");
					temp4 = (String) list.get(i).get("����");
					temp5 = (int) list.get(i).get("����");
					temp6 = (String) list.get(i).get("�γ�");
					temp7 = (String) list.get(i).get("��ʦ");
					temp8 = (Date) list.get(i).get("����");
					temp9 = (String) list.get(i).get("����");
					temp10 = (String) list.get(i).get("Υ��");
					temp11 = (String) list.get(i).get("��ע");
					temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5 + "," + temp6 + "," + temp7
							+ "," + temp8 + "," + temp9 + "," + temp10 + "," + temp11;
					// System.out.println(list.get(i).get("����"));
					list2.add(temp);
				}

				scrollPane.setViewportView(getTable2());
				//table.setRowSelectionInterval(l1, l2);// start select
			}
		});
		btnNewButton.setBounds(10, 38, 93, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("2016\r\n2017\r\n2018");
		comboBox.setBounds(163, 39, 82, 21);
		contentPane.add(comboBox);
	}
	
	private JTable getTable2() {
		DefaultTableModel model = null;
		if (table == null) { // ������Ƿ�Ϊ��.
			table = new JTable(); // �������ؼ�.
			table.setRowHeight(25); // �����и�.
			String[] columns = { "��¼��", "ѧԺ", "���", "����", "����", "�γ�", "��ʦ", "����", "����", "Υ��", "��ע" }; // ������������.
			// �������ģ��.
			model = new DefaultTableModel(columns, 0);
			table.setModel(model); // ���ñ��ģ��.
		} else {
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
		}
		List<String> students = getStudents(); // ���÷�������list���϶���.
		for (String info : students) { // ����ѧ�����϶���.
			String[] args = info.split(","); // ��ѧ����Ϣ���Ϊ����,���ݸ�args����.
			model.addRow(args);
		}
		return table;
	}

	private List<String> getStudents() {
		// ����list���϶���.
		// List<String> list=new ArrayList<String>();
		// ������ɣ���ʼ�������.
		return list2;
	}
}
