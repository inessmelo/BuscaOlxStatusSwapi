package swapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PeopleStarWars {
	
	private String url = "https://swapi.dev/api";
	
	@Test
	public void getPeople() {
		String endpoint = "/people/1/";
		RestAssured.baseURI = url;
				
		Response resposta = RestAssured
				.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.when().get(endpoint)
				.then().statusCode(200)
				.extract().response();
		
		JsonPath json = resposta.getBody().jsonPath();
		
		//validação do Body em JSON
		assertEquals(200, resposta.getStatusCode());
		assertEquals("Luke Skywalker", json.get("name"));
		assertEquals("172", json.get("height"));
		assertEquals("77", json.get("mass"));
		assertEquals("blond", json.get("hair_color"));
		assertEquals("fair", json.get("skin_color"));
		assertEquals("blue", json.get("eye_color"));
		assertEquals("19BBY", json.get("birth_year"));
		assertEquals("male", json.get("gender"));
		assertEquals("http://swapi.dev/api/planets/1/", json.get("homeworld"));
		assertEquals("2014-12-09T13:50:51.644000Z", json.get("created"));
		assertEquals("2014-12-20T21:17:56.891000Z", json.get("edited"));
		assertEquals("http://swapi.dev/api/people/1/", json.get("url"));
	}
	
	@Test
	public void getPlanet() {
		String endpoint = "/planets/3/";
		RestAssured.baseURI = url;
				
		Response resposta = RestAssured
				.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.when().get(endpoint)
				.then().statusCode(200)
				.extract().response();
		
		JsonPath json = resposta.getBody().jsonPath();
		
		//validação do Body em JSON		
		assertEquals(200, resposta.getStatusCode());
		assertEquals("Yavin IV", json.get("name"));
		assertEquals("24", json.get("rotation_period"));
		assertEquals("4818", json.get("orbital_period"));
		assertEquals("10200", json.get("diameter"));
		assertEquals("temperate, tropical", json.get("climate"));
		assertEquals("1 standard", json.get("gravity"));
		assertEquals("jungle, rainforests", json.get("terrain"));
		assertEquals("8", json.get("surface_water"));
		assertEquals("1000", json.get("population"));
		assertEquals("2014-12-10T11:37:19.144000Z", json.get("created"));
		assertEquals("2014-12-20T20:58:18.421000Z", json.get("edited"));
		assertEquals("http://swapi.dev/api/planets/3/", json.get("url"));
	}
	
	@Test
	public void getStarShip() {
		String endpoint = "/starships/9/";
		RestAssured.baseURI = url;
				
		Response resposta = RestAssured
				.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.when().get(endpoint)
				.then().statusCode(200)
				.extract().response();
		
		JsonPath json = resposta.getBody().jsonPath();
		
		//validação do Body em JSON		
		assertEquals(200, resposta.getStatusCode());
		assertEquals("Death Star", json.get("name"));
		assertEquals("DS-1 Orbital Battle Station", json.get("model"));
		assertEquals("Imperial Department of Military Research, Sienar Fleet Systems", json.get("manufacturer"));
		assertEquals("1000000000000", json.get("cost_in_credits"));
		assertEquals("120000", json.get("length"));
		assertEquals("n/a", json.get("max_atmosphering_speed"));
		assertEquals("342,953", json.get("crew"));
		assertEquals("843,342", json.get("passengers"));
		assertEquals("1000000000000", json.get("cargo_capacity"));
		assertEquals("3 years", json.get("consumables"));
		assertEquals("4.0", json.get("hyperdrive_rating"));
		assertEquals("10", json.get("MGLT"));
		assertEquals("Deep Space Mobile Battlestation", json.get("starship_class"));
		assertEquals("2014-12-10T16:36:50.509000Z", json.get("created"));
		assertEquals("2014-12-20T21:26:24.783000Z", json.get("edited"));
		assertEquals("http://swapi.dev/api/starships/9/", json.get("url"));
	}
}
