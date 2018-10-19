package kr.kw.service;

import kr.kw.database.DatabaseMapper;
import re.kr.keti.shprotocol.item.Service;

public class SHService extends Service implements DatabaseMapper {

	public SHService(String gwId, String relation) {
		String[] info = relation.split("_");
		setGwid(gwId);
		setSvid(info[0]);
		setCtg(info[1]);
		setSvnm(info[2]);
		setSvtp(info[3]);
		setSvvs(info[4]);
	}

	public void mapping() {
		// TODO Auto-generated method stub
		
	}

}
