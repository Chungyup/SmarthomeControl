package kr.kw.service;

import java.util.ArrayList;
import java.util.List;

import kr.kw.controller.GWProcess;
import kr.kw.service.contextawareness.ContextAwareness;
import kr.kw.service.contextawareness.Relation;
import kr.kw.service.contextawareness.arff.ARFF;
import kr.kw.service.contextawareness.arff.HomeARFF;
import kr.kw.workingmemory.HomeApplianceManager;
import re.kr.keti.shprotocol.item.IType;
import re.kr.keti.shprotocol.item.Service;

public class ServiceRunner {
	private List<CAPack> caBuffer;

	private ContextAwareness contextAwareness;
	private GWProcess process;
	private HomeApplianceManager ham;
	
	public ServiceRunner(ContextAwareness contextAwareness, GWProcess process, HomeApplianceManager ham) {
		this.contextAwareness = contextAwareness;
		this.process = process;
		this.ham = ham;
		caBuffer = new ArrayList<CAPack>();
		service.start();
		
	}
	
	public void addService(HomeARFF service, Relation relation) {
		if(service != null && relation != null) {
			caBuffer.add(new CAPack(service, relation));
		}
	}
	
	public void start(List<CAPack> caList) {
		Thread t = new Thread(new ServiceRun(caList));
		t.start();
	}
	
	private void contextAwareness(ARFF arff, Relation relation) {
		
		if(GWService.use) {
			double predict = contextAwareness.wekaClassify(arff.getFile(), relation.getInstances());
			
			if(predict >= 0) {
				relation.setPredict((int) predict);
				
				relation.start(process, ham);	
				
				Service service = arff.getService();
				
				service.setSvif("result:" + predict);
				process.collect(IType.SERVICE, service);
			}
		}
	}

	class ServiceRun implements Runnable {
		private List<CAPack> caList;
		
		public ServiceRun(List<CAPack> caList) {
			this.caList = caList;
		}
		
		public void run() {
			for(int i=0; i<caList.size(); i++) {
				CAPack ca = caList.get(i);
				contextAwareness(ca.getService(), ca.getRelation());
			}
		}
		
	}
	
	Thread service = new Thread(new Runnable() {
		public void run() {
			while(true) {
				synchronized(caBuffer) {
					for(int i=0; i<caBuffer.size(); i++) {
						CAPack ca = caBuffer.get(i);
						contextAwareness(ca.getService(), ca.getRelation());
					}	
					caBuffer.clear();
				}
			}
		}
		
	});
}
