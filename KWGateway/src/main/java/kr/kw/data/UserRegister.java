package kr.kw.data;

import kr.kw.device.SHSensor;
import kr.kw.user.GWUser;
import kr.kw.workingmemory.DBManager;
import kr.kw.workingmemory.WorkingMemory;
import re.kr.keti.lcy.device.maxfor.item.MaxforLocationTag;
import re.kr.keti.shprotocol.item.Gateway;

public class UserRegister {
	@SuppressWarnings("unused")
	private static final String TAG = "UserRegister";

	private WorkingMemory wkmm;
	private DBManager dbm;

	public UserRegister(WorkingMemory wkmm, DBManager dbm) {
		this.wkmm = wkmm;
		this.dbm = dbm;
	}

	public void todo(Gateway gateway) {
		// 14 ~ 20
		// 7 : 16 17 20 - 704,
		// guest : 15
		// 6 : 16 - 603-1, 17 - 603
		// 5 : 18 - 501, 19 - 502
		// 1 : 20 - 103
		if("home".equals(gateway.getLct())) {
			if("6".equals(gateway.getFlr())) {
				MaxforLocationTag tag11 = new MaxforLocationTag(11);
				SHSensor sensor11 = new SHSensor(4, 11, tag11);
				wkmm.getSensorManager().register(sensor11);
				GWUser father = new GWUser("01058829549", "leecheongyup", "keti", "603", "father", sensor11);
				father.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(father);
				dbm.getUserDB().insertUser(father);
				wkmm.getSensorManager().register(sensor11);
				
				MaxforLocationTag tag12 = new MaxforLocationTag(12);
				SHSensor sensor12 = new SHSensor(4, 12, tag12);
				wkmm.getSensorManager().register(sensor12);
				GWUser mother = new GWUser("01038395471", "hansungsoo", "keti", "603", "mother", sensor12);
				mother.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(mother);
				dbm.getUserDB().insertUser(mother);
				wkmm.getSensorManager().register(sensor12);
				
				MaxforLocationTag tag13 = new MaxforLocationTag(13);
				SHSensor sensor13 = new SHSensor(4, 13, tag13);
				wkmm.getSensorManager().register(sensor13);
				GWUser child = new GWUser("01048800311", "yangjeayeong", "kw", "603", "child", sensor13);
				child.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(child);
				dbm.getUserDB().insertUser(child);
				wkmm.getSensorManager().register(sensor13);
			}
		} else if("building".equals(gateway.getLct())) {
			if ("1".equals(gateway.getFlr())) {

				MaxforLocationTag tag20 = new MaxforLocationTag(20);
				SHSensor sensor20 = new SHSensor(4, 20, tag20);
				wkmm.getSensorManager().register(sensor20);
				GWUser user20 = new GWUser("01020202020", "user20", "kw", "103", "none", sensor20);
				user20.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user20);
				dbm.getUserDB().insertUser(user20);
				wkmm.getSensorManager().register(sensor20);
				
			} else if ("5".equals(gateway.getFlr())) {

				MaxforLocationTag tag18 = new MaxforLocationTag(18);
				SHSensor sensor18 = new SHSensor(4, 18, tag18);
				wkmm.getSensorManager().register(sensor18);
				GWUser user18 = new GWUser("01018181818", "user18", "kw", "501", "none", sensor18);
				user18.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user18);
				dbm.getUserDB().insertUser(user18);
				wkmm.getSensorManager().register(sensor18);
				
				MaxforLocationTag tag19 = new MaxforLocationTag(19);
				SHSensor sensor19 = new SHSensor(4, 19, tag19);
				wkmm.getSensorManager().register(sensor19);
				GWUser user19 = new GWUser("01019191919", "user19", "kw", "502", "none", sensor19);
				user19.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user19);
				dbm.getUserDB().insertUser(user19);
				wkmm.getSensorManager().register(sensor19);
				
			} else if ("6".equals(gateway.getFlr())) {

				MaxforLocationTag tag16 = new MaxforLocationTag(16);
				SHSensor sensor16 = new SHSensor(4, 16, tag16);
				wkmm.getSensorManager().register(sensor16);
				GWUser user16 = new GWUser("01016161616", "user16", "kw", "603-1", "none", sensor16);
				user16.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user16);
				dbm.getUserDB().insertUser(user16);
				wkmm.getSensorManager().register(sensor16);
				
				MaxforLocationTag tag17 = new MaxforLocationTag(17);
				SHSensor sensor17 = new SHSensor(4, 17, tag17);
				wkmm.getSensorManager().register(sensor17);
				GWUser user17 = new GWUser("01017171717", "user17", "kw", "603", "none", sensor17);
				user17.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user17);
				dbm.getUserDB().insertUser(user17);
				wkmm.getSensorManager().register(sensor17);
				
			} else if ("7".equals(gateway.getFlr())) {

				MaxforLocationTag tag14 = new MaxforLocationTag(14);
				SHSensor sensor14 = new SHSensor(4, 14, tag14);
				wkmm.getSensorManager().register(sensor14);
				GWUser user14 = new GWUser("01014141414", "user14", "kw", "704", "none", sensor14);
				user14.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user14);
				dbm.getUserDB().insertUser(user14);
				wkmm.getSensorManager().register(sensor14);
				
				MaxforLocationTag tag16 = new MaxforLocationTag(16);
				SHSensor sensor16 = new SHSensor(4, 16, tag16);
				wkmm.getSensorManager().register(sensor16);
				GWUser user16 = new GWUser("01016161616", "user16", "kw", "704", "none", sensor16);
				user16.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user16);
				dbm.getUserDB().insertUser(user16);
				wkmm.getSensorManager().register(sensor16);
				
				MaxforLocationTag tag17 = new MaxforLocationTag(17);
				SHSensor sensor17 = new SHSensor(4, 17, tag17);
				wkmm.getSensorManager().register(sensor17);
				GWUser user17 = new GWUser("01017171717", "user17", "kw", "704", "none", sensor17);
				user17.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user17);
				dbm.getUserDB().insertUser(user17);
				wkmm.getSensorManager().register(sensor17);
				
				MaxforLocationTag tag21 = new MaxforLocationTag(21);
				SHSensor sensor21 = new SHSensor(4, 21, tag21);
				wkmm.getSensorManager().register(sensor21);
				GWUser user21 = new GWUser("01021212121", "user21", "kw", "704", "none", sensor21);
				user21.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user21);
				dbm.getUserDB().insertUser(user21);
				wkmm.getSensorManager().register(sensor21);
				
				MaxforLocationTag tag22 = new MaxforLocationTag(22);
				SHSensor sensor22 = new SHSensor(4, 22, tag22);
				wkmm.getSensorManager().register(sensor22);
				GWUser user22 = new GWUser("01022222222", "user22", "kw", "704", "none", sensor22);
				user22.setGwid(gateway.getGwId());
				wkmm.getUserManager().addUser(user22);
				dbm.getUserDB().insertUser(user22);
				wkmm.getSensorManager().register(sensor22);
			}	
		}
	}
}
