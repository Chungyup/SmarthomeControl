package re.kr.keti.shprotocol.item;

public class Manager implements Collectable, Deletable, Retrievable, Updatable {
	// primary key
	private String mngid; // manager ID

	// foreign key
	private String bmsid; // BMS ID

	// none key
	private String pswd; // password
	private String name; // name
	private String mphnb; // phone number
	private String afl; // affiliate
	private String rt; // register time

	public Manager() {

	}

	public Manager(String mngid, String pswd, String bmsid) {
		this.mngid = mngid;
		this.pswd = pswd;
		this.bmsid = bmsid;
	}

	public Manager(String mngid, String pswd, String name, String mphnb, String afl, String rt) {
		this.mngid = mngid;
		this.pswd = pswd;
		this.name = name;
		this.mphnb = mphnb;
		this.afl = afl;
		this.rt = rt;
	}

	public String getMngid() {
		return mngid;
	}

	public void setMngid(String mngid) {
		this.mngid = mngid;
	}

	public String getBmsid() {
		return bmsid;
	}

	public void setBmsid(String bmsid) {
		this.bmsid = bmsid;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMphnb() {
		return mphnb;
	}

	public void setMphnb(String mphnb) {
		this.mphnb = mphnb;
	}

	public String getAfl() {
		return afl;
	}

	public void setAfl(String afl) {
		this.afl = afl;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "Manager [mngid=" + mngid + ", pswd=" + pswd + ", name=" + name + ", mphnb=" + mphnb + ", afl=" + afl
				+ ", rt=" + rt + "]";
	}

}
