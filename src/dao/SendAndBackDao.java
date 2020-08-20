/**
 * 
 */
package dao;

import java.util.List;

import bean.DrugList;
import bean.Patient;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ����ҩ��ѯ������Ϣ���ܽӿ�
 **/
public interface SendAndBackDao {
    
	//���˶�Ӧ��δ��ҩƷ�嵥
    List<DrugList> findNotSendDrug(String CaseId);
    
    //����ҩ�������ʾҩ����Ϣ����Ӧ��ҩ��������ʾ���·��ı��
    DrugList findOfdrugcode(String drugcode);
    
    //�����Ѿ���ҩ����δʹ�õ�ҩƷ
    List<DrugList> findBackableDruginfo(String caseId);
    
    //���ѷ���ҩ״̬��Ϊ�ѷ�ҩ
    void updateStateOfSended(String caseId);

    //����ҩƷ��Ϣ�ı䲡����Ϣ
    void updatePatientState(String caseId);

    //��ѯ��ӦcaseID�Ļ�����Ϣ
    Patient findPatientName(String CaseId);
    
    //��ʾ���в��˷�ҩ��Ϣ
    List<Patient> ShowPatient();

    //��ҩ
	void undateStateOfBacked(String drugscode);

	

 
}
