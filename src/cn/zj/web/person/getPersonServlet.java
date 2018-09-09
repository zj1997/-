package cn.zj.web.person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zj.domain.Person;
import cn.zj.domain.Project;
import cn.zj.service.scientistService;


public class getPersonServlet extends HttpServlet {


    private scientistService service=new scientistService();
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   try {
			
			   //�����ݿ��ж�ȡ����
			  List<Person> persons = service.getperson();
			    
			  request.setAttribute("list",persons);
			
			  //ת����list.jspҳ��
			  request.getRequestDispatcher("jsp/person/list.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}