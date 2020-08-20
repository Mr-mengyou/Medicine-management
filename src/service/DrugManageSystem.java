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
 * @desc: ҩ�������ܽӿ�
 **/
public interface DrugManageSystem {
	 //����ҩƷ
	 void addDrug(Drug drug);
	 
	 //ɾ��ҩƷ
	 void deleteDrug(String helpId);
	 
	 //�޸�ҩƷ
	 void updateDrug(Drug drug);
	 
	 
	 //�������ǺŲ�ѯ
	 Drug queryOne(String helpId);
	 
	 //��ѯȫ��
	 List<Drug> queryAll();
	 

     
     void sendDrugs(Patient patient);

	 List<DrugList> findNotSendDrug(String CaseId);

	 void updateStateOfSended(String caseId);
	 void updatePatientState(String caseId);

	Patient findPatientName(String CaseId);

	
	String login(String num,String password);
	void undateStateOfBacked(String drugscode);
     

	


}
