package re.kr.keti.shprotocol.item;

public class Monitoring implements Collectable, Deletable, Retrievable, Updatable {
	private String mtid; // monitoring ID

	public String getMtid() {
		return mtid;
	}

	public void setMtid(String mtid) {
		this.mtid = mtid;
	}

}
