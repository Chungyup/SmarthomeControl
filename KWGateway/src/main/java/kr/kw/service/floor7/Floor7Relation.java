package kr.kw.service.floor7;

import kr.kw.service.contextawareness.Relation;
import weka.core.Utils;

public abstract class Floor7Relation extends Relation {

	protected double getTagIdPosition(int tagId) {
		switch(tagId) {
		case 14:
			return 0;
		case 15:
			return 1;
		case 16:
			return 2;
		case 17:
			return 3;
		case 18:
			return 4;
		case 19:
			return 5;
		case 20:
			return 6;
		case 21:
			return 7;
		case 22:
			return 8;
		}
		
		return Utils.missingValue();	
	}
	
	protected double getLocation(int location) {
		switch(location) {
		case 18010:
			return 0;
		case 10001:
			return 1;
		case 10002:
			return 2;
		case 10003:
			return 3;
		case 10022:
			return 4;

		}
		
		return weka.core.Utils.missingValue();	
	}
}
