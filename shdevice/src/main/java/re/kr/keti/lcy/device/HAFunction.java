package re.kr.keti.lcy.device;

public interface HAFunction {
	public void updateFunction(int func);
	public void updateSpecial(int special);
	public String getFunctionList();
	public int getFunction();
	public int getSpecial();
	public String getManuf();
	public boolean equalOnOff(int func);
	public int getOnOff();
}
