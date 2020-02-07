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
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/create", null,
                String.class)).contains("\"id\":1");

        // add a buddy
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/add?bookId=1&name=Fahid&address=123Carleton&phoneNum=90210", null,
                String.class)).contains("\"name\":\"Fahid\"");

        // add another buddy
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/add?bookId=1&name=Jeffrey&address=5678Ottawa&phoneNum=555", null,
                String.class)).contains("\"phoneNum\":555");

        // remove second buddy
        assertThat(!(this.restTemplate.postForObject("http://localhost:" + port + "/remove?bookId=1&name=Jeffrey&address=5678Ottawa&phoneNum=555", null,
                String.class)).contains("\"phoneNum\":555"));
    }
}