package kr.kw.workingmemory;

import java.util.ArrayList;
import java.util.List;

import kr.kw.user.GWUser;

public class UserManager {
	private List<GWUser> users;

	public UserManager() {
		users = new ArrayList<GWUser>();
	}
	
	public void addUser(GWUser user) {
		users.add(user);
	}
	
	public List<GWUser> getUsers() {
		return users;
	}
	
	public GWUser getUser(int tagId) {
		for(GWUser user : users) {
			if(user.has(tagId)) {
				return user;
			}
		}
		
		return null;
	}
	
	public int locationCount(int loc) {
		int count = 0;
		for(GWUser user : users) {
			if(user.getTag().getReaderId() == loc) {
				count++;
			}
		}
		
		return count;
	}
	
	@Override
	public String toString() {
		String userList = "";
		for (GWUser user : users) {
			userList += user.toString() + "\n\t";
		}
		return userList;
	}
}
