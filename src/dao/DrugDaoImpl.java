/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import bean.Drug;
import bean.Patient;
import utils.DButil;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ��ɾ�Ĳ����ʵ����
 **/
public class DrugDaoImpl implements DrugDao {
	
	
	public DrugDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* 
	 * ����ҩƷ
	 */
	
	@Override
	public void add(Drug drug) {
		// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sql = "insert into drugs (DrugsCode,DrugsName,DrugsFormat,DrugsUnit,DrugsPrice,MnemonicCode) values ('"+drug.getCode()+"','"+drug.getName()+"','"+drug.getSpec()+"','"+drug.getUnit()+"','"+drug.getPrice()+"','"+drug.getHelpId()+"');";
		DButil.executeStatement(sql);
		DButil.close();

	}


	/* 
	 * ɾ��ҩƷ
	 */
	@Override
	public void delete(String helpId) {
		// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sql = "DELETE FROM drugs WHERE MnemonicCode = '"+helpId+"';";
		DButil.executeStatement(sql);
		DButil.close();
	
}
	/**
	 * �޸�ҩƷ
	 */
	public void update(Drug drug)
	{
		DButil.connectDataBase();
		DButil.createStatement();
		String sql = "  update drugs set DrugsCode='"+drug.getCode()+"', DrugsName ='"+drug.getName()+"', DrugsFormat ='"+drug.getSpec()+"', DrugsUnit ='"+drug.getUnit()+"', MnemonicCode ='"+drug.getHelpId()+"', DrugsPrice ='"+drug.getPrice()+"' where ID ='"+drug.getId()+"'; ";
		DButil.executeStatement(sql);
		DButil.close();
	}
	


	/* 
	 * ���������ѯ
	 */
	@Override
	public Drug queryOne(String helpId) {
			Drug drug = new Drug();
			DButil.connectDataBase();
			DButil.createStatement();
			String sql = "select * from drugs where MnemonicCode = '"+helpId+"';";
			DButil.executeStatement(sql);
			ResultSet rs = DButil.getResultSet(sql);
			try {
				while(rs.next()){
					drug.setId(rs.getString("ID"));
					drug.setCode(rs.getString("DrugsCode"));
					drug.setName(rs.getString("DrugsName"));
					drug.setSpec(rs.getString("DrugsFormat"));
					drug.setUnit(rs.getString("DrugsUnit"));
					drug.setPrice(rs.getDouble("DrugsPrice"));
					drug.setHelpId(rs.getString("MnemonicCode"));
				}
				DButil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return drug;
	
	}

	/* (non-Javadoc)
	 * ��ѯȫ��ҩƷ
	 */
	@Override
	public List<Drug> queryAll() {
		// TODO Auto-generated method stub
			List<Drug> userList = new ArrayList<>();
			DButil.connectDataBase();
			DButil.createStatement();
			String sql = "select * from drugs ";
			DButil.executeStatement(sql);
			ResultSet rs = DButil.getResultSet(sql);
			try {
				while(rs.next()){
					Drug drug = new Drug();
					drug.setId(rs.getString("ID"));
					drug.setCode(rs.getString("DrugsCode"));
					drug.setName(rs.getString("DrugsName"));

					drug.setSpec(rs.getString("DrugsFormat"));
					drug.setUnit(rs.getString("DrugsUnit"));
					drug.setType(rs.getString("DrugsType"));		
					drug.setPrice(rs.getDouble("DrugsPrice"));
					drug.setHelpId(rs.getString("MnemonicCode"));	
					userList.add(drug);
				}
				DButil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return userList;
	}

}

