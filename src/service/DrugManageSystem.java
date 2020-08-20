/**
 * 
 */
package service;

import java.util.List;

import bean.Drug;
import bean.DrugList;
import bean.Patient;

/**
 * @project: DrugManageModel
 * @author: Zuohaonan
 * @date: 2020-2-25
 * @desc: 药房管理功能接口
 **/
public interface DrugManageSystem {
	 //增加药品
	 void addDrug(Drug drug);
	 
	 //删除药品
	 void deleteDrug(String helpId);
	 
	 //修改药品
	 void updateDrug(Drug drug);
	 
	 
	 //按照助记号查询
	 Drug queryOne(String helpId);
	 
	 //查询全部
	 List<Drug> queryAll();
	 

     
     void sendDrugs(Patient patient);

	 List<DrugList> findNotSendDrug(String CaseId);

	 void updateStateOfSended(String caseId);
	 void updatePatientState(String caseId);

	Patient findPatientName(String CaseId);

	
	String login(String num,String password);
	void undateStateOfBacked(String drugscode);
     

	


}
