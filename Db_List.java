package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Db_List {
	
	
	static java.util.List<Map<String,Object>> R_list(String SQL){
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 String urlserver = 
				 "jdbc:sqlserver://127.0.0.1:1433;databaseName=Attendance_info;user=sa;password=sa";  
		   Connection con = null;    
		   Statement stmt = null;    
		   ResultSet rs = null;
		   try 
		        {   
		            System.out.println("ready");    
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		            con = DriverManager.getConnection(urlserver);    
		            System.out.println("access");
		            stmt = con.createStatement(); 
		            rs = stmt.executeQuery(SQL);   
		            ResultSetMetaData md = rs.getMetaData(); 
		    		int columnCount = md.getColumnCount(); 
		    		while (rs.next()) {
		    			Map<String,Object> rowData = new HashMap<String,Object>();
		    			for (int i = 1; i <= columnCount; i++) {
		    				rowData.put(md.getColumnName(i), rs.getObject(i));
		    			}
		    			list.add(rowData);

		    	 }
		         
		        }//try 
		        catch (Exception e) 
		        {    
		            e.printStackTrace();    
		        }   
		        
		        finally 
		        {    
		  		  if (rs != null)    
		              try 
		              {    
		                  rs.close();    
		              }
		              catch (Exception e)
		              {    
		              } 
		            if (stmt != null)    
		                try 
		                {    
		                    stmt.close();    
		                }
		                catch (Exception e) 
		                {    
		                }    
		            if (con != null)    
		                try
		                {    
		                    con.close();    
		                } 
		                catch (Exception e)
		                {    
		                }    
		        }
				return list; 
}
	static int R_int(String SQL){
		
		 String urlserver = 
				 "jdbc:sqlserver://127.0.0.1:1433;databaseName=Attendance_info;user=sa;password=sa";  
		   Connection con = null;    
		   Statement stmt = null;    
		   int rs = 0;
		   try 
		        {   
		            System.out.println("ready");    
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		            con = DriverManager.getConnection(urlserver);    
		            System.out.println("access");
		            stmt = con.createStatement(); 
		            rs = stmt.executeUpdate(SQL);   
		         
		        }//try 
		        catch (Exception e) 
		        {    
		            e.printStackTrace();    
		        }   
		        
		        finally 
		        {    
		            if (stmt != null)    
		                try 
		                {    
		                    stmt.close();    
		                }
		                catch (Exception e) 
		                {    
		                }    
		            if (con != null)    
		                try
		                {    
		                    con.close();    
		                } 
		                catch (Exception e)
		                {    
		                }    
		        }
				return rs; 
}

}
