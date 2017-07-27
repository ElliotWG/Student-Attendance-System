package info;

//激活事件类库.
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

//集合类库.
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//窗口类库.
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Search extends JFrame implements TableModelListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	public static List<String> list2 = new ArrayList<String>();
	public static List<String> list1 = new ArrayList<String>();
	private JTextField textField;	
	

	// 构造方法.
	public Search() {
		// 窗口系列.
		super();
		setTitle("练习表格和List集合");
		setBounds(100, 100, 766, 569);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 容器系列.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 699, 427);
		contentPane.add(scrollPane);
		// scrollPane.setViewportView(getTable());

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 94, 699, 427);
		contentPane.add(scrollPane_1);

		JButton btnReadStudent = new JButton("read student");
		btnReadStudent.setBounds(232, 16, 129, 23);
		btnReadStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Search_student();

				scrollPane_1.setViewportView(getTable());
				scrollPane_1.setVisible(true);
				scrollPane.setVisible(false);
				
				table.addKeyListener(new KeyAdapter() {
		            @Override
		            public void keyReleased(KeyEvent e) {
		            	
		            	int row = table.getSelectedRow();
		            	String S_number,S_colleges,S_class,S_name,S_positon;
		            	S_number = (String) table.getValueAt(row, 0);
		            	S_colleges = (String) table.getValueAt(row, 1);
		            	S_class = (String) table.getValueAt(row, 2);
		            	S_name = (String) table.getValueAt(row, 3);
		            	S_positon = (String) table.getValueAt(row, 4);
		            	
		            	String SQL = "delete from 学生表  where 学号='"+S_number+"'";
		            	int a;
		        		a = Db_List.R_int(SQL);
		        		if(a>0){
		        		    System.out.println("删除成功");
		        		}
		            	SQL = "INSERT INTO 学生表 VALUES('"+S_number+"','"+S_colleges+"','"+S_name+"','"+S_class+"','"+S_positon+"')";	
		            	a = Db_List.R_int(SQL);
		            	if(a>0){
		            		System.out.println("修改成功");
		        		}
		        			            
		                
		            }
		        });
			

				// PanescrollPane.setViewportView(getTable());
				// ClassInfo cs = new ClassInfo();

				// table.setRowSelectionInterval(0, 0);// start select

			}
		});
		contentPane.add(btnReadStudent);

		JButton btnNewButton = new JButton("read record");
		btnNewButton.setBounds(232, 49, 129, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
		
				
				Search_record();
				scrollPane.setViewportView(getTable2());

				scrollPane.setVisible(true);
				scrollPane_1.setVisible(false);

				
				
				table2.addKeyListener(new KeyAdapter() {
		            @Override
		            public void keyReleased(KeyEvent e) {
		            	
		            	int row = table2.getSelectedRow();
		            	Object tem  = table2.getValueAt(row, 0);
		            	String tem2 = tem.toString();
		            	int R_record = Integer.parseInt(tem2);
		            	String R_colleges = (String) table2.getValueAt(row, 1);
		            	String R_class = (String) table2.getValueAt(row, 2);
		            	String R_week = (String) table2.getValueAt(row, 3);
		            	Object tem3  = table2.getValueAt(row, 4);
		               	String tem4 = tem3.toString();
		               	int R_time = Integer.parseInt(tem4);
		            	String R_corse = (String) table2.getValueAt(row, 5);
		            	String R_teacher = (String) table2.getValueAt(row, 6);
		            	String R_date = (String) table2.getValueAt(row, 7);
		            	String R_name = (String) table2.getValueAt(row, 8);
		            	String R_status = (String) table2.getValueAt(row, 9);
		            	String R_remarks = (String) table2.getValueAt(row, 10);
		    	
		            	String SQL = "delete from 记录表  where 记录号="+R_record;
		            	int a;
		        		a = Db_List.R_int(SQL);
		        		if(a>0){
		        		    System.out.println("删除成功");
		        		}
		            	SQL = "INSERT INTO 记录表 VALUES('" + R_record + "','" + R_colleges + "','" + R_class + "','"
		        				+ R_week + "','" + R_time + "','" + R_corse + "','" + R_teacher + "','" + R_date + "','"
		        				+ R_name + "','" + R_status + "','" + R_remarks + "')";
		            	a = Db_List.R_int(SQL);
		            	if(a>0){
		            		System.out.println("修改成功");
		        		}
		        			            
		                
		            }
		        });
				
				
				
				
				// ClassInfo cs = new ClassInfo();

				// table2.setRowSelectionInterval(0, 0);// start select
			}
		});

		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(26, 36, 196, 21);
		contentPane.add(textField);
		textField.setColumns(10);

	}

	public void Search_student(){
		
		String temp0 = textField.getText();
		String SQL;
		String B = "all";
		if(temp0.equals(B)){
			SQL = "SELECT * FROM 学生表";
		}else{
			SQL = "SELECT * FROM 学生表 WHERE 学号='"+temp0+"' OR 学院='"+temp0+"' OR 姓名='"+temp0+"' OR 班别='"+temp0+"' OR 职位='"+temp0+"'";
		}
 		ArrayList<Map<String, Object>> list3 = null;
		//list2 = null;
		list3 = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		list2.clear();// 中转list

		for (int i = 0; i < list3.size(); i++) {
			String temp1, temp2, temp3, temp4, temp5, temp;
			temp1 = (String) list3.get(i).get("学号");
			temp2 = (String) list3.get(i).get("学院");
			temp3 = (String) list3.get(i).get("姓名");
			temp4 = (String) list3.get(i).get("班别");
			temp5 = (String) list3.get(i).get("职位");
			temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5;
			// System.out.println(list.get(i).get("姓名"));
			list2.add(temp);
		}
	}

	public void Search_record(){
		
		String temp0 = textField.getText();
		String SQL;
		String B = "all";
		if(temp0.equals(B)){
			SQL = "SELECT * FROM 记录表";
		}else{
			SQL = "SELECT * FROM 记录表 WHERE 违纪='" + temp0 + "' OR 学院='" + temp0 + "' OR 班别='" + temp0
					+ "' OR 周数='" + temp0 + "' OR 备注='" + temp0 + "' OR 课程='" + temp0 + "' OR 老师='" + temp0
					+ "' OR 姓名='" + temp0 + "'";
		}
		
		
		ArrayList<Map<String, Object>> list = null;
		// list1 = null;
		list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		list1.clear();// 中转list

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
			list1.add(temp);
		}
	}
	// getTable()方法代码.
	private JTable getTable() {
		DefaultTableModel model2 = null;
		if (table == null) { // 检查表格是否为空.
			table = new JTable(); // 创建表格控件.
			table.setRowHeight(25); // 设置行高.
			String[] columns = { "学号", "学院", "姓名", "班别", "职位" }; // 创建列名数组.
			// 创建表格模型.
			model2 = new DefaultTableModel(columns, 0);
			table.setModel(model2); // 设置表格模型.
		} else {
			model2 = (DefaultTableModel) table.getModel();
			model2.setRowCount(0);
		}
		List<String> students = getStudents(); // 利用方法传递list集合对象.
		for (String info : students) { // 遍历学生集合对象.
			String[] args = info.split(","); // 把学生信息拆分为数组,传递给args数组.
			model2.addRow(args);
		}
		return table;
	}

	private JTable getTable2() {
		DefaultTableModel model = null;
		if (table2 == null) { // 检查表格是否为空.
			table2 = new JTable(); // 创建表格控件.
			table2.setRowHeight(25); // 设置行高.
			String[] columns = { "记录号", "学院", "班别", "周数", "节数", "课程", "老师", "日期", "姓名", "违纪", "备注" }; // 创建列名数组.
			// 创建表格模型.
			model = new DefaultTableModel(columns, 0);
			table2.setModel(model); // 设置表格模型.
		} else {
			model = (DefaultTableModel) table2.getModel();
			model.setRowCount(0);
		}
		List<String> students = getStudents2(); // 利用方法传递list集合对象.
		for (String info : students) { // 遍历学生集合对象.
			String[] args = info.split(","); // 把学生信息拆分为数组,传递给args数组.
			model.addRow(args);
		}
		return table2;
	}

	// getStudents()方法代码.
	private List<String> getStudents() {
		// 创建list集合对象.
		List<String> list = new ArrayList<String>();
		// 创建完成，开始添加数据.

		return list2;
	}

	private List<String> getStudents2() {
		// 创建list集合对象.
		List<String> list = new ArrayList<String>();
		// 创建完成，开始添加数据.

		return list1;
	}

	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	

	
	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
}
