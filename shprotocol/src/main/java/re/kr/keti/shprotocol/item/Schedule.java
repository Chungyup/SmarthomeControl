package re.kr.keti.shprotocol.item;

public class Schedule implements Collectable, Deletable, Retrievable, Updatable  {
	// primary key
	private int scdid; 		// schedule id

	// foreign key
	private String mphnb; 	// main phone number

	// none key
	private String scdtl; 	// title
	private String scddt; 	// date
	private String scdtm; 	// time
	private String scdmm; 	// memo
	private String rt; 		// register time
	
	public Schedule() {
		
	}
	
	public Schedule(String mphnb) {
		this.mphnb = mphnb;
	}
	
	public Schedule(int scdid) {
		this.scdid = scdid;
	}
	
	public Schedule(String mphnb, String scdtl, String scddt, String scdtm, String scdmm) {
		this.mphnb = mphnb;
		this.scdtl = scdtl;
		this.scddt = scddt;
		this.scdtm = scdtm;
		this.scdmm = scdmm;
	}

	public int getScdid() {
		return scdid;
	}

	public void setScdid(int scdid) {
		this.scdid = scdid;
	}

	public String getMphnb() {
		return mphnb;
	}

	public void setMphnb(String mphnb) {
		this.mphnb = mphnb;
	}

	public String getScdtl() {
		return scdtl;
	}

	public void setScdtl(String scdtl) {
		this.scdtl = scdtl;
	}

	public String getScddt() {
		return scddt;
	}

	public void setScddt(String scddt) {
		this.scddt = scddt;
	}

	public String getScdtm() {
		return scdtm;
	}

	public void setScdtm(String scdtm) {
		this.scdtm = scdtm;
	}

	public String getScdmm() {
		return scdmm;
	}

	public void setScdmm(String scdmm) {
		this.scdmm = scdmm;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "Schedule [scdid=" + scdid + ", mphnb=" + mphnb + ", scdtl=" + scdtl + ", scddt=" + scddt + ", scdtm="
				+ scdtm + ", scdmm=" + scdmm + ", rt=" + rt + "]";
	}

}
