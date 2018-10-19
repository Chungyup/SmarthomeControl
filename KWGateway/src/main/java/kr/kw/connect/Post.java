package kr.kw.connect;

import kr.re.keti.socket.KETIServerSocket.KETIClient;

public class Post {
	private To to;
	private KETIClient client;
	private String mesasge;

	public Post(To to, KETIClient client, String mesasge) {
		this.to = to;
		this.client = client;
		this.mesasge = mesasge;
	}
	
	public Post(To to, String mesasge) {
		this.to = to;
		this.mesasge = mesasge;
	}

	public To getTo() {
		return to;
	}

	public void setTo(To to) {
		this.to = to;
	}

	public KETIClient getClient() {
		return client;
	}

	public void setClient(KETIClient client) {
		this.client = client;
	}

	public String getMesasge() {
		return mesasge;
	}

	public void setMesasge(String mesasge) {
		this.mesasge = mesasge;
	}

}
