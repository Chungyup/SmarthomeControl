package kr.kw.service.contextawareness;

import java.sql.Time;

import kr.kw.controller.GWProcess;
import kr.kw.util.KWUtils;
import kr.kw.workingmemory.HomeApplianceManager;
import weka.core.Utils;

public abstract class Relation {
	protected int predict;
	
	public Relation() {
		predict = -1;
	}

	public void setPredict(int predict) {
		this.predict = predict;
	}
	
	public int getPredict() {
		return predict;
	}
	
	protected double getDatePosition() {
		switch(KWUtils.getDayOfWeek()) {
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		case 4:
			return 3;
		case 5:
			return 4;
		case 6:
			return 5;
		case 7:
			return 6;
		}
		
		return Utils.missingValue();
	}
	
	protected long getTime() {
		return Time.valueOf(KWUtils.getTime()).getTime();
	}
	
	abstract public double[] getInstances();
	abstract public void start(GWProcess process, HomeApplianceManager haMgr);
}
