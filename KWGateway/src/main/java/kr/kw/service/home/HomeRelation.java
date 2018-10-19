package kr.kw.service.home;

import kr.kw.service.contextawareness.Relation;
import weka.core.Utils;

public abstract class HomeRelation extends Relation {
	protected double getTagIdPosition(int tagId) {
		switch(tagId) {
		case 11:
			return 0;
		case 12:
			return 1;
		case 13:
			return 2;
		}
		
		return Utils.missingValue();
		
	}
	
	protected double getLocation(int location) {
		switch(location) {
		case 0:
			return 0;
		case 10013:
			return 1;
		case 10014:
			return 2;
		case 10015:
			return 3;
		case 10016:
			return 4;
		case 10017:
			return 5;
		case 10018:
			return 6;
		case 10019:
			return 7;
		case 10004:
			return 8;
		}
		
		return weka.core.Utils.missingValue();	
	}
}
