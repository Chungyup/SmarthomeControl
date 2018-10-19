package kr.kw.database;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Service;

public class DAOService {
	private static final String TAG = "DAOService";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOService(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public boolean insert(Service service) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert(SQLName.SQL_INSERT_SERVICE, service);
			session.commit();
			
			if(service != null)
				KWLOG.debug(TAG, service.toString());
		} catch (PersistenceException e) {
			KWLOG.excep(TAG, e.getMessage());
		} catch (NullPointerException e) {
			KWLOG.excep(TAG, e.getMessage());
		} finally {
			session.close();
		}

		return id > 0;
	}
}
