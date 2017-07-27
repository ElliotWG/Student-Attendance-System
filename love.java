package info;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
	
public class love extends Db_List {
	
	
	public static void main(String[] args) throws SQLException {
		
		No1 frame=new No1();
		frame.setVisible(true);	 
		
		//load attandence 
		//ClassInfo frame=new ClassInfo();
		 //frame.setVisible(true);
		 
		
			 //窗口实例化.
			 /*Search frame=new Search();
			 frame.setVisible(true);*/
			  
		 
	/*
		 EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Input frame = new Input();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
*/
		// SQL = "INSERT INTO 学生表 VALUES('15115073222','shek','fdsklsfj','kfdsjfk','fs')";	
		// int  a;
		// a = Db_List.R_int(SQL);
		 //System.out.println(a);
	}
}
