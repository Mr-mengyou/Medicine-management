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
 * Servlet implementation class AddDrug
 */
@WebServlet("/AddDrug")
public class AddDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrug() {
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
			if (session.getAttribute("type").equals("发退药员")) {
				System.out.println(session.getAttribute("type"));
				String flag = "2";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
	           /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);
			} else {
				Drug drug = new Drug();
				DrugDao drugDao = new DrugDaoImpl();
				
				String code = request.getParameter("durgcode");
				String name = request.getParameter("durgname");
				String spec = request.getParameter("drugspec");
				String unit = request.getParameter("drugunit");
				String helpid = request.getParameter("drughelpid");
				String price = request.getParameter("drugprice");
				
				drug.setCode(code);
				drug.setName(name);
				drug.setSpec(spec);
				drug.setUnit(unit);
				drug.setHelpId(helpid);
				drug.setPrice(Double.parseDouble(price));
				drugDao.add(drug);
				
				String flag = "1";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
	           /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);

			}
		}
		
		
		
		
			
		
		
		
	}

}
