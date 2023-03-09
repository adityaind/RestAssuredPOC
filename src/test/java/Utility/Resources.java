package Utility;

public enum Resources {
	AddUserEndPoint("/api/users"),
	GetSingleUserEndpoint("/api/users/{usrid}");

	private String resource;
	

	Resources(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return this.resource;
	}
}
