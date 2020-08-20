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
 * @desc: 增删改查,查找病人信息功能接口
 **/
public interface DrugDao {
	//增加药品
	void add(Drug drug);
	//通过药品助记码删除药品
	void delete(String helpId);
	//修改药品
	void update(Drug drug);
	
	//通过药品助记码查询药品
	Drug queryOne(String helpId);
	
	//药品表单查询所有药品
	List<Drug> queryAll();
	
	
	
	
}
