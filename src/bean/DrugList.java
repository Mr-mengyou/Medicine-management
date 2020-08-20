package bean;

import java.util.Date;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 
 **/
public class DrugList {

	private String drugname;		//药品名	
	private String drugcount;		//药品数量
	private String drugcode;	//药品编码
	private String status;		//状态
	private String caseID;		//病历号
	private String dpt;         //科室
	private String usestatus;   //使用状态
	
	
	public String getUsestatus() {
		return usestatus;
	}
	public void setUsestatus(String usestatus) {
		this.usestatus = usestatus;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getDrugcount() {
		return drugcount;
	}
	public void setDrugcount(String drugcount) {
		this.drugcount = drugcount;
	}
	public String getDrugcode() {
		return drugcode;
	}
	public void setDrugcode(String drugcode) {
		this.drugcode = drugcode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	
	@Override
	public String toString() {
		return "DrugList [drugname=" + drugname + ", drugcount=" + drugcount + ", drugcode=" + drugcode + ", status="
				+ status + ", caseID=" + caseID + ", dpt=" + dpt + ", usestatus=" + usestatus + "]";
	}
	
	
	
	
	

	

}
