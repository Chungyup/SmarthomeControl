package kr.kw.service;

import kr.kw.service.contextawareness.Relation;
import kr.kw.service.contextawareness.arff.ARFF;

public class CAPack {
	ARFF service;
	Relation relation;
	
	public CAPack(ARFF service, Relation relation) {
		this.service = service;
		this.relation = relation;
	}
	
	public ARFF getService() {
		return service;
	}
	
	public Relation getRelation() {
		return relation;
	}
}
