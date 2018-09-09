package cn.zj.web.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zj.domain.Project;
import cn.zj.service.scientistService;


public class getProjectServlet extends HttpServlet {

    private scientistService service=new scientistService();
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   try {
			
			   //�����ݿ��ж�ȡ����
			  List<Project> projects = service.getproject();
			    
			  request.setAttribute("list",projects);
			
			  //ת����list.jspҳ��
			  request.getRequestDispatcher("jsp/project/list.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
