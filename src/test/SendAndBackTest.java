/**
 * 
 */
package test;


import java.util.List;

import org.junit.Test;


import bean.Drug;
import bean.DrugList;
import bean.Patient;
import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 
 **/
public class SendAndBackTest {

	/**
	 * 
	 */
	SendAndBackDao sendAndBackDao = new SendAndBackDaoImpl();
	
	
//	@Test
//	public void testfindNotSendDrug(){
//		String caseId = "202002250002";
//		String Time = "";
//		List<DrugList> dList = sendAndBackDao.findNotSendDrug(caseId, Time);
//		for (DrugList druglist : dList) {
//			System.out.println(druglist);
//		}
//	}
//	@Test
//	public void findpatient()
//	{
//		String caseid = "202002250002";
//		Patient patient = sendAndBackDao.findPatientName(caseid);
//		System.out.println(patient);
//	}
	
//	@Test
//	public void finddrug()
//	{
//		String caseid = "202002250002";
//		List<DrugList> drugList =sendAndBackDao.findNotSendDrug(caseid);
//		System.out.println(drugList);
//	}
	
//	@Test
//	public void updatestatus(){
//		String drugcode = "86979474000208";
//		sendAndBackDao.updateStateOfSended(drugcode);
//	}
	
	@Test
	public void test(){
		String caseid = "202002250002";
		sendAndBackDao.updatePatientState(caseid);
	}
	
	
//	@Test
//	public void updatestatus2(){
//		String caseid = "202002250002";
//		
//		sendAndBackDao.updateStateOfPaitent(caseid);
//	}
	

}
