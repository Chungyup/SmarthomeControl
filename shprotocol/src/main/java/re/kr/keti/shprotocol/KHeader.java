package re.kr.keti.shprotocol;

public class KHeader {
	protected String to; // to
	protected String from; // from
	protected String id; // id
	protected int mt; // message type
	protected int cmd; // commend
	protected int ct; // content
	protected int ctt; // content type

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMt() {
		return mt;
	}

	public void setMt(int mt) {
		this.mt = mt;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public int getCtt() {
		return ctt;
	}

	public void setCtt(int ctt) {
		this.ctt = ctt;
	}

}
