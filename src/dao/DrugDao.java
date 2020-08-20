/**
 * 
 */
package dao;

import java.util.List;

import bean.Drug;
import bean.Patient;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ��ɾ�Ĳ�,���Ҳ�����Ϣ���ܽӿ�
 **/
public interface DrugDao {
	//����ҩƷ
	void add(Drug drug);
	//ͨ��ҩƷ������ɾ��ҩƷ
	void delete(String helpId);
	//�޸�ҩƷ
	void update(Drug drug);
	
	//ͨ��ҩƷ�������ѯҩƷ
	Drug queryOne(String helpId);
	
	//ҩƷ����ѯ����ҩƷ
	List<Drug> queryAll();
	
	
	
	
}
