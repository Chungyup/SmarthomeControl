package kr.kw.service.contextawareness.arff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ARFFSet {
	@SuppressWarnings("serial")
	public static final Map<String, List<ARFF>> COLLECTION = new HashMap<String, List<ARFF>>() {
		{
			put("home6", Arrays.asList(
					(ARFF) HomeARFF.BATHROOM, 
					(ARFF) HomeARFF.BEDROOM1, 
					(ARFF) HomeARFF.BEDROOM2, 
					(ARFF) HomeARFF.KITCHEN,
					(ARFF) HomeARFF.LIVINGROOM, 
					(ARFF) HomeARFF.ENTRY,
					(ARFF) HomeARFF.OUTSIDE,
					(ARFF) HomeARFF.SLEEPWAKEUP, 
					(ARFF) HomeARFF.TVZONE,
					(ARFF) HomeARFF.HEATER));
			
			put("building1", Arrays.asList(
					(ARFF) Building1ARFF.HA, 
					(ARFF) Building1ARFF.LIGHT));
			
			put("building5", Arrays.asList(
					(ARFF) Building5ARFF.HA, 
					(ARFF) Building5ARFF.LIGHT, 
					(ARFF) Building5ARFF.DOORLOCK));
			
			put("building6", Arrays.asList(
					(ARFF) Building6ARFF.HA, 
					(ARFF) Building6ARFF.LIGHT, 
					(ARFF) Building6ARFF.DOORLOCK));
			
			put("building7", Arrays.asList(
					(ARFF) Building7ARFF.HA, 
					(ARFF) Building7ARFF.LIGHT, 
					(ARFF) Building7ARFF.DOORLOCK));
		}
	};

}
