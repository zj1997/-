package cn.zj.web.department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zj.domain.Department;
import cn.zj.domain.Person;
import cn.zj.service.scientistService;


public class getDepartmentServlet extends HttpServlet {


    private scientistService service=new scientistService();
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   try {
			
			   //�����ݿ��ж�ȡ����
			  List<Department> departments = service.getdepartment();
			    
			
			  request.setAttribute("list",departments);
			
			  //ת����list.jspҳ��
			  request.getRequestDispatcher("jsp/department/list.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	
}
