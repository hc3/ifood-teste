package br.com.ifood;

import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

import br.com.ifood.repositories.MusicRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class ApplicationTests {

	JSONObject musicJson = new JSONObject();

	private static MusicRepository musicRepository;

	@Autowired
	public void setRepository(MusicRepository customerRepository) {
		ApplicationTests.musicRepository = customerRepository;
	}

	@Before
	public void setup() throws JSONException {
		musicJson.put("lat", "43.653225");
		musicJson.put("lon", "-79.383186");
		RestAssured.port = 3000;
		RestAssured.baseURI = "http://localhost";
	}

	@AfterClass
	public static void drop() {
		musicRepository.deleteAll();
	}

	@Test
	public void searchMusicLatLon() {
		given()
			.contentType("application/json")
			.body(musicJson.toString())
			.when()
			.post("/api/v1/music")
			.then()
			.statusCode(HttpStatus.OK.value())
			.extract()
			.response();
	}

}
