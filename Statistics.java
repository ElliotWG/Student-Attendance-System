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
				
				String SQL ="SELECT * FROM 记录表";
				
				
				
				
				
				
				ArrayList<Map<String, Object>> list = null;
				list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
				list2.clear();// 中转list

				for (int i = 0; i < list.size(); i++) {
					String temp2, temp3, temp4, temp6, temp7, temp9, temp10, temp11, temp;
					int temp1, temp5;
					Date temp8;
					temp1 = (int) list.get(i).get("记录号");
					temp2 = (String) list.get(i).get("学院");
					temp3 = (String) list.get(i).get("班别");
					temp4 = (String) list.get(i).get("周数");
					temp5 = (int) list.get(i).get("节数");
					temp6 = (String) list.get(i).get("课程");
					temp7 = (String) list.get(i).get("老师");
					temp8 = (Date) list.get(i).get("日期");
					temp9 = (String) list.get(i).get("姓名");
					temp10 = (String) list.get(i).get("违纪");
					temp11 = (String) list.get(i).get("备注");
					temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5 + "," + temp6 + "," + temp7
							+ "," + temp8 + "," + temp9 + "," + temp10 + "," + temp11;
					// System.out.println(list.get(i).get("姓名"));
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
		if (table == null) { // 检查表格是否为空.
			table = new JTable(); // 创建表格控件.
			table.setRowHeight(25); // 设置行高.
			String[] columns = { "记录号", "学院", "班别", "周数", "节数", "课程", "老师", "日期", "姓名", "违纪", "备注" }; // 创建列名数组.
			// 创建表格模型.
			model = new DefaultTableModel(columns, 0);
			table.setModel(model); // 设置表格模型.
		} else {
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
		}
		List<String> students = getStudents(); // 利用方法传递list集合对象.
		for (String info : students) { // 遍历学生集合对象.
			String[] args = info.split(","); // 把学生信息拆分为数组,传递给args数组.
			model.addRow(args);
		}
		return table;
	}

	private List<String> getStudents() {
		// 创建list集合对象.
		// List<String> list=new ArrayList<String>();
		// 创建完成，开始添加数据.
		return list2;
	}
}
