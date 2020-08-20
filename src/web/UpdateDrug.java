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
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UpdateDrug
 */
@WebServlet("/UpdateDrug")
public class UpdateDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";
//	String method =  Request.getMethod();
	 
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDrug() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			request.setCharacterEncoding("utf-8");
			String helpid = request.getParameter("helpid");
			DrugDao drugDao = new DrugDaoImpl();
			System.out.println(helpid);
			Drug drugs = drugDao.queryOne(helpid);
			JSONArray d = JSONArray.fromObject(drugs);
			  //接下来发送数据
			 /*设置编码，防止出现乱码问题*/
			
			             /*得到输出流*/
			response.setContentType("text/html; charset=utf-8");   
			request.setAttribute("d", d);
			request.getRequestDispatcher("update_drug.jsp").forward(request, response);
		
		
//		
		 
	
		
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
			} 
			else{
				Drug drug = new Drug();
				DrugDao drugDao = new DrugDaoImpl();
				String id =request.getParameter("drugid");
				String code = request.getParameter("durgcode");
				String name = request.getParameter("durgname");
				String spec = request.getParameter("drugspec");
				String unit = request.getParameter("drugunit");
				String helpid = request.getParameter("drughelpid");
				String price = request.getParameter("drugprice");
//				System.out.println(helpid);//已经接收到了修改过后的数据
				drug.setId(id);
				drug.setCode(code);
				drug.setName(name);
				drug.setSpec(spec);
				drug.setUnit(unit);
				drug.setHelpId(helpid);
				drug.setPrice(Double.parseDouble(price));
//				System.out.println(drug.getUnit());//已经接收到了修改过后的数据
				System.out.println(drug);
				drugDao.update(drug);  
				String flag = "1";
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter respWritter = response.getWriter();
		       /*将JSON格式的对象toString()后发送*/
				respWritter.append(flag);
			}
		}
		
		
	}

}
