package kr.kw.database;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SessionFactory {
	private static final String TAG = "SessionFactory";

	/**
	 * make session factory to access KWGateway database
	 * ***/
	private static SqlSessionFactory serviceSessionFactory;

	public static SqlSessionFactory getServiceSession() {
		return serviceSessionFactory;
	}

//	static {
//		try {
//			String resource = "kr/kw/database/kwgateway_db_config.xml";
//			Reader reader = Resources.getResourceAsReader(resource);
//
//			if (serviceSessionFactory == null) {
//				serviceSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			}
//		} catch (FileNotFoundException fileNotFoundException) {
//			KWLOG.excep(TAG, fileNotFoundException.getMessage());
//			fileNotFoundException.printStackTrace();
//		} catch (IOException iOException) {
//			KWLOG.excep(TAG, iOException.getMessage());
//			iOException.printStackTrace();
//		}
//	}
	
	public static void setting(String url, String dbname, String username, String password) {
//		DataSource dataSource = new PooledDataSource(
//				"com.mysql.jdbc.Driver", "jdbc:mysql://" + url + "/" + dbname + "?useUnicode=true&amp;characterEncoding=UTF8&amp;", username, password);
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development",
//		        transactionFactory, dataSource);

//		Configuration configuration = new Configuration(environment);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", "jdbc:mysql://" + url + "/" + dbname + "?useUnicode=true&amp;characterEncoding=UTF8&amp;");
		props.put("username", username);
		props.put("password", password);

		try {
			String resource = "kr/kw/database/kwgateway_db_config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (serviceSessionFactory == null) {
				serviceSessionFactory = new SqlSessionFactoryBuilder().build(reader, props);
				System.out.println(serviceSessionFactory.getConfiguration().getVariables().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
