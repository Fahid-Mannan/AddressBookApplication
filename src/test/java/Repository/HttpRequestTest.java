package Repository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRestApplication() throws Exception {
        // create the address book
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/create", null,
                String.class)).contains("\"id\":1");

        // add a buddy
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/add?bookId=1&name=Fahid&address=123Carleton&phoneNum=90210", null,
                String.class)).contains("\"name\":\"Fahid\"").contains("\"address\":\"123Carleton\"").contains("\"phoneNum\":90210");

        // check that the added buddy persisted correctly
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/get", String.class).contains("\"name\":\"Fahid\""));

        // add another buddy
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/add?bookId=1&name=Jeffrey&address=5678Ottawa&phoneNum=555", null,
                String.class)).contains("\"phoneNum\":555").contains("\"address\":\"5678Ottawa\"").contains("\"phoneNum\":555");

        // check that the added buddy persisted correctly
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/get", String.class).contains("\"name\":\"Jeffrey\""));

        // remove second buddy
        assertThat(!(this.restTemplate.postForObject("http://localhost:" + port + "/api/remove?bookId=1&name=Jeffrey&address=5678Ottawa&phoneNum=555", null,
                String.class)).contains("\"phoneNum\":555"));

        // check that the added buddy persisted correctly
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/get", String.class).contains("\"name\":\"Fahid\""));

        // check that the removed buddy persisted correctly
        assertThat(!(this.restTemplate.getForObject("http://localhost:" + port + "/api/get", String.class).contains("\"name\":\"Jeffrey\"")));
    }
}