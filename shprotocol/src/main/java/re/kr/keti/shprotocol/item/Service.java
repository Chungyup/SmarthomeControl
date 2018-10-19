package re.kr.keti.shprotocol.item;

public class Service implements Collectable, Deletable, Retrievable, Updatable {
	
	// foreign key
	protected String gwid; // gateway id
	
	private String svid; 	// service ID
	private String svnm; 	// service name
	private String svvs; 	// service version
	private String svif; 	// service information
	private String ctg; 	// category
	private String svtp;	// service type
	private String rt; 		// register time

	public Service() {

	}

	public Service(String gwid, String svid, String svnm, String svvs, String svif, String ctg, String rt) {
		this.gwid = gwid;
		this.svid = svid;
		this.svnm = svnm;
		this.svvs = svvs;
		this.svif = svif;
		this.ctg = ctg;
		this.rt = rt;
	}

	public String getGwid() {
		return gwid;
	}

	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	public String getSvid() {
		return svid;
	}

	public void setSvid(String svid) {
		this.svid = svid;
	}

	public String getSvnm() {
		return svnm;
	}

	public void setSvnm(String svnm) {
		this.svnm = svnm;
	}

	public String getSvvs() {
		return svvs;
	}

	public void setSvvs(String svvs) {
		this.svvs = svvs;
	}

	public String getSvif() {
		return svif;
	}

	public void setSvif(String svif) {
		this.svif = svif;
	}

	public String getCtg() {
		return ctg;
	}

	public void setCtg(String ctg) {
		this.ctg = ctg;
	}
	
	public String getSvtp() {
		return svtp;
	}

	public void setSvtp(String svtp) {
		this.svtp = svtp;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "Service [gwid=" + gwid + ", svid=" + svid + ", svnm=" + svnm + ", svvs=" + svvs + ", svif=" + svif
				+ ", ctg=" + ctg + ", svtp=" + svtp + ", rt=" + rt + "]";
	}


}
