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
 * @desc: ���ݿ����Ӽ�ʹ��
 *
*/

public class DButil {
    private static boolean executable;
    private static Connection connection;
    private static Statement statement;
	private static DataSource dataSource;

    //����DBCP�����ļ�
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
     * @Desc: �������ݿ�����
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
     * @Desc: �������ݿ����ִ�ж���
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
     * @Desc: ִ�����
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
     * @Desc: ִ�����,���ز�ѯ�����
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
     * @Desc:�ر�����
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

