package web;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import bean.Drug;
import dao.DrugDao;
import dao.DrugDaoImpl;
import net.sf.json.JSONArray;
import service.DrugManageSystem;
import service.DrugManagerSystemImpl;

/**
 * Servlet implementation class GetAllDrugInfo
 */
@WebServlet("/FindDrugInfo")
public class FindDrugInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDrugInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String helpId = request.getParameter("helpid");
		DrugDao drugDao = new DrugDaoImpl();
		System.out.println(helpId);
		Drug drugs = drugDao.queryOne(helpId);
		JSONArray d = JSONArray.fromObject(drugs);
		  //��������������
		 /*���ñ��룬��ֹ������������*/
		response.setContentType("text/html; charset=utf-8"); 
		             /*�õ������*/
//		PrintWriter respWritter = response.getWriter();
//		             /*��JSON��ʽ�Ķ���toString()����*/
//		respWritter.append(d.toString());
		request.setAttribute("d", d);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
