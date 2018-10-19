package kr.kw.gateway;

import kr.kw.controller.GWProcess;
import kr.kw.util.Configure;
import kr.kw.util.KWLOG;
import re.kr.keti.shprotocol.item.Gateway;

public class KWGateway extends Gateway {
	public static String ID = "DEFAULT_ID";
	public static String BUIlDING = "DEFAULT_BD_NAME";
	public static String FLOOR = "DEFAULT_FLOOR";
	public static String LOCATION = "DEFAULT_LOC";
	
	public KWGateway() {}
	
	public KWGateway(String gatewayId, String building, String floor, String location) {
		super(gatewayId, building, floor, location);
	}

	public static void main(String[] args) {
	

		new Configure().setConfig();

		final GWProcess process = new GWProcess();
		
		KWGateway gatewayInfo = new KWGateway(
				KWGateway.ID, 
				KWGateway.BUIlDING, 
				KWGateway.FLOOR, 
				KWGateway.LOCATION);

		// check gateway
		process.checkGateway(gatewayInfo);
		
		// initialize context awareness
		process.initContextAwareness();
		
		// register users with a tag
		process.registerUsers();
		
		// start communicate
		process.startCommunicate();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				process.finish();
				KWLOG.info("gateway", "finished gateway " + ID);
			}
		});
		
		
//		process.runTest();
	}
}