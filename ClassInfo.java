package info;

//�����¼����.
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.BorderLayout;
import java.util.Date;

//�������.
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

//�������.
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
	
	// ���췽��.
	public ClassInfo() {
		
		
		// ����ϵ��.
		super();
		
		setTitle("��ϰ����List����");
		setBounds(100, 100, 718, 448);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����ϵ��.
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

				String SQL = "SELECT * FROM ѧ����";
				ArrayList<Map<String, Object>> list = null;
				list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
				list2 = new ArrayList<String>();// ��תlist

				for (int i = 0; i < list.size(); i++) {
					String temp1, temp2, temp3, temp4, temp5, temp;
					temp1 = (String) list.get(i).get("ѧ��");
					temp2 = (String) list.get(i).get("ѧԺ");
					temp3 = (String) list.get(i).get("����");
					temp4 = (String) list.get(i).get("���");
					temp5 = (String) list.get(i).get("ְλ");
					temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5;
					// System.out.println(list.get(i).get("����"));
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
		
		//����
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
		
		//c�ٵ�
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
		
		//׼��
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

		// Υ�� ���
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

		System.out.println("���ڳɹ�");
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
		String SQL = "SELECT * FROM ѧ����";
		ArrayList<Map<String, Object>> list = null;
		list = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		list2 = new ArrayList<String>();// ��תlist

		for (int i = 0; i < list.size(); i++) {
			String temp1, temp2, temp3, temp4, temp5, temp;
			temp1 = (String) list.get(i).get("ѧ��");
			temp2 = (String) list.get(i).get("ѧԺ");
			temp3 = (String) list.get(i).get("����");
			temp4 = (String) list.get(i).get("���");
			temp5 = (String) list.get(i).get("ְλ");
			temp = temp1 + "," + temp2 + "," + temp3 + "," + temp4 + "," + temp5;
			// System.out.println(list.get(i).get("����"));
			list2.add(temp);
		}
		scrollPane.setViewportView(getTable());
		//PanescrollPane.setViewportView(getTable());
		ClassInfo cs = new ClassInfo();
		
		table.setRowSelectionInterval(l1, l2);// start select
	}
	public void jiluhao(){
		String SQL = "select top 1 * from ��¼�� order by ��¼��  desc";
		ArrayList<Map<String, Object>> list3 = null;
		list3 = (ArrayList<Map<String, Object>>) Db_List.R_list(SQL);
		int temp3 = list3.size() - 1;
		temp3 = (int) list3.get(temp3).get("��¼��");
		temp3++;

		R_record = temp3;

		System.out.println("��ȡ��¼�ųɹ�");
	}
	public void week(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd HH:mm:ss");
		String str = "2017��02��20 00:00:00";
		Date date1 = null;
		try {
			date1 = format.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // str��ʾyyyy��MM��dd HH:mm:ss��ʽ�ַ���
		Date date2 = new Date();

		int week1 = differentDaysByMillisecond(date1, date2);
		int week2 = week1 / 7 + 1;
		R_week = Integer.toString(week2);
		System.out.println("�����ɹ�");
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
		System.out.println("�����ɹ�");
	}
	public void kuangke(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"����");
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "����";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("���γɹ�");
	}
	public void zhundian(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"׼��");
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "׼��";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("qingjia");
	}
	public void chidao(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		
		sp.speak_tts(tts_temp+"�ٵ�");
		
		
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1, l2);
		R_status = "�ٵ�";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("�ٵ��ɹ�");
	}
	public void xieru(){
		String SQL = "INSERT INTO ��¼�� VALUES('" + R_record + "','" + R_colleges + "','" + R_class + "','"
				+ R_week + "','" + R_time + "','" + R_corse + "','" + R_teacher + "','" + R_date + "','"
				+ R_name + "','" + R_status + "','" + R_remarks + "')";
		int a;
		a = Db_List.R_int(SQL);
		System.out.println("����ɹ�");
	}
	public void qingjia(){
		
		int tts_temp0 = table.getSelectedRow();
		String tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp+"���");
		
		l1 = table.getSelectedRow()+1;
		l2 = l1;
		table.setRowSelectionInterval(l1,l2);		
		R_status = "���";
		
		tts_temp0 = table.getSelectedRow();
		tts_temp = (String) table.getValueAt(tts_temp0, 2);
		sp.speak_tts(tts_temp);
		
		System.out.print("��ٳɹ�");
		
	}
	

	
	// getTable()��������.
	private JTable getTable() {
		if (table == null) { // ������Ƿ�Ϊ��.
			table = new JTable(); // �������ؼ�.
			table.setRowHeight(25); // �����и�.
			String[] columns = { "ѧ��", "ѧԺ", "����", "���", "ְλ" }; // ������������.
			// �������ģ��.
			DefaultTableModel model = new DefaultTableModel(columns, 0);
			table.setModel(model); // ���ñ��ģ��.

			List<String> students = getStudents(); // ���÷�������list���϶���.
			for (String info : students) { // ����ѧ�����϶���.
				String[] args = info.split(","); // ��ѧ����Ϣ���Ϊ����,���ݸ�args����.
				model.addRow(args);
			}

		}
		return table;
	}

	// getStudents()��������. get array[]
	private List<String> getStudents() {
		// ����list���϶���.
		// List<String> list=new ArrayList<String>();
		// ������ɣ���ʼ�������.
		return list2;
	}
	//�����������
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}
}
