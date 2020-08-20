/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Operator;
import jdk.nashorn.internal.ir.ReturnNode;
import utils.DButil;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: 
 **/
public class LoginDaoImpl implements LoginDao {

	/**
	 * 
	 */
	public LoginDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * µÇ Â¼
	 */
	@Override
	public String Login(String num, String password) {
		// TODO Auto-generated method stub
		DButil.connectDataBase();
		DButil.createStatement();
		String sql ="select * from login";
		DButil.executeStatement(sql);
		ResultSet rs = DButil.getResultSet(sql);
		List<Operator> list = new ArrayList<>();
		try {
			while(rs.next()){
				Operator operator =new Operator();
				operator.setName(rs.getString("username"));
				operator.setNumber(rs.getString("account"));
				operator.setPassword(rs.getString("password"));
				list.add(operator);
			}
			DButil.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int flag  = 0;
		String name = null;
		for(Operator operatorsOperator :list){
			 name = operatorsOperator.getName();
			 String accountnumber = operatorsOperator.getNumber();
			 String pass = operatorsOperator.getPassword();
			if(accountnumber.equals(num)&&pass.equals(password))
			{	
				flag = 1;
				return name;
			}
		}
		if(flag == 0){
			return "error";
		}
		return null;
	}

	@Override
	public String findTypeByNum(String num) {
		// TODO Auto-generated method stub
		Operator operator = new Operator();
		DButil.connectDataBase();
		DButil.createStatement();
		String sql = "select type from login where account = '"+num+"'";
		DButil.executeStatement(sql);
		ResultSet rs = DButil.getResultSet(sql);
		try {
			while(rs.next()){
				operator.setType(rs.getString("type"));
			}
			DButil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operator.getType();
	}
}
