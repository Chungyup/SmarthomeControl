package kr.kw.database;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Sensor;


public class DAOSensor {
	private static final String TAG = "DAOSensor";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOSensor(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public int insert(Sensor sensor) {
		int id = -1;
	
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			id = session.insert(SQLName.SQL_INSERT_SENSOR, sensor);
			session.commit();
			
			if(sensor != null)
				KWLOG.debug(TAG, sensor.toString());
		} catch (PersistenceException e) {
			KWLOG.excep(TAG, e.getMessage());
		} catch (NullPointerException e) {
			KWLOG.excep(TAG, e.getMessage());
		} finally {
			session.close();
		}

		return id;
	}
	
}
