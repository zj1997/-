package cn.zj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class test {
/**
 * ����jdbc�������ݿ�
 * @throws ClassNotFoundException 
 * @throws SQLException 
 * 
 * 
 */
	
	 @Test
	public void fun() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		
		//ע������
	    Class.forName("com.mysql.jdbc.Driver");
		
	    //�������
	    con= DriverManager.getConnection("jdbc:mysql://localhost/scientistproject", "root", "199715");
		//����sql���
	    //String sql="insert into project values(?,?,?,?,?,?,null)";
	    String sql ="select * from project";
	    ps=con.prepareStatement(sql);
	    
//		ps.setInt(1, 1);
//		ps.setString(2, "zhaojie");
//	    ps.setString(3, "arg1");
//	    ps.setDouble(4, 12);
//	    ps.setString(5, "arg1");
//	    ps.setString(6, "arg1");
	    
	    //int executeUpdate = ps.executeUpdate();
	    
	     rs = ps.executeQuery();
	     
	     while(rs.next())
	     {
	    	 System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getString(5)+rs.getString(6));
	     }
	    
	}
	
	
}
