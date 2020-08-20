/**
 * 
 */
package bean;

import java.awt.List;
import java.util.Date;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 病人实体
 **/
public class Patient {
	private String name;                    //姓名
	
	private String caseId;                  //病历号
	private String age;
	private String id ;
	private String sex;
	private String dept;
	private Date date;                      //收费日期
	private String isTakeMedicine; 
//	private boolean isTakeMedicine = false; //是否发药(默认未发)
	          //发药状态
	
	private String p_drug;
	private List drugList;                  //药品清单
	
		
	public Patient(){}
	/**
	 * @param name
	 * @param invoiceNum
	 * @param caseId
	 * @param date
	 * @param isTakeMedicine
	 */
	public Patient(String name,String id, String age,String sex,String dept , String caseId, Date date, String isTakeMedicine) {
		super();
		this.name = name;
		this.caseId = caseId;
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.dept = dept;
		this.date = date;
		this.isTakeMedicine = isTakeMedicine;
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getP_drug() {
		return p_drug;
	}
	public void setP_drug(String p_drug) {
		this.p_drug = p_drug;
	}
	public String getP_department() {
		return p_department;
	}
	public void setP_department(String p_department) {
		this.p_department = p_department;
	}
	private String p_department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String string) {
		this.caseId = string;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
//	public boolean isTakeMedicine() {
//		return isTakeMedicine;
//	}
//	public void setTakeMedicine(boolean isTakeMedicine) {
//		this.isTakeMedicine = isTakeMedicine;
//	}
	/**
	 * @return the drugList
	 */
	public List getDrugList() {
		return drugList;
	}
	/**
	 * @param drugList the drugList to set
	 */
	public void setDrugList(List drugList) {
		this.drugList = drugList;
	}
	public String getIsTakeMedicine() {
		return isTakeMedicine;
	}
	public void setIsTakeMedicine(String isTakeMedicine) {
		this.isTakeMedicine = isTakeMedicine;
	}
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", caseId=" + caseId + ", age=" + age + ", id=" + id + ", sex=" + sex
				+ ", dept=" + dept + ", date=" + date + ", isTakeMedicine=" + isTakeMedicine + ", p_drug=" + p_drug
				+ ", drugList=" + drugList + ", p_department=" + p_department + "]";
	}
	 
	
}
