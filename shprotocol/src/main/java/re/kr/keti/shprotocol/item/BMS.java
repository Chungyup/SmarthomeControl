package re.kr.keti.shprotocol.item;

public class BMS implements Collectable, Deletable, Retrievable, Updatable {
	// primary key
	private String bmsid; 	// building management server ID
	
	// none key
	private String bmsvs; 	// building management server version
	private String bmsdc; 	// building management server description
	private String rt; 		// register time
	
	public BMS() {
		
	}
	
	public BMS(String bmsid, String bmsvs, String bmsdc) {
		this.bmsid = bmsid;
		this.bmsvs = bmsvs;
		this.bmsdc = bmsdc;
	}

	public String getBmsid() {
		return bmsid;
	}

	public void setBmsid(String bmsid) {
		this.bmsid = bmsid;
	}

	public String getBmsvs() {
		return bmsvs;
	}

	public void setBmsvs(String bmsvs) {
		this.bmsvs = bmsvs;
	}

	public String getBmsdc() {
		return bmsdc;
	}

	public void setBmsdc(String bmsdc) {
		this.bmsdc = bmsdc;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "BMS [bmsid=" + bmsid + ", bmsvs=" + bmsvs + ", bmsdc=" + bmsdc + ", rt=" + rt + "]";
	}

}
