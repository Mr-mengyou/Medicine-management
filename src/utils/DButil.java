package utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.sun.org.apache.bcel.internal.generic.NEW;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * @project: DrugManageSystem
 * @author: Zuohaonan
 * @date: 
 * @desc: 数据库连接及使用
 *
*/

public class DButil {
    private static boolean executable;
    private static Connection connection;
    private static Statement statement;
	private static DataSource dataSource;

    //加载DBCP配置文件
    static{
    		Properties p = new Properties();
    		try {
				p.load(DButil.class.getResourceAsStream("db.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
			try {
				dataSource = BasicDataSourceFactory.createDataSource(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    /**
     * @Desc: 建立数据库连接
     * @return: void
     */
    public static void connectDataBase() {
        try {
            connection =dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Desc: 创建数据库语句执行对象
     * @return: void
     */
    public static void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Desc: 执行语句
     * @return: void
     */
    public static void executeStatement(String sqlStatement) {
        try {
            statement.execute(sqlStatement);
            executable = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void executeUpdate(String sqlStatement) {
		// TODO Auto-generated method stub
		try {
            statement.executeUpdate(sqlStatement);
            executable = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

    /**
     * @Desc: 执行语句,返回查询结果集
     * @return: resSet
     */
    public static  ResultSet getResultSet(String sqlStatement) {
        ResultSet resSet = null;
        if (!executable)
            executeStatement(sqlStatement);
        try {
            resSet = statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    
    /**
     * @Desc:关闭连接
     * @return: void
     */
    public static void close(){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}

