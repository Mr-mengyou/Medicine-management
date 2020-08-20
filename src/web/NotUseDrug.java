package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DrugList;
import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class backdrug
 */
@WebServlet("/NotUseDrug")
public class NotUseDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotUseDrug() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String caseid = request.getParameter("caseid");
		SendAndBackDao sendAndBackDao = new SendAndBackDaoImpl();
		List<DrugList> dLists = sendAndBackDao.findBackableDruginfo(caseid);
		JSONArray datalist = JSONArray.fromObject(dLists);
		System.out.println(datalist);
		response.setContentType("text/html; charset=utf-8"); 
		 PrintWriter respWritter = response.getWriter();
		             /*将JSON格式的对象toString()后发送*/
		 respWritter.append(datalist.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
