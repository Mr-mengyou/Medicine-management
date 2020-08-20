package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DrugList;
import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class BackDrug
 */
@WebServlet("/BackDrug")
public class BackDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackDrug() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		if (session.getAttribute("user")!=null) {
			if (session.getAttribute("type").equals("录药员")) {
				System.out.println(session.getAttribute("type"));
				String flag = "2";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
	           /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);
			} 
			else{
				String[] ids = request.getParameterValues("checkID");
				for (String id : ids) {
					SendAndBackDao sendAndBackDao = new SendAndBackDaoImpl();
					sendAndBackDao.undateStateOfBacked(id);
				}
			String flag = "1";
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter respWritter = response.getWriter();
				             /*将JSON格式的对象toString()后发送*/
			respWritter.append(flag);
			}
		}
		
	}

}
