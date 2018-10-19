package kr.kw.data;

import java.util.List;

import kr.kw.workingmemory.DBManager;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.shprotocol.item.Schedule;

public class DataRetrievor {
	@SuppressWarnings("unused")
	private static final String TAG = "DataRetrievor";
	
	@SuppressWarnings("unused")
	private WorkingMemory wkmm;
	private DBManager dbm;
	
	public DataRetrievor(WorkingMemory wkmm, DBManager dbm) {
		this.wkmm = wkmm;
		this.dbm = dbm;
	}
	
	public List<Schedule> retrieve(Schedule schedule) {
		if(schedule != null) {
			return dbm.getScheduleDB().select(schedule);
		}
		
		return null;
	}
}
