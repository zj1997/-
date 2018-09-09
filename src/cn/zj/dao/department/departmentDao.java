package cn.zj.dao.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.zj.JDBCUtils.DBUtils;
import cn.zj.JDBCUtils.JDBCUtils;
import cn.zj.domain.Department;
import cn.zj.domain.Person;
import cn.zj.domain.Project;

public class departmentDao {

	Connection con=null;
	PreparedStatement ps=null;
	public void insertdepartment(Department p) throws ClassNotFoundException, SQLException
	{
		//�������
		con= JDBCUtils.getConnection();
		try {
		
			con.setAutoCommit(false);
			
			String sql="insert into department values(?,?,?,?,?,?)";
			
		    //���Ԥ�������
			ps = con.prepareStatement(sql);
			
			ps.setInt(1,p.getDepartment_id());
			ps.setInt(5,p.getPostcode());
			ps.setInt(6,p.getTelephone());
			ps.setString(2, p.getD_name());
			ps.setString(4, p.getAddress());
			ps.setString(3, p.getRole_man());
		
		    ps.executeUpdate();
		    //�����ύ
		    con.commit();
	    
		}catch(Exception e)
		{
			//����ع�
			con.rollback();
			
			e.printStackTrace();
		
		}finally {
			
			//�ر�����
			con.close();
			ps.close();
		}
	}
	
            
	public List<Department> selectdepartment() throws SQLException, ClassNotFoundException {
		       //�������
				con= JDBCUtils.getConnection();
			    
		        List<Department> list=new LinkedList<Department>();
				
				
		        try {
					
		        	con.setAutoCommit(false);
		        	
		        	String sql="select * from department";
		        	
		        	//���Ԥ�������
		        	ps = con.prepareStatement(sql);
		        	
		        	ResultSet rs = ps.executeQuery();
		        	
		        	
		        	while(rs.next())
		        	{
		        		Department p=new Department();
		        		p.setDepartment_id(rs.getInt(1));
		        		p.setD_name(rs.getString(2));
		        		p.setRole_man(rs.getString(3));
		        		p.setAddress(rs.getString(4));
		        		p.setPostcode(rs.getInt(5));
		        		p.setTelephone(rs.getInt(6));
		        		list.add(p);
		        	}
		        	
		        	con.commit();
				} catch (Exception e) {
					
					con.rollback();
					e.printStackTrace();
				}
		        
			    //�ر�����
			    con.close();
			    ps.close();
			    
				return list;
		
	}


	public void delete(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//�������
		con= JDBCUtils.getConnection();
		
		try {
			
			con.setAutoCommit(false);
			
			String sql="delete from department where department_id=?";
			//���Ԥ�������
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(id));
			
			ps.executeUpdate();
               
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
			
			e.printStackTrace();
			
		}finally {
			
			//�ر�����
			con.close();
			ps.close();
			
		}	
	}
	
	
	//��id���в�ѯ
	public Department findbyId(Integer id) throws SQLException {
		
		System.out.println("dao"+id);
		
		String sql ="select * from department where department_id=?";
		
		Department q = DBUtils.getQuerrRunner().query(sql, new BeanHandler<Department>(Department.class),id);
		
		System.out.println(q);
		
		return q;
	}
	
	//��id���и���
     public void updatebyId(Department d) throws SQLException {
		
		
		String sql ="update department set department_id=?, d_name=?, role_man=?, address=?, postcode=?, telephone=? where department_id=?";
		
		   DBUtils.getQuerrRunner().update(sql,d.getDepartment_id(),d.getD_name(),d.getRole_man(),d.getAddress(),d.getPostcode(),d.getTelephone(),d.getDepartment_id());

	}
     
   //�����ƽ��и���
     public List<Department> querybyname(String name) throws SQLException {
		
		
		String sql ="select * from department where d_name like ?";
		
		return DBUtils.getQuerrRunner().query(sql,new BeanListHandler<Department>(Department.class),"%"+name+"%");

	}
	
	
}
