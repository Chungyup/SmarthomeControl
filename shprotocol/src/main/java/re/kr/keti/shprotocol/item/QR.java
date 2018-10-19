package re.kr.keti.shprotocol.item;

public class QR implements Collectable, Deletable, Retrievable, Updatable  {
	private String mname; // model name

	public QR() {
		
	}
	
	public QR(String mname) {

		this.mname = mname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "QR [mname=" + mname + "]";
	}

}
