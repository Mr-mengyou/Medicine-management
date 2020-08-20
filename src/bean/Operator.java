/**
 * 
 */
package bean;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 发药员登录信息
 **/
public class Operator {
	
	String name;  		//发药员姓名
	String number;		//账号
	String password;	//密码
	String type;		//类型

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
