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


	//���ѷ���ҩ״̬��Ϊ�ѷ�ҩ
	@Override
	public void updateStateOfSended(String drugscode) {
		// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sqlString ="update drugslist set Status='�ѷ�' where DrugsCode = "+drugscode+" and Status='δ��'";
		DButil.executeStatement(sqlString);
	}
	
	//����ҩƷ��Ϣ�ı䲡����Ϣ
	@Override
	public void updatePatientState(String caseId) {
				// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sql1 = "select Status from drugslist where CaseId = "+caseId+"";
		String sql2 = "update patient set Statu='�ѷ�' where CaseId = "+caseId+" and Statu='��ҩ����'";
		DButil.executeStatement(sql1);
		List<String> statelist = new ArrayList<>();
		ResultSet rs = DButil.getResultSet(sql1);
		try {
			while(rs.next()){
				statelist.add(rs.getString("Status"));
			}
			int flag = 0;
			for(String list:statelist){
				if(!list.equals("�ѷ�")&&!list.equals("����")){
					flag = 1;
					System.out.println("��ҩδ��");
					break;
				}
				else {
					System.out.println("��ҩ�ѷ�");
				}
			}
			
			if(flag == 0){
				DButil.executeStatement(sql2);
				System.out.println("ȫ��ҩ���꣬״̬�޸����");
			}
			DButil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	//��ʾ��ҩ�����µ����в��˻�����Ϣ
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

	//��ѯ��Ӧ�����ŵĻ���������Ϣ����Ӧ��ҩ����
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
	
	
	
	//ģ̬����ʾÿ�����˶�Ӧ��ҩƷ�嵥
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
		

		//��ѯ����ҩ��ҩƷ��Ϣ(ҩƷ״̬Ϊ"�ѷ�ҩ"��"δʹ��")
		@Override
		public List<DrugList> findBackableDruginfo(String caseId) {
			// TODO Auto-generated method stub
			List<DrugList> userList = new ArrayList<>();
			DButil.connectDataBase();
			DButil.createStatement();
			String sql = "SELECT * FROM drugslist WHERE CaseId= "+caseId+"  and Status ='�ѷ�' and UseStatus ='δʹ��'";
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
		
		
		//����'�ѷ�ҩ'Ϊ'����ҩ'
		@Override
		public void undateStateOfBacked(String drugscode) {
			// TODO Auto-generated method stub
			DButil.connectDataBase();
			DButil.createStatement();
			String sqlString ="update drugslist set Status='����' where DrugsCode ="+drugscode+" and Status='�ѷ�'";
			DButil.executeStatement(sqlString);
			DButil.close();
		}
		

		//����ҩ�������ʾҩ����Ϣ����Ӧ��ҩ��������ʾ���·��ı��
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
