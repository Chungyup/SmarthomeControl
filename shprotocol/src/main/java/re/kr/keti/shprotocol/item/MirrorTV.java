package re.kr.keti.shprotocol.item;

public class MirrorTV implements Collectable, Deletable, Retrievable, Updatable {
	private String mrid; 	// mirror TV ID
	private int mrloc; 		// mirror TV location
	private int brtn; 		// screen brightness

	public MirrorTV() {

	}

	public MirrorTV(String mrid, int mrloc, int brtn) {
		this.mrid = mrid;
		this.mrloc = mrloc;
		this.brtn = brtn;
	}

	public String getMrid() {
		return mrid;
	}

	public void setMrid(String mrid) {
		this.mrid = mrid;
	}

	public int getMrloc() {
		return mrloc;
	}

	public void setMrloc(int mrloc) {
		this.mrloc = mrloc;
	}

	public int getBrtn() {
		return brtn;
	}

	public void setBrtn(int brtn) {
		this.brtn = brtn;
	}

}
