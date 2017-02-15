package com.capgemini.docker;

import com.capgemini.docker.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloDockerApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getMessageFromTestRequestMapping() {
		String message = this.restTemplate.getForObject("/message", String.class);
		assertThat(message, is(notNullValue()));
		assertThat(message, equalTo("Test Message"));
	}

	@Test
	public void getMessageFromHomeURL() {
		ResponseEntity<Message> response = this.restTemplate.getForEntity("/", Message.class);
		boolean statusIsOK = response.getStatusCode().is2xxSuccessful();
		// Assert 200-OK Success
		assertThat(statusIsOK, is(true));
		// Assert response is Not null
		assertThat(response, is(notNullValue()));
		// Assert ID of Message is not equal to 0
		assertThat(response.getBody().getId(), not(equalTo(0)) );
	}

}
