package info;

//激活事件类库.
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.BorderLayout;
import java.util.Date;

//集合类库.
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

//窗口类库.
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXB;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassInfo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private int l1 = 0;
	private int l2 = 0;
	public int R_record;
	public String R_colleges;
	public String R_class;
	public String R_week;
	public int R_time;
	public String R_corse;
	public String R_teacher = null;
	public String R_date;
	public String R_name;
	public String R_status;
	public String R_remarks = null;
	public static List<String> list2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane = new JScrollPane();
	Speak sp = new Speak();
	
	// 构造方法.
	public ClassInfo() {
		
		
		// 窗口系列.
		super();
		
		setTitle("练习表格和List集合");
		setBounds(100, 100, 718, 448);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 容器系列.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		scrollPane.setBounds(21, 73, 390, 279);
		contentPane.add(scrollPane);

		// read student list
		JButton btnReadStudent = new JButton("Read student");
		btnReadStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String SQL = "SELECT * FROM 学生表";
				ArrayList<Map<String, Object>> list = null;
				list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
				list2 = new ArrayList<String>();// 中转list

				for (int i = 0; i < list.size(); i++) {
					String temp1, temp2, temp3, temp4, temp5, temp;
					temp1 = (String) list.get(i).get("学号");
					temp2 = (String) list.get(i).get("学院");
					temp3 = (String) list.get(i).get("姓名");
					temp4 = (String) list.get(i).get("班别");
					temp5 = (String) list.get(i).get("职位");
					temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5;
					// System.out.println(list.get(i).get("姓名"));
					list2.add(temp);
				}

				scrollPane.setViewportView(getTable());
				table.setRowSelectionInterval(l1, l2);// start select
				//tts speak
				int tts_temp0 = table.getSelectedRow();
				String tts_temp = (String) table.getValueAt(tts_temp0, 2);
				sp.speak_tts(tts_temp);

			}
		});
		btnReadStudent.setBounds(21, 40, 148, 23);
		contentPane.add(btnReadStudent);
		
		//旷课
		btnNewButton_3 = new JButton("\u65F7\u8BFE");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jiluhao();
				riqi();
				huoquhaoduo();		
				week();
				jieshu();
				kuangke();
				xieru();
			}
		});
		btnNewButton_3.setBounds(421, 217, 93, 23);
		contentPane.add(btnNewButton_3);
		
		//c迟到
		btnNewButton_4 = new JButton("\u8FDF\u5230");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jiluhao();
				riqi();
				huoquhaoduo();		
				week();
				jieshu();
				chidao();
				xieru();
			}
		});
		btnNewButton_4.setBounds(421, 243, 93, 23);
		contentPane.add(btnNewButton_4);
		
		//准点
		button = new JButton("\u51C6\u70B9");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jiluhao();
				riqi();
				huoquhaoduo();		
				week();
				jieshu();
				zhundian();
				xieru();
			}
		});
		button.setBounds(421, 271, 93, 23);
		contentPane.add(button);

		// 违纪 请假
		button_1 = new JButton("\u8BF7\u5047");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				jiluhao();
				riqi();
				huoquhaoduo();		
				week();
				jieshu();
				qingjia();
				xieru();
				
				
			}
		});
		button_1.setBounds(421, 191, 93, 23);
		contentPane.add(button_1);
		

	}
	
	public void riqi(){
		Date d = new Date();
		String s = null;
		s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		R_date = s;

		System.out.println("日期成功");
	}
	public void huoquhaoduo(){
		int row = table.getSelectedRow();
		R_colleges = (String) table.getValueAt(row, 1);
		R_class = (String) table.getValueAt(row, 2);
		R_name = (String) table.getValueAt(row, 3);
		System.out.println("huoaduodongxi suceess");
		// System.out.print(R_colleges+R_class+R_name);
		// System.out.println(table.getValueAt(row, 2));
	}
	public void xueshengbiao(){
		String SQL = "SELECT * FROM 学生表";
		ArrayList<Map<String, Object>> list = null;
		list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		list2 = new ArrayList<String>();// 中转list

		for (int i = 0; i < list.size(); i++) {
			String temp1, temp2, temp3, temp4, temp5, temp;
			temp1 = (String) list.get(i).get("学号");
			temp2 = (String) list.get(i).get("学院");
			temp3 = (String) list.get(i).get("姓名");
			temp4 = (String) list.get(i).get("班别");
			temp5 = (String) list.get(i).get("职位");
			temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5;
			// System.out.println(list.get(i).get("姓名"));
			list2.add(temp);
		}
		scrollPane.setViewportView(getTable());
		//PanescrollPane.setViewportView(getTable());
		ClassInfo cs = new ClassInfo();
		
		table.setRowSelectionInterval(l1, l2);// start select
	}
	public void jiluhao(){
		String SQL = "select top 1 * from 记录表 order by 记录号  desc";
		ArrayList<Map<String, Object>> list3 = null;
		list3 = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		int temp3 = list3.size() - 1;
		temp3 = (int) list3.get(temp3).get("记录号");
		temp3++;

		R_record = temp3;

		System.out.println("获取记录号成功");
	}
	public void week(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
		String str = "2017年02月20 00:00:00";
		Date date1 = null;
		try {
			date1 = format.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // str表示yyyy年MM月dd HH:mm:ss格式字符串
		Date date2 = new Date();

		int week1 = differentDaysByMillisecond(date1, date2);
		int week2 = week1 / 7 + 1;
		R_week = Integer.toString(week2);
		System.out.println("周数成功");
	}
	public void jieshu(){
		Date now2 = new Date();
		Calendar c = Calendar.getInstance();
		int H = c.get(Calendar.HOUR_OF_DAY);
		// int M = c.get(Calendar.MINUTE);
		if (H >= 8 && H < 10) {
			R_time = 12;
		}
		if (H >= 10 && H < 12) {
			R_time = 34;
		}
		if (H >= 14 && H < 16) {
			R_time = 56;
		}
		if (H >= 16 && H < 18) {
			R_time = 78;
		}
		if (H >= 19 && H < 21) {
			R_time = 90;
		}
		System.out.println("节数成功");
	}
	public void kuangke(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"旷课");
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "旷课";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("旷课成功");
	}
	public void zhundian(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"准点");
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "准点";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("qingjia");
	}
	public void chidao(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		
		sp.speak_tts(tts_temp+"迟到");
		
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "迟到";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("迟到成功");
	}
	public void xieru(){
		String SQL = "INSERT INTO 记录表 VALUES('" + R_record + "','" + R_colleges + "','" + R_class + "','"
				+ R_week + "','" + R_time + "','" + R_corse + "','" + R_teacher + "','" + R_date + "','"
				+ R_name + "','" + R_status + "','" + R_remarks + "')";
		int a;
		a = Db_List.R_int(SQL);
		System.out.println("插入成功");
	}
	public void qingjia(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"请假");
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1,l2);		
		R_status = "请假";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("请假成功");
		
	}
	

	
	// getTable()方法代码.
	private JTable getTable() {
		if (table == null) { // 检查表格是否为空.
			table = new JTable(); // 创建表格控件.
			table.setRowHeight(25); // 设置行高.
			String[] columns = { "学号", "学院", "姓名", "班别", "职位" }; // 创建列名数组.
			// 创建表格模型.
			DefaultTableModel model = new DefaultTableModel(columns, 0);
			table.setModel(model); // 设置表格模型.

			List<String> students = getStudents(); // 利用方法传递list集合对象.
			for (String info : students) { // 遍历学生集合对象.
				String[] args = info.split(","); // 把学生信息拆分为数组,传递给args数组.
				model.addRow(args);
			}

		}
		return table;
	}

	// getStudents()方法代码. get array[]
	private List<String> getStudents() {
		// 创建list集合对象.
		// List<String> list=new ArrayList<String>();
		// 创建完成，开始添加数据.
		return list2;
	}
	//日期相差天数
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}
}
