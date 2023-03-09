package testdata;

import classesforserializing.User;

public class TestData {
	public User AddUserpayload(String name, String job) {
		User usr= new User();
		usr.setName(name);
		usr.setJob(job);
	    return usr;
	}
}
