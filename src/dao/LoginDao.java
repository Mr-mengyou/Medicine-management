/**
 * 
 */
package dao;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 操作员登录操作
 **/
public interface LoginDao {

	//登录功能
	String Login(String num,String password); 
	

	//查找用户类型
	String findTypeByNum(String num);
	
}
