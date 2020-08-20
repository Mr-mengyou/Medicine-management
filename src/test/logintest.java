package test;

import bean.Operator;
import dao.LoginDao;
import dao.LoginDaoImpl;
import org.junit.Test;

public class logintest {
	
	@Test
	public void testLogin() {
		// TODO Auto-generated constructor stub
		LoginDao loginDao = new LoginDaoImpl();
//		String num = "admin";
//		String pass = "123";
//		String res = loginDao.Login(num,pass);
//		System.out.println(res);
		
		String num ="201744111";
		String aString = loginDao.findTypeByNum(num);
		System.out.println(aString);
		
	}
	

}
