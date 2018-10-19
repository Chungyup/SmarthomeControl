package re.kr.keti.shprotocol.item;

public class Sensor implements Collectable, Deletable, Retrievable, Updatable  {
	// foreign key
	protected String gwid;		// gateway ID
	
	// none key
	protected String ssid;		// sensor id
	protected String ssnm;		// sensor name
	protected int sst;			// sensor type
	protected String ssst;		// sensor status
	protected String ssmf;		// sensor manufacturer
	protected String rt;		// register time
	
	public Sensor() {
		
	}

	public Sensor(String ssid, String ssnm, int sst, String ssst, String ssmf, String gwid, String rt) {
		this.ssid = ssid;
		this.ssnm = ssnm;
		this.sst = sst;
		this.ssst = ssst;
		this.ssmf = ssmf;
		this.gwid = gwid;
		this.rt = rt;
	}
	
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getSsnm() {
		return ssnm;
	}

	public void setSsnm(String ssnm) {
		this.ssnm = ssnm;
	}

	public int getSst() {
		return sst;
	}

	public void setSst(int sst) {
		this.sst = sst;
	}

	public String getSsst() {
		return ssst;
	}

	public void setSsst(String ssst) {
		this.ssst = ssst;
	}

	public String getSsmf() {
		return ssmf;
	}

	public void setSsmf(String ssmf) {
		this.ssmf = ssmf;
	}

	public String getGwid() {
		return gwid;
	}

	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}
	
	public String getStateOf(String tp) {
		try {
			String[] bulk = ssst.split(",");
			for(String units : bulk) {
				String[] unit = units.split("=");
				String type = unit[0];
				String value = unit[1];
				if(type.equals(tp)) {
					return value;
				}
			}	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Sensor [ssid=" + ssid + ", ssnm=" + ssnm + ", sst=" + sst + ", ssst=" + ssst + ", ssmf=" + ssmf
				+ ", rt=" + rt + "]";
	}
}
