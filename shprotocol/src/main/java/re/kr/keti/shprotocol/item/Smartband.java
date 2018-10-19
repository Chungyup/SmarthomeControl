package re.kr.keti.shprotocol.item;

public class Smartband implements Collectable, Deletable, Retrievable, Updatable  {
	private int step; 		// step
	private int kcal; 		// calorie
	private double btemp; 	// body temperature
	private int fdet; 		// fall detect
	private int hrate;		// heart rate
	private int state; 		// state
	private String rt; 		// register time

	public Smartband() {
		
	}
	
	public Smartband(Smartband band) {
		this.step = band.getStep();
		this.kcal = band.getKcal();
		this.btemp = band.getBtemp();
		this.fdet = band.getFdet();
		this.hrate = band.getHrate();
		this.state = band.getState();
		this.rt = band.getRt();
	}
	
	public Smartband(int step, int kcal, double btemp, int fdet, int hrate, int state, String rt) {
		this.step = step;
		this.kcal = kcal;
		this.btemp = btemp;
		this.fdet = fdet;
		this.hrate = hrate;
		this.state = state;
		this.rt = rt;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public double getBtemp() {
		return btemp;
	}

	public void setBtemp(double btemp) {
		this.btemp = btemp;
	}

	public int getFdet() {
		return fdet;
	}

	public void setFdet(int fdet) {
		this.fdet = fdet;
	}

	public int getHrate() {
		return hrate;
	}

	public void setHrate(int hrate) {
		this.hrate = hrate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	@Override
	public String toString() {
		return "Smartband [step=" + step + ", kcal=" + kcal + ", btemp=" + btemp + ", fdet=" + fdet + ", hrate=" + hrate
				+ ", state=" + state + ", rt=" + rt + "]";
	}
	
}
