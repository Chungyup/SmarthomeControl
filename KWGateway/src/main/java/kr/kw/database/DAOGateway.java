package kr.kw.database;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Gateway;

public class DAOGateway {
	private static final String TAG = "DAOGateway";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOGateway(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public Gateway selectGateway(Gateway gateway) {
		Gateway result = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		result = session.selectOne(SQLName.SQL_SELECT_GW, gateway);
		session.close();
		
		if(result != null)
			KWLOG.debug(TAG, result.toString());

		return result;
	}
	
	public int insertGateway(Gateway gateway) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert(SQLName.SQL_INSERT_GW, gateway);
			session.commit();
			
			if(gateway != null)
				KWLOG.debug(TAG, gateway.toString());
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
