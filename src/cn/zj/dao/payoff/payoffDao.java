package cn.zj.dao.payoff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import cn.zj.JDBCUtils.JDBCUtils;
import cn.zj.domain.Department;
import cn.zj.domain.Payoff;
import cn.zj.domain.Person;
import cn.zj.domain.Project;

public class payoffDao {

	Connection con=null;
	PreparedStatement ps=null;
	public void insertpayoff(Payoff p) throws ClassNotFoundException, SQLException
	{
		
		//�������
		con= JDBCUtils.getConnection();
		
		String sql="insert into scientist_payoff values(?,?,?,?,?,?,?)";
		
	    //���Ԥ�������
		ps = con.prepareStatement(sql);
		
		ps.setInt(1,p.getPay_id());
		ps.setInt(5,p.getP_class());
		ps.setString(2, p.getPname());
		ps.setString(3, p.getCatagory());
		ps.setString(4, p.getRank());
		ps.setString(7, p.getTime());
	    ps.setInt(6, 0);
	    ps.executeUpdate();
	    //�ر�����
	    con.close();
	    ps.close();
	}
	
            
	public List<Payoff> selectpayoff() throws SQLException, ClassNotFoundException {
		       //�������
				con= JDBCUtils.getConnection();
			    
				List<Payoff> list=new LinkedList<Payoff>();
				
				String sql="select * from scientist_payoff";
				
			    //���Ԥ�������
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();

				
				while(rs.next())
				{
					Payoff p=new Payoff();
			        p.setPay_id(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setCatagory(rs.getString(3));
					p.setRank(rs.getString(4));
					p.setP_class(rs.getInt(5));
					p.setTime(rs.getString(7));
					p.setCer_num(rs.getInt(6));
				    list.add(p);
				}
			    //�ر�����
			    con.close();
			    ps.close();
			    
				return list;
		
	}


	public void delete(String id) throws ClassNotFoundException, SQLException {
		
		//�������
		con= JDBCUtils.getConnection();
		
		String sql="delete from scientist_payoff where pay_id=?";
		
	    //���Ԥ�������
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, Integer.parseInt(id));
		
	    ps.executeUpdate();
	    //�ر�����
	    con.close();
	    ps.close();
	}
}
