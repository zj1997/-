package cn.zj.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ��װ���õĲ���
 * @author Jie.Yuan
 *
 */
public class DBUtils {

	// ��ʼ�����ӳ�
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * ����DbUtils���ù��������
	 */
	public static QueryRunner getQuerrRunner() {
		return new QueryRunner(dataSource);
	}
}








