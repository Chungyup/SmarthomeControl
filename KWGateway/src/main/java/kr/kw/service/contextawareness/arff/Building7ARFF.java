package kr.kw.service.contextawareness.arff;

import re.kr.keti.shprotocol.item.Service;

public enum Building7ARFF implements ARFF {
	HA {
		public String getFile() {
			return "arff/7floor/BMS7floorApplianceControl.arff";
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
	DOORLOCK {
		public String getFile() {
			return "arff/7floor/BMS7floorDoorlockControl.arff";
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
			return "arff/7floor/BMS7floorLightControl.arff";
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
