package kr.kw.database;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Smartphone;

public class DAOSmartphone {
	private static final String TAG = "DAOSmartphone";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOSmartphone(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public Smartphone selectLatest(Smartphone phone) {
		
		Smartphone result = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		result = session.selectOne(SQLName.SQL_SELECT_LATEST_PHONE, phone);
		session.close();
		
		if(result != null)
			KWLOG.debug(TAG, result.toString());

		return result;
	}
	
	public boolean insert(Smartphone smartphone) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert(SQLName.SQL_INSERT_SMARTPHONE, smartphone);
			session.commit();
			
			if(smartphone != null)
				KWLOG.debug(TAG, smartphone.toString());
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
