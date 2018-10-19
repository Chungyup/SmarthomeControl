package kr.kw.database;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.HomeAppliance;

public class DAOHomeAppliance {
	private static final String TAG = "HomeapplianceDAO";
	
	private SqlSessionFactory sqlSessionFactory;

	public DAOHomeAppliance(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public int insert(HomeAppliance homeappliance) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert(SQLName.SQL_INSERT_HA, homeappliance);
			session.commit();
			
			if(homeappliance != null)
				KWLOG.debug(TAG, homeappliance.toString());
		} catch (PersistenceException e) {
			KWLOG.excep(TAG, e.getMessage());
		} catch (NullPointerException e) {
			KWLOG.excep(TAG, e.getMessage());
		} finally {
			session.close();
		}

		return id;
	}
	
	public List<HomeAppliance> selectAll() {
		List<HomeAppliance> list = null;
		
        SqlSession session = sqlSessionFactory.openSession();
        list = session.selectList(SQLName.SQL_SELECT_ALL_HA);
        session.close();
        
        if(list != null)
        	KWLOG.debug(TAG, list.toString());

        return list;
	}
	
	
}
