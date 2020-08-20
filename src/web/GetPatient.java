package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Patient;

import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import utils.JsonDateValueProcessor;

/**
 * Servlet implementation class SendPatient
 */
@WebServlet("/GetPatient")
public class GetPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String caseid = request.getParameter("caseId");
		SendAndBackDao sendAndBackDao = new SendAndBackDaoImpl();
		Patient patient = sendAndBackDao.findPatientName(caseid);
        System.out.println(caseid);
		JsonConfig jsonConfig = new JsonConfig();   //JsonConfig是net.sf.json.JsonConfig中的这个，为固定写法  
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());  
		  
		JSONObject d = JSONObject.fromObject(patient, jsonConfig);  
		
//		JSONArray d = JSONArray.fromObject(patient);
		  //接下来发送数据
		 /*设置编码，防止出现乱码问题*/
		response.setContentType("text/html; charset=utf-8"); 
		
//		request.setAttribute("p", d);
//		request.getRequestDispatcher("getpatient.jsp").forward(request, response);
		
		             /*得到输出流*/
		PrintWriter respWritter = response.getWriter();
		             /*将JSON格式的对象toString()后发送*/
		respWritter.append(d.toString());
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
