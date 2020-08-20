/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Drug;
import bean.DrugList;
import bean.Patient;
import dao.SendAndBackDao;
import utils.DButil;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 
 **/
public class SendAndBackDaoImpl implements SendAndBackDao {

	/**
	 * 
	 */
	public SendAndBackDaoImpl() {
		// TODO Auto-generated constructor stub
	}


	//将已发的药状态改为已发药
	@Override
	public void updateStateOfSended(String drugscode) {
		// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sqlString ="update drugslist set Status='已发' where DrugsCode = "+drugscode+" and Status='未发'";
		DButil.executeStatement(sqlString);
	}
	
	//根据药品信息改变病人信息
	@Override
	public void updatePatientState(String caseId) {
				// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sql1 = "select Status from drugslist where CaseId = "+caseId+"";
		String sql2 = "update patient set Statu='已发' where CaseId = "+caseId+" and Statu='有药待发'";
		DButil.executeStatement(sql1);
		List<String> statelist = new ArrayList<>();
		ResultSet rs = DButil.getResultSet(sql1);
		try {
			while(rs.next()){
				statelist.add(rs.getString("Status"));
			}
			int flag = 0;
			for(String list:statelist){
				if(!list.equals("已发")&&!list.equals("已退")){
					flag = 1;
					System.out.println("此药未发");
					break;
				}
				else {
					System.out.println("此药已发");
				}
			}
			
			if(flag == 0){
				DButil.executeStatement(sql2);
				System.out.println("全部药发完，状态修改完毕");
			}
			DButil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	//显示发药管理下的所有病人基本信息
	@Override
	public List<Patient> ShowPatient() {
		List<Patient> patientList = new ArrayList<>();
		DButil.connectDataBase();
		DButil.createStatement();
		String sql = "select * from patient ";
		DButil.executeStatement(sql);
		ResultSet rs = DButil.getResultSet(sql);
		try {
			while(rs.next()){
				Patient patient = new Patient();
				patient.setName(rs.getString("Name"));
				patient.setAge(rs.getString("Age"));
				patient.setCaseId(rs.getString("CaseId"));
				patient.setSex(rs.getString("Sex"));
				patient.setDept(rs.getString("Dept"));
				patient.setId(rs.getString("Id"));
				patient.setDate(rs.getDate("Time"));
				patient.setIsTakeMedicine(rs.getString("Statu"));
				patientList.add(patient);
			}
			DButil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return patientList;


	}

	//查询对应病历号的患者姓名信息（对应发药管理）
	@Override
	public Patient findPatientName(String caseId) {
		Patient patient = new Patient();
		DButil.connectDataBase();
		DButil.createStatement();
		String findSql = "select * from patient where CaseId = '"+caseId+"';";
		DButil.executeStatement(findSql);
		ResultSet rs = DButil.getResultSet(findSql);
		try {
			while(rs.next()){
				patient.setName(rs.getString("Name"));
				patient.setAge(rs.getString("Age"));
				patient.setCaseId(rs.getString("CaseId"));
				patient.setSex(rs.getString("Sex"));
				patient.setDept(rs.getString("Dept"));
				patient.setId(rs.getString("Id"));
				patient.setDate(rs.getDate("Time"));
				patient.setIsTakeMedicine(rs.getString("Statu"));
			}
			DButil.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient ;
	}
	
	
	
	//模态框显示每个病人对应的药品清单
		@Override
		public List<DrugList> findNotSendDrug(String caseId) {
			List<DrugList> drugList = new ArrayList<>();
			DButil.connectDataBase();
			DButil.createStatement();
			String listsql = "select * from drugslist where CaseId = '"+caseId+"';";
			DButil.executeStatement(listsql);
			ResultSet rs = DButil.getResultSet(listsql);
			try {
				while(rs.next()){
					DrugList dList = new DrugList();
					dList.setCaseID(rs.getString("CaseId"));
					dList.setDrugname(rs.getString("DrugsName"));
					dList.setDrugcode(rs.getString("DrugsCode"));
					dList.setDrugcount(rs.getString("DrugsUnitCount"));
					dList.setStatus(rs.getString("Status"));
					drugList.add(dList);
				}
				DButil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return drugList;
		}
		

		//查询可退药的药品信息(药品状态为"已发药"且"未使用")
		@Override
		public List<DrugList> findBackableDruginfo(String caseId) {
			// TODO Auto-generated method stub
			List<DrugList> userList = new ArrayList<>();
			DButil.connectDataBase();
			DButil.createStatement();
			String sql = "SELECT * FROM drugslist WHERE CaseId= "+caseId+"  and Status ='已发' and UseStatus ='未使用'";
			DButil.executeStatement(sql);
			ResultSet rs = DButil.getResultSet(sql);
			try {
				while(rs.next()){
					DrugList dList = new DrugList();
					dList.setCaseID(rs.getString("CaseId"));
					dList.setDrugname(rs.getString("DrugsName"));
					dList.setDrugcode(rs.getString("DrugsCode"));
					dList.setDrugcount(rs.getString("DrugsUnitCount"));
					dList.setStatus(rs.getString("Status"));
					dList.setUsestatus(rs.getString("UseStatus"));
					userList.add(dList);
				}
				DButil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;
		}
		
		
		//更改'已发药'为'已退药'
		@Override
		public void undateStateOfBacked(String drugscode) {
			// TODO Auto-generated method stub
			DButil.connectDataBase();
			DButil.createStatement();
			String sqlString ="update drugslist set Status='已退' where DrugsCode ="+drugscode+" and Status='已发'";
			DButil.executeStatement(sqlString);
			DButil.close();
		}
		

		//根据药物编码显示药物信息（对应发药操作后，显示在下方的表格）
		@Override
		public DrugList findOfdrugcode(String drugcode) {
			DrugList drugList = new DrugList();
			DButil.connectDataBase();
			DButil.createStatement();
			String findSql2 = "select * from drugslist where DrugsCode = '"+drugcode+"';";
			DButil.executeStatement(findSql2);
			ResultSet rs = DButil.getResultSet(findSql2);
			try {
				while(rs.next()){
					drugList.setCaseID(rs.getString("CaseId"));
					drugList.setDrugname(rs.getString("DrugsName"));
					drugList.setDrugcode(rs.getString("DrugsCode"));
					drugList.setDrugcount(rs.getString("DrugsUnitCount"));
					drugList.setStatus(rs.getString("Status"));
				}
				DButil.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return drugList ;
		}
	
	
	
	
	
	
    

	


	


	


	
}
