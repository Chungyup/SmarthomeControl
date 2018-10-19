package kr.kw.service.contextawareness.arff;

import java.util.List;

import kr.kw.util.KWUtils;

public class ARFFFactory {
	public static List<ARFF> getARFF(String loc, String floor) {
		if("home".equals(loc)) {
			if("6".equals(floor)) {
				return KWUtils.list(ARFFSet.COLLECTION.get("home6").iterator());
			}
		}
		
		else if("building".equals(loc)) {
			if("1".equals(floor)) {
				return KWUtils.list(ARFFSet.COLLECTION.get("building1").iterator());
			} else if("5".equals(floor)) {
				return KWUtils.list(ARFFSet.COLLECTION.get("building5").iterator());
			} else if("6".equals(floor)) {
				return KWUtils.list(ARFFSet.COLLECTION.get("building6").iterator());
			} else if("7".equals(floor)) {
				return KWUtils.list(ARFFSet.COLLECTION.get("building7").iterator());
			}
		}
		
		return null;
	}
	
	public static ARFF getARFF(String loc, String floor, String name) {
		if("home".equals(loc)) {
			if("6".equals(floor)) {
				List<ARFF> arffs = KWUtils.list(ARFFSet.COLLECTION.get("home6").iterator());
				for(ARFF arff : arffs) {
					String find = "arff/home/" + name;
					if(find.equals(arff.getFile())) {
						return arff;
					}
				}
			} 
		}
		
		return null;
	}
	
}
