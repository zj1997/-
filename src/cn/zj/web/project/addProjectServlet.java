package cn.zj.web.project;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zj.domain.Project;
import cn.zj.service.scientistService;

public class addProjectServlet extends HttpServlet {
    
	private scientistService service=new scientistService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Project p=new Project();
	
		try {
			//获得数据
			BeanUtils.populate(p, request.getParameterMap());
			
			System.out.println(p);
			//传给service层
			service.addproject(p);
			
			//转发表示成功
			request.getRequestDispatcher("/getProjectServlet").forward(request, response);
			
			
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
