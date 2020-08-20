/**
 * 
 */
package test;



import java.util.List;

import org.junit.Test;

import com.mysql.cj.conf.ConnectionUrl.Type;

import bean.Drug;
import bean.Patient;
import dao.DrugDao;
import dao.DrugDaoImpl;
import dao.SendAndBackDao;
import dao.SendAndBackDaoImpl;
import net.sf.json.JSONArray;
import service.DrugManageSystem;
import service.DrugManagerSystemImpl;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ������ɾ�Ĳ�
 **/
public class DrugDaoTest {

	/**
	 * @param args
	 */
		DrugDao drugDao = new DrugDaoImpl();
		DrugManageSystem sd = new DrugManagerSystemImpl();
		
		
		/**
		 * ����ҩƷ
		 */
//		@Test
//		public void testAdd() {
//			
//			Drug drug = new Drug();
//			
//			drug.setCode("12123");
//			drug.setName("ͷ��");
//			drug.setSpec("1֧");
//			drug.setUnit("֧");
//			drug.setType("��ҩ");
//			drug.setPrice(12);
//			drug.setHelpId("KK");
////			drug.setSpec("20");
////			drug.setUnit("Ƭ");
////			drug.setPrice(20);
//			
//			
//			drugDao.add(drug);
//		System.out.println("finish");
//		}
		
		
		

		
		/**
		 * �޸�
		 */
//		@Test
//		public void testUpdate(){
//			Drug drug = new Drug();
//			
//			drug.setName("����");
//			drug.setCode("978");
//			drug.setHelpId("800");
//			drug.setSpec("12");
//			drug.setUnit("1");
//			drug.setPrice(99999);
//			drugDao.update(drug);
//			System.out.println("finish");
//		}
		
		
//		/**
//		 * ɾ������
//		 */
//		@Test
//		public void testDelete(){
//			drugDao.delete("800");
//			System.out.println("finish");
//		}
//		/**
//		 * ��ʾ����ҩƷ��Ϣ
//		 */
		@Test
		public void testQueryAll(){
//			DrugDao drugDao = new DrugDaoImpl();
			List<Drug> drugs = drugDao.queryAll();
			JSONArray data = JSONArray.fromObject(drugs);
			System.out.println(data);

////			
//			System.out.println(drugs);
			
//
//			for(int i = 0;i<drugs.size();i++)
//			{
//				System.out.println(drugs.get(i).getName());
//			}
			
//			Iterator<Drug> iterable = drugs.iterator();
//			while(iterable.hasNext())
//			{
//				System.out.println(iterable.next());
//			}


		}
//		
//		/**
//		 * �����������ȡ
//		 */
//		@Test
//		public void testQueryOne(){
//			String helpid = "900";
//			Drug drug = drugDao.queryOne(helpid);
//			System.out.println(drug);
//		}
		
		/**
		 * ��ҩ
		 */
//		@Test
//		public void testSenddrug()
//		{
//			Patient patient =new Patient();
//			patient.setIsTakeMedicine("δ��");
//			patient.setCaseId("202002250002");
//			sd.sendDrugs(patient);
//			
//		}

}
