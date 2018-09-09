package cn.zj.web.department;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zj.domain.Department;
import cn.zj.domain.Person;
import cn.zj.service.scientistService;


public class addDepartmentServlet extends HttpServlet {
	 
		private scientistService service=new scientistService();
		
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Department d=new Department();
		
			try {
				//�������
				BeanUtils.populate(d, request.getParameterMap());
				
				System.out.println(d);
				//����service��
				service.adddepartment(d);
				
				//ת����ʾ�ɹ�
				request.getRequestDispatcher("/getDepartmentServlet").forward(request, response);
				
				
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
