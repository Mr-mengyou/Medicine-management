/**
 * 
 */
package bean;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ��ҩԱ��¼��Ϣ
 **/
public class Operator {
	
	String name;  		//��ҩԱ����
	String number;		//�˺�
	String password;	//����
	String type;		//����

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	/**
	 * 
	 * @param name
	 * @param number
	 * @param password
	 */
	public Operator() {

	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Operator [name=" + name + ", number=" + number + ", password=" + password + ",type=" + type +"]";
	}

}
