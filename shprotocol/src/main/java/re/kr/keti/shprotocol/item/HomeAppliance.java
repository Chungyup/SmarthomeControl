package re.kr.keti.shprotocol.item;

public class HomeAppliance implements Collectable, Deletable, Retrievable, Updatable {
	// foreign key
	protected String gwid; 		// gateway ID

	// none key
	protected String haid; 		// home appliance ID
	protected String hanm;		// home appliance name
	protected int hat; 			// home appliance type
	protected String hafc; 		// home appliance function
	protected String hamf; 		// home appliance manufacturer
	protected String rt; 		// register time

	public HomeAppliance() {

	}

	public HomeAppliance(String haid, String hanm, int hat, String hafc, String hamf, String rt) {

		this.haid = haid;
		this.hanm = hanm;
		this.hat = hat;
		this.hafc = hafc;
		this.hamf = hamf;
		this.rt = rt;
	}

	public String getGwid() {
		return gwid;
	}

	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	public String getHaid() {
		return haid;
	}

	public void setHaid(String haid) {
		this.haid = haid;
	}

	public String getHanm() {
		return hanm;
	}

	public void setHanm(String hanm) {
		this.hanm = hanm;
	}

	public int getHat() {
		return hat;
	}

	public void setHat(int hat) {
		this.hat = hat;
	}

	public String getHafc() {
		return hafc;
	}

	public void setHafc(String hafc) {
		this.hafc = hafc;
	}

	public String getHamf() {
		return hamf;
	}

	public void setHamf(String hamf) {
		this.hamf = hamf;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "HomeAppliance [haid=" + haid + ", hanm=" + hanm + ", hat=" + hat + ", hafc=" + hafc + ", hamf=" + hamf
				+ ", rt=" + rt + "]";
	}

}
