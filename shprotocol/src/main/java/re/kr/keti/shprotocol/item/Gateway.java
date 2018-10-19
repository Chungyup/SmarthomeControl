package re.kr.keti.shprotocol.item;

public class Gateway implements Collectable, Deletable, Retrievable, Updatable  {
	// primary key
	protected String gwid; 		// gateway ID
	
	// foreign key
	protected String bmsid;		// BMS ID
	
	// none key
	protected String bd; 		// building
	protected String flr; 		// floor
	protected String lct; 		// location
	protected String rt; 		// register time

	public Gateway() {

	}

	public Gateway(String gwid, String bd, String flr, String lct) {
		this.gwid = gwid;
		this.bd = bd;
		this.flr = flr;
		this.lct = lct;
	}

	public Gateway(String gwid, String bd, String flr, String lct, String rt) {
		this.gwid = gwid;
		this.bd = bd;
		this.flr = flr;
		this.lct = lct;
		this.rt = rt;
	}

	public String getGwId() {
		return gwid;
	}

	public void setGwId(String gwid) {
		this.gwid = gwid;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getFlr() {
		return flr;
	}

	public void setFlr(String flr) {
		this.flr = flr;
	}

	public String getLct() {
		return lct;
	}

	public void setLct(String lct) {
		this.lct = lct;
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

	@Override
	public String toString() {
		return "Gateway [gwid=" + gwid + ", bd=" + bd + ", flr=" + flr + ", lct=" + lct + ", rt=" + rt + "]";
	}

}
