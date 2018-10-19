package kr.kw.database;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Schedule;


public class DAOSchedule {
	private static final String TAG = "DAOSchedule";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOSchedule(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<Schedule> select(Schedule schedule) {

		SqlSession session = sqlSessionFactory.openSession();
		List<Schedule> result = session.selectList(SQLName.SQL_SELECT_SCHEDULE, schedule);
		session.close();
		
		if(result != null)
			KWLOG.debug(TAG, result.toString());

		return result;
	}
	
	public boolean insert(Schedule schedule) {
		int id = -1;
	
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			id = session.insert(SQLName.SQL_INSERT_SCHEDULE, schedule);
			session.commit();
			
			if(schedule != null)
				KWLOG.debug(TAG, schedule.toString());
		} catch (PersistenceException e) {
			KWLOG.excep(TAG, e.getMessage());
		} catch (NullPointerException e) {
			KWLOG.excep(TAG, e.getMessage());
		} finally {
			session.close();
		}

		return id > 0;
	}
	
	public boolean delete(Schedule schedule) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.delete(SQLName.SQL_DELETE_SCHEDULE, schedule);
			session.commit();
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
