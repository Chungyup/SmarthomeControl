package kr.kw.service.contextawareness.arff;

import re.kr.keti.shprotocol.item.Service;

public enum Building6ARFF implements ARFF {
	HA {
		public String getFile() {
			return "arff/6floor/BMS6floorApplianceControl.arff";
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
			return "arff/6floor/BMS6floorDoorlockControl.arff";
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
			return "arff/6floor/BMS6floorLightControl.arff";
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
