package kr.kw.service.contextawareness.arff;

import re.kr.keti.shprotocol.item.Service;

public enum Building1ARFF implements ARFF {
	HA {
		public String getFile() {
			return "arff/1floor/BMS1floorApplianceControl.arff";
		}

		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}

		public int getLocation() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	LIGHT {
		public String getFile() {
			return "arff/1floor/BMS1floorLightControl.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}
