package re.kr.keti.shprotocol.item;

public class Smartphone implements Collectable, Deletable, Retrievable, Updatable  {
	// primary key
	private String phnb; 	// phone number

	// foreign key
	private String mphnb; 	// main phone number

	// none key
	private double lat; 	// latitude
	private double lng; 	// longitude
	private String addr; 	// address
	private String phst; 	// phone state
	private String sdst; 	// sound state
	private String rt; 		// register time

	public Smartphone() {
		
	}
	
	public Smartphone(String phnb, String mphnb, double lat, double lng, String addr, String phst, String sdst,
			String rt) {
		this.phnb = phnb;
		this.mphnb = mphnb;
		this.lat = lat;
		this.lng = lng;
		this.addr = addr;
		this.phst = phst;
		this.sdst = sdst;
		this.rt = rt;
	}

	public String getPhnb() {
		return phnb;
	}

	public void setPhnb(String phnb) {
		this.phnb = phnb;
	}

	public String getMphnb() {
		return mphnb;
	}

	public void setMphnb(String mphnb) {
		this.mphnb = mphnb;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhst() {
		return phst;
	}

	public void setPhst(String phst) {
		this.phst = phst;
	}

	public String getSdst() {
		return sdst;
	}

	public void setSdst(String sdst) {
		this.sdst = sdst;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "Smartphone [phnb=" + phnb + ", mphnb=" + mphnb + ", lat=" + lat + ", lng=" + lng + ", addr=" + addr
				+ ", phst=" + phst + ", sdst=" + sdst + ", rt=" + rt + "]";
	}

	

}
