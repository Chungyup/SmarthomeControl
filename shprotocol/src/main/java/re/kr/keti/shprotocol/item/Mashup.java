package re.kr.keti.shprotocol.item;

public class Mashup implements Collectable, Deletable, Retrievable, Updatable {
	private String muid; 	// mash-up ID
	private String ctg; 	// mash-up category
	private String mnm; 	// mash-up name
	private String mtp; 	// mash-up type
	private String mvs;		// mash-up version
	
	public Mashup() {
		
	}
	
	public Mashup(String muid, String ctg, String mnm, String mtp) {
		this.muid = muid;
		this.ctg = ctg;
		this.mnm = mnm;
		this.mtp = mtp;
	}

	public String getMuid() {
		return muid;
	}

	public void setMuid(String muid) {
		this.muid = muid;
	}

	public String getCtg() {
		return ctg;
	}

	public void setCtg(String ctg) {
		this.ctg = ctg;
	}

	public String getMnm() {
		return mnm;
	}

	public void setMnm(String mnm) {
		this.mnm = mnm;
	}

	public String getMtp() {
		return mtp;
	}

	public void setMtp(String mtp) {
		this.mtp = mtp;
	}
	
	public String getMvs() {
		return mvs;
	}

	public void setMvs(String mvs) {
		this.mvs = mvs;
	}

	@Override
	public String toString() {
		return "Mashup [muid=" + muid + ", ctg=" + ctg + ", mnm=" + mnm + ", mtp=" + mtp + "]";
	}

	
}
