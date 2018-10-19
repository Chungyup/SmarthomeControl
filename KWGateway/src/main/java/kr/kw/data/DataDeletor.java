package kr.kw.data;

import kr.kw.device.SHMirrorTV;
import kr.kw.util.KWLOG;
import kr.kw.workingmemory.DBManager;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.shprotocol.item.Schedule;

public class DataDeletor {
	private static final String TAG = "DataDeletor";
	
	private WorkingMemory wkmm;
	private DBManager dbm;
	
	public DataDeletor(WorkingMemory wkmm, DBManager dbm) {
		this.wkmm = wkmm;
		this.dbm = dbm;
	}
	
	public Schedule delete(Schedule schedule) {
		if(schedule != null) {
			if(dbm.getScheduleDB().delete(schedule)) {
//				connector.sendToMirrorTV(client, MirrorTVProtocol.resDelete(schedule));
				KWLOG.debug(TAG, "success to delete a schedule");
				return schedule;
			} else {
				KWLOG.debug(TAG, "fail to delete a schedule");
			}
		}
		
		return null;
	}
	
	public SHMirrorTV delete(SHMirrorTV mtv) {
		SHMirrorTV dtv = null;
		if(mtv != null) {
			dtv = wkmm.getMirrorTVManager().delete(mtv);
			if (dtv != null)
				KWLOG.debug(TAG, "success to remove a mirror TV");	
		}
		
		return dtv;
	}
}
