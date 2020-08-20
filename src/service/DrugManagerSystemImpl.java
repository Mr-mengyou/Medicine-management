/**
 * 
 */
package service;
import dao.*;
import java.util.List;

import bean.Drug;
import bean.DrugList;
import bean.Patient;
import dao.DrugDao;
import dao.SendAndBackDao;
import service.DrugManageSystem;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 
 **/
public class DrugManagerSystemImpl implements DrugManageSystem {

	/**
	 * 
	 */
	LoginDao loginDao = new LoginDaoImpl();
	DrugDao drugDao = new DrugDaoImpl();
	SendAndBackDao sAndBackDao = new SendAndBackDaoImpl();
	
	public DrugManagerSystemImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#addDrug(com.zhn.bean.Drug)
	 */
	@Override
	public void addDrug(Drug drug) {
		// TODO Auto-generated method stub
		drugDao.add(drug);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#deleteDrug(java.lang.Integer)
	 */
	@Override
	public void deleteDrug(String helpId) {
		// TODO Auto-generated method stub
		drugDao.delete(helpId);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#updateDrug(com.zhn.bean.Drug)
	 */
	@Override
	public void updateDrug(Drug drug) {
		// TODO Auto-generated method stub
		drugDao.update(drug);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#queryOne(java.lang.Integer)
	 */
	@Override
	public Drug queryOne(String helpId) {
		// TODO Auto-generated method stub
		return drugDao.queryOne(helpId);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#queryAll()
	 */
	@Override
	public List<Drug> queryAll() {
		// TODO Auto-generated method stub
		return drugDao.queryAll();
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#findNotSendDrug(java.lang.String, java.lang.String)
	 */
	@Override
	public List<DrugList> findNotSendDrug(String caseId) {
		// TODO Auto-generated method stub
		return sAndBackDao.findNotSendDrug(caseId);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#updateStateOfSended(java.lang.String)
	 */
	@Override
	public void updateStateOfSended(String drugscode) {
		// TODO Auto-generated method stub
		sAndBackDao.updateStateOfSended(drugscode);
	}
	
	

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#findPatientName(java.lang.String)
	 */
	@Override
	public Patient findPatientName(String CaseId) {
		// TODO Auto-generated method stub
		return sAndBackDao.findPatientName(CaseId);
	}

	/* (non-Javadoc)
	 * @see com.zhn.service.DrugManageSystem#undateStateOfBacked(java.lang.String)
	 */
	@Override
	public void sendDrugs(Patient patient) {
		// TODO Auto-generated method stub
		
	}
	
	//²Ù×÷Ô±µÇÂ¼
		@Override
	public String login(String num, String password) {
			// TODO Auto-generated method stub
		return loginDao.Login(num, password);
	}



		@Override
		public void updatePatientState(String caseId) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void undateStateOfBacked(String drugscode) {
			// TODO Auto-generated method stub
			
		}

		
	
}
