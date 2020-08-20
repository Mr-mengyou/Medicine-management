package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Drug;
import dao.DrugDao;
import dao.DrugDaoImpl;

/**
 * Servlet implementation class delteDrug
 */
@WebServlet("/DelteDrug")
public class DelteDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelteDrug() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		if (session.getAttribute("user")!=null) {
			if (session.getAttribute("type").equals("发退药员")) {
				System.out.println(session.getAttribute("type"));
				String flag = "2";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
	           /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);
			} else {
				DrugDao drugDao = new DrugDaoImpl();
				String[] ids = request.getParameterValues("checkID");
				System.out.println(ids);
				String id = request.getParameter("id");
				if (ids!=null) {
					for (String id2 : ids) {
						drugDao.delete(id2);
					}
				}
				else{
					drugDao.delete(id);
					
				}	
				String flag = "1";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
				             /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);
				
		}
			}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
