/**
 * 
 */
package dao;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ����Ա��¼����
 **/
public interface LoginDao {

	//��¼����
	String Login(String num,String password); 
	

	//�����û�����
	String findTypeByNum(String num);
	
}
