package cn.zj.web.login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.zj.domain.Admin;
import cn.zj.domain.Payoff;
import cn.zj.service.scientistService;

public class loginServlet extends HttpServlet {
	
			private scientistService service=new scientistService();
			private Admin admin=null;
			
			public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				    Admin a=new Admin();
			        HttpSession session = request.getSession();
				
			      try {
					//�������
					BeanUtils.populate(a, request.getParameterMap());
					
		            String checkFromImg =(String) session.getAttribute("checkcode_session");
					
					String checkFromJsp = request.getParameter("txtcode");
					
					if(checkFromImg.equals(checkFromJsp))
					{
						//����service��
						admin = service.login(a);	
						
					}else {
						
						request.setAttribute("checkcode", "��֤����������");
						
						request.getRequestDispatcher("login.jsp").forward(request, response);
					
					}
					
					
					if(admin!=null)
					{			
						session.setAttribute("admin", admin.getName());
						//ת����ʾ�ɹ�
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}else {
						
						//�����������
						request.setAttribute("loginerror","�û�����������������������������");
						request.getRequestDispatcher("login.jsp").forward(request,response);
					}
					
					
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
