package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drug;
import bean.Patient;
import dao.DrugDao;
import dao.DrugDaoImpl;
import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import utils.JsonDateValueProcessor;

/**
 * Servlet implementation class ShowPatient
 */
@WebServlet("/ShowPatient")
public class ShowPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SendAndBackDao sendAndBackDao =new SendAndBackDaoImpl();
		List<Patient> patients =sendAndBackDao.ShowPatient();
		
//		request.setAttribute("drug", drugs);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		JsonConfig jsonConfig = new JsonConfig();   //JsonConfig��net.sf.json.JsonConfig�е������Ϊ�̶�д��  
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());  
		  
		JSONArray patientdata= JSONArray.fromObject(patients, jsonConfig);  
		
		  //��������������
		 /*���ñ��룬��ֹ������������*/
		response.setContentType("text/html; charset=utf-8"); 
		             /*�õ������*/
		 PrintWriter respWritter = response.getWriter();
		             /*��JSON��ʽ�Ķ���toString()����*/
		 respWritter.append(patientdata.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
