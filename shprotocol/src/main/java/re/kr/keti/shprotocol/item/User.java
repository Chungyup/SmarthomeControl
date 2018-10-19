package re.kr.keti.shprotocol.item;

public class User implements Collectable, Deletable, Retrievable, Updatable {
	// primary key
	protected String mphnb; // main phone number

	// foreign key
	protected String bmsid; // BMD id
	protected String gwid; // gateway id

	// none key
	protected String name; // name
	protected String afl; // affiliate
	protected String ofc; // office
	protected String type; // type
	protected String crst; // current state
	protected String crlt; // current location
	protected int tagid; // tag id
	protected String rt; // register time

	public User() {

	}

	public User(String mphnb, String name, String afl, String ofc, String type, String crst, String crlt) {

		this.mphnb = mphnb;
		this.name = name;
		this.afl = afl;
		this.ofc = ofc;
		this.type = type;
		this.crst = crst;
		this.crlt = crlt;
	}

	public User(String mphnb, String bmsid, String name, String afl, String ofc, String type, int tagid) {
		this.mphnb = mphnb;
		this.bmsid = bmsid;
		this.name = name;
		this.afl = afl;
		this.ofc = ofc;
		this.type = type;
		this.tagid = tagid;
	}

	public void update(User user) {
		this.name = user.getName();
		this.afl = user.getAfl();
		this.ofc = user.getOfc();
		this.type = user.getType();
		this.crst = user.getCrst();
		this.crlt = user.getCrlt();
		this.tagid = user.getTagid();
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

	public String getOfc() {
		return ofc;
	}

	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCrst() {
		return crst;
	}

	public void setCrst(String crst) {
		this.crst = crst;
	}

	public String getCrlt() {
		return crlt;
	}

	public void setCrlt(String crlt) {
		this.crlt = crlt;
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

	public String getBmsid() {
		return bmsid;
	}

	public String getGwid() {
		return gwid;
	}

	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	@Override
	public String toString() {
		return "User [mphnb=" + mphnb + ", bmsid=" + bmsid + ", gwid=" + gwid + ", name=" + name + ", afl=" + afl
				+ ", ofc=" + ofc + ", type=" + type + ", crst=" + crst + ", crlt=" + crlt + ", tagid=" + tagid + ", rt="
				+ rt + "]";
	}


}
