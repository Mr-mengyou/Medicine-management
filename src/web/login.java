package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java_cup.internal.runtime.Symbol;

import dao.LoginDao;
import dao.LoginDaoImpl;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	private void log(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDaoImpl();
		String number = request.getParameter("username");
		System.out.println(number);
		String password = request.getParameter("password");
		System.out.println(password);
		String res = loginDao.Login(number,password);
		System.out.println(res);
		String type = loginDao.findTypeByNum(number);
		System.out.println(type);
		if (res!="error") {
			request.getSession().setAttribute("user", res);
			request.getSession().setAttribute("type", type);
			response.setContentType("text/html; charset=utf-8"); 
			System.out.println(res);
	        /*得到输出流*/
	        PrintWriter respWritter = response.getWriter();
	        /*将JSON格式的对象toString()后发送*/
	        String rString = type+"      "+":"+"     "+res;
	        respWritter.append(rString);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
//		String pathinfo = request.getPathInfo();
		System.out.println(uri);
		String requestpath = uri.substring(uri.lastIndexOf("/")+1);
		if(requestpath.equals("login"))
		{
			log(request,response);
		}
		
	}

}
