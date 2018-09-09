package cn.zj.service;

import java.sql.SQLException;
import java.util.List;

import cn.zj.dao.scientistDao;
import cn.zj.domain.Admin;
import cn.zj.domain.Department;
import cn.zj.domain.Payoff;
import cn.zj.domain.Person;
import cn.zj.domain.Project;

public class scientistService {

	private scientistDao dao=new scientistDao();
	
	//��Ŀ
	 public void addproject(Project p) throws ClassNotFoundException, SQLException {
	
	    dao.addproject(p);	
	}
	 
	 public List<Project> getproject() throws ClassNotFoundException, SQLException {
			
	      return dao.getproject();
	}

	//����
	public void adddepartment(Department d) throws ClassNotFoundException, SQLException {
	      dao.adddepartment(d);
	}
	
	public List<Department> getdepartment() throws ClassNotFoundException, SQLException {
		
	      return dao.getdepartment();
	}
    
	//���гɹ�
	public void addpayoff(Payoff p) throws ClassNotFoundException, SQLException {
	      dao.addpayoff(p);
	}
	
	public List<Payoff> getpayoff() throws ClassNotFoundException, SQLException {
		
	      return dao.getpayoff();
	}
	
	//��Ա
	public void addperson(Person p) throws ClassNotFoundException, SQLException {
	      dao.addperson(p);
	}
	
	public List<Person> getperson() throws ClassNotFoundException, SQLException {
		
	      return dao.getperson();
	}

	public Admin login(Admin a) throws ClassNotFoundException, SQLException{
		
		Admin admin=dao.login(a.getAccount());
		

        boolean flag=false;
		if(a.getAccount().equals(admin.getAccount())&&a.getPassword().equals(admin.getPassword())) 
		{
			flag=true;
		}
		
		if(flag) {
			return admin;
		}else {
			
		 return null;	
		}
	}

	//�޸�����
	public void updatepassword(String p) throws ClassNotFoundException, SQLException {
	
	   dao.updatepassword(p);	
	}

	//��Ŀ�ɹ�����
	public List<Payoff> rank() throws ClassNotFoundException, SQLException {
	
		List<Payoff> rank = dao.rank();
		return rank;
	}

	//ɾ��payoff
	public void deletepayoff(String id) throws ClassNotFoundException, SQLException {
		
		dao.deletepayoff(id);
	}
    //ɾ��department
	public void deletedepartment(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.deletedepartment(id);
	}
    //ɾ��person
	public void deleteperson(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.deletedeperson(id);
	}
    //ɾ��project
	public void deleteProject(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.deleteproject(id);
	}
	 
}
