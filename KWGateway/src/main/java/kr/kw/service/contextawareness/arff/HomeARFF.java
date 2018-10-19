package kr.kw.service.contextawareness.arff;

import re.kr.keti.shprotocol.item.Service;

public enum HomeARFF implements ARFF {
	BATHROOM {
		public String getFile() {
			return "arff/home/Bathroom.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10019;
		}
	},
	BEDROOM1 {
		public String getFile() {
			return "arff/home/Bedroom1.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10015;
		}
	},
	BEDROOM2 {
		public String getFile() {
			return "arff/home/Bedroom2.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10018;
		}
	},
	KITCHEN {

		public String getFile() {
			return "arff/home/Kitchen.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10014;
		}
	},
	LIVINGROOM {
		public String getFile() {
			return "arff/home/Livingroom.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10017;
		}
	},
	ENTRY {
		public String getFile() {
			return "arff/home/Entry.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10016;
		}
	},
	OUTSIDE {
		public String getFile() {
			return "arff/home/Outside.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10004;
		}
	},
	SLEEPWAKEUP {
		public String getFile() {
			return "arff/home/SleepWakeUp.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return -1;
		}
	},
	TVZONE {

		public String getFile() {
			return "arff/home/TVzone.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10013;
		}
	},
	HEATER {

		public String getFile() {
			return "arff/home/Bedroom2Heater.arff";
		}
		
		private Service service;
		
		public void setService(Service service) {
			this.service = service;
		}

		public Service getService() {
			return service;
		}
		
		public int getLocation() {
			return 10018;
		}
	};

	HomeARFF() {

	}
}
