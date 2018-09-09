package cn.zj.web.updateadmin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zj.service.scientistService;

public class updateadmin extends HttpServlet {

	private scientistService service =new scientistService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String p1 = request.getParameter("password1");
	    String p2 = request.getParameter("password2");
	    
	    if(p1.equals(p2))
	    {
	    	//�޸����ݿ�����
	    	try {
				service.updatepassword(p1);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	    	
	    	//�ض�����ҳ��
	    	
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    	
	    	
	    }else{
	    	//���������������벻һ��
	    	
	    	request.setAttribute("error","�����������벻һ�£�����¸����������룡����");
	    	request.getRequestDispatcher("jsp/updatepassword.jsp").forward(request, response);
	    }
	    
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
