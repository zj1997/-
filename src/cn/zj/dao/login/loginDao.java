package cn.zj.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.zj.JDBCUtils.JDBCUtils;
import cn.zj.domain.Admin;
import cn.zj.domain.Payoff;

public class loginDao {


	Connection con=null;
	PreparedStatement ps=null;

	public Admin selectlogin(Integer account) throws SQLException, ClassNotFoundException {
		       //�������
				con= JDBCUtils.getConnection();
			    
				Admin a=new Admin();
				
				String sql="select * from admin where account=?";
				
			    //���Ԥ�������
				ps = con.prepareStatement(sql);
				ps.setInt(1,account);
				
				ResultSet rs = ps.executeQuery();

				
				while(rs.next())//shit	
				{
					a.setId(rs.getInt(1));  	
					a.setName(rs.getString(3));
					a.setTelephone(rs.getInt(4));
					a.setPassword(rs.getString(5));
					a.setAccount(rs.getInt(2));				
				}
	
			    //�ر�����
			    con.close();
			    ps.close();
				return a;
		
	}
	
}
