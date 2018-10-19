package kr.kw.database;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.user.GWUser;
import kr.kw.util.KWLOG;

public class DAOUser {
private static final String TAG = "DAOUser";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOUser(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public int insertUser(GWUser user) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert(SQLName.SQL_INSERT_USER, user);
			session.commit();
			
			if(user != null)
				KWLOG.debug(TAG, user.toString());
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
