package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kw.device.SHMirrorTV;
import kr.kw.user.GWUser;

public class MirrorTVManager {
	Map<String, SHMirrorTV> mirrortvs;
	
	public MirrorTVManager() {
		mirrortvs = new HashMap<String, SHMirrorTV>();
	}
	
	public void register(SHMirrorTV mtv) {
		if(mtv != null && mtv.getMrid() != null) {
			mirrortvs.put(mtv.getMrid(), mtv);	
		}
	}
	
	public SHMirrorTV delete(SHMirrorTV mtv) {
		for(SHMirrorTV dtv : mirrortvs.values()) {
			if(dtv.getClient() == mtv.getClient()) {
				mirrortvs.remove(dtv.getMrid());
				return dtv;
			}
		}
		
		return null;
	}
	
	public void updateCount() {
		
	}
	
	public List<SHMirrorTV> updateOnOff(List<GWUser> users) {
		List<SHMirrorTV> mtvs = new ArrayList<SHMirrorTV>();
		for(SHMirrorTV mtv : mirrortvs.values()) {
			mtv.setCount(users);
			mtvs.add(mtv);
		}
		
		return mtvs;
	}
	
}
