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
 * @desc: 发放药查询病人信息功能接口
 **/
public interface SendAndBackDao {
    
	//病人对应的未发药品清单
    List<DrugList> findNotSendDrug(String CaseId);
    
    //根据药物编码显示药物信息（对应发药操作后，显示在下方的表格）
    DrugList findOfdrugcode(String drugcode);
    
    //病人已经发药，但未使用的药品
    List<DrugList> findBackableDruginfo(String caseId);
    
    //将已发的药状态改为已发药
    void updateStateOfSended(String caseId);

    //根据药品信息改变病人信息
    void updatePatientState(String caseId);

    //查询对应caseID的患者信息
    Patient findPatientName(String CaseId);
    
    //显示所有病人发药信息
    List<Patient> ShowPatient();

    //退药
	void undateStateOfBacked(String drugscode);

	

 
}
