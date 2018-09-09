package cn.zj.dao.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zj.JDBCUtils.JDBCUtils;
import cn.zj.domain.Project;

public class UpdatePassword {


	Connection con=null;
	PreparedStatement ps=null;
	
	public void updatepassword(String p) throws ClassNotFoundException, SQLException {
		//�������
		con= JDBCUtils.getConnection();
		
		String sql="update admin set password=? where id=?";
		
		//���Ԥ�������
		ps = con.prepareStatement(sql);
		
	    ps.setString(1, p);
		ps.setInt(2, 1);
		
		ps.executeUpdate();
		//�ر�����
		con.close();
		ps.close();
		
	}

}
