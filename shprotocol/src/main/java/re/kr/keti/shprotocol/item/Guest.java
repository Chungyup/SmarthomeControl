package re.kr.keti.shprotocol.item;

public class Guest implements Collectable, Deletable, Retrievable, Updatable  {
	// foreign key
	private String bmsid;	// BMS ID
	
	// none key
	private String mphnb; 	// phone number
	private String name; 	// name
	private String afl; 	// affiliate
	private String adv; 	// adviser
	private String vspp; 	// visit purpose
	private int tagid;		// tag ID
	private String rt; 		// register time

	public Guest() {
		
	}
	
	public Guest(String mphnb, String name, String afl, String adv, String vspp, int tagid, String bmsid) {
		this.mphnb = mphnb;
		this.name = name;
		this.afl = afl;
		this.adv = adv;
		this.vspp = vspp;
		this.tagid = tagid;
		this.bmsid = bmsid;
	}
	
	public Guest(String mphnb, String name, String afl, String adv, String vspp) {
		this.mphnb = mphnb;
		this.name = name;
		this.afl = afl;
		this.adv = adv;
		this.vspp = vspp;
	}
	
	public void update(Guest guest) {
		name = guest.getName();
		afl = guest.getAfl();
		adv = guest.getAdv();
		vspp = guest.getVspp();
		tagid = guest.getTagid();
	}

	public String getMphnb() {
		return mphnb;
	}

	public void setMphnb(String mphnb) {
		this.mphnb = mphnb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAfl() {
		return afl;
	}

	public void setAfl(String afl) {
		this.afl = afl;
	}

	public String getAdv() {
		return adv;
	}

	public void setAdv(String adv) {
		this.adv = adv;
	}

	public String getVspp() {
		return vspp;
	}

	public void setVspp(String vspp) {
		this.vspp = vspp;
	}
	
	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}
	
	public void setBmsid(String bmsid) {
		this.bmsid = bmsid;
	}

	@Override
	public String toString() {
		return "Guest [bmsid=" + bmsid + ", mphnb=" + mphnb + ", name=" + name + ", afl=" + afl + ", adv=" + adv
				+ ", vspp=" + vspp + ", tagid=" + tagid + ", rt=" + rt + "]";
	}

}
