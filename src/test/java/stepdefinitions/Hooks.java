package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@GetAddedUser")
	public void beforeScenario() throws IOException {
		StepDefinitions sd = new StepDefinitions();
		if(sd.id==null) {
		sd.add_user_payload_with("randomname", "somejob");
		sd.user_calls_with_post_http_request("AddUserEndPoint", "POST");
		sd.in_response_body_is("name", "randomname");
	}
	}
}
