package com.testframework.graphql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class GraphQLQueryTest {

	@Test
	public void getAllFilms() {
		/// https://swapi-graphql.netlify.app/.netlify/functions/index
		RestAssured.baseURI = "https://swapi-graphql.netlify.app";
		String query = "{\"query\":\"{\\n  \\n  allFilms{\\n    totalCount\\n    films{\\n      title\\n      director\\n    }\\n  }\\n}\",\"variables\":null}";

		given().log().all().contentType("application/json").body(query).when().log().all()
				.post("/.netlify/functions/index").then().log().all().assertThat().statusCode(200).and()
				.body("data.allFilms.films[0].title", equalTo("A New Hope"));

	}

	@Test
	public void getAllUsers() {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";

		given().log().all().contentType("application/json").header("authorization",
				"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDdjNTcyZWY4MzkyMDA2OTJjYjBlZiJ9LCJuaWNrbmFtZSI6Im5qbmF5ZWVtIiwibmFtZSI6Im5qbmF5ZWVtQGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci84NTkxZTJkMjEyNjAwNTI3OGIyZDlmOTAzOGFhMWQwMD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRm5qLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIyLTAxLTA3VDA0OjQ1OjM5Ljc0OFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MWQ3YzU3MmVmODM5MjAwNjkyY2IwZWYiLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY0MTY0NTE2MywiZXhwIjoxNjQxNjgxMTYzLCJhdF9oYXNoIjoiek1tTW5wdzJyZXowRkdDYkpid3V6dyIsIm5vbmNlIjoiY3FYRFVVWmJUMHROZjJsWWQ2bTFZOWgxU2l4NTJBaloifQ.C0p4YqEuEm_oAVen2a_Y4bhxAyQvodoNuFB2IC1Br0qWwqtbQuYE5XuQhW79XYoZ2f3uDMoMDKfkw3Bab5OpgE6w7IINIs77yQtg1P-peQFgWrSGXcKbhahskFAg4-yPTk5pyk36CPD_yQIpQ9uBUT3okZxtD_Qohijo8gNIbirsl7Joioivxq7sTnXvGImG2pvSQhZofs8UNbL1gP9JF3B4eM6pxsVkyKcjg55nHlqJPGiF_apoXd_i-xkN-a7mD2wM2gZLyZCxueZnwaFL9dmBHfrm5LtB3touroWVksJb6JFQWKtXu9kjNvIYPA10AEMqkUTnUIfPJYaSMkr7jg")
				.body(query).when().log().all().post("/learn/graphql").then().log().all().assertThat().statusCode(200)
				.and().body("data.users[0].name", equalTo("tui.glen"));

	}

	
	@DataProvider
	public Object[][] getQueryData(){
		return new Object[][] {{"akshayapsangi123", 10}, {"test", 5}};
	}
    
	@Test(dataProvider =  "getQueryData")
	public void getUserWithDataProvider(String name, int limit) {
		RestAssured.baseURI = "https://hasura.io";
		String query = "{\"query\":\"{\\n  users(limit: "+limit+", where: {name: {_eq: \\\""+name+"\\\"}}) {\\n    id\\n    name\\n    todos {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";
		System.out.println(query);
		given().log().all().contentType("application/json").header("authorization",
				"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDdjNTcyZWY4MzkyMDA2OTJjYjBlZiJ9LCJuaWNrbmFtZSI6Im5qbmF5ZWVtIiwibmFtZSI6Im5qbmF5ZWVtQGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci84NTkxZTJkMjEyNjAwNTI3OGIyZDlmOTAzOGFhMWQwMD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRm5qLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIyLTAxLTA3VDA0OjQ1OjM5Ljc0OFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MWQ3YzU3MmVmODM5MjAwNjkyY2IwZWYiLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY0MTY0NTE2MywiZXhwIjoxNjQxNjgxMTYzLCJhdF9oYXNoIjoiek1tTW5wdzJyZXowRkdDYkpid3V6dyIsIm5vbmNlIjoiY3FYRFVVWmJUMHROZjJsWWQ2bTFZOWgxU2l4NTJBaloifQ.C0p4YqEuEm_oAVen2a_Y4bhxAyQvodoNuFB2IC1Br0qWwqtbQuYE5XuQhW79XYoZ2f3uDMoMDKfkw3Bab5OpgE6w7IINIs77yQtg1P-peQFgWrSGXcKbhahskFAg4-yPTk5pyk36CPD_yQIpQ9uBUT3okZxtD_Qohijo8gNIbirsl7Joioivxq7sTnXvGImG2pvSQhZofs8UNbL1gP9JF3B4eM6pxsVkyKcjg55nHlqJPGiF_apoXd_i-xkN-a7mD2wM2gZLyZCxueZnwaFL9dmBHfrm5LtB3touroWVksJb6JFQWKtXu9kjNvIYPA10AEMqkUTnUIfPJYaSMkr7jg")
				.body(query).when().log().all().post("/learn/graphql").then().log().all().assertThat().statusCode(200)
				.and().body("data.users[0].name", equalTo(name));

	}
	
	// using POJO
	@Test(dataProvider =  "getQueryData")
	public void getUserWithPOJO(String name, int limit) {
		RestAssured.baseURI ="https://hasura.io";
		GraphQLQuery query = new GraphQLQuery();
		
		query.setQuery("query ($limit: Int!, $name:String!) {\n"
				+ "  users(limit: $limit, where: {name: {_eq: $name}}) {\n"
				+ "    id\n"
				+ "    name\n"
				+ "  }\n"
				+ "}");
		
		QueryVariable variable = new QueryVariable();
		variable.setLimit(5);
		variable.setName("tui.glen");
		
		query.setVariables(variable);
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYxZDdjNTcyZWY4MzkyMDA2OTJjYjBlZiJ9LCJuaWNrbmFtZSI6Im5qbmF5ZWVtIiwibmFtZSI6Im5qbmF5ZWVtQGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci84NTkxZTJkMjEyNjAwNTI3OGIyZDlmOTAzOGFhMWQwMD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRm5qLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIyLTAxLTA3VDA0OjQ1OjM5Ljc0OFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MWQ3YzU3MmVmODM5MjAwNjkyY2IwZWYiLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY0MTY0NTE2MywiZXhwIjoxNjQxNjgxMTYzLCJhdF9oYXNoIjoiek1tTW5wdzJyZXowRkdDYkpid3V6dyIsIm5vbmNlIjoiY3FYRFVVWmJUMHROZjJsWWQ2bTFZOWgxU2l4NTJBaloifQ.C0p4YqEuEm_oAVen2a_Y4bhxAyQvodoNuFB2IC1Br0qWwqtbQuYE5XuQhW79XYoZ2f3uDMoMDKfkw3Bab5OpgE6w7IINIs77yQtg1P-peQFgWrSGXcKbhahskFAg4-yPTk5pyk36CPD_yQIpQ9uBUT3okZxtD_Qohijo8gNIbirsl7Joioivxq7sTnXvGImG2pvSQhZofs8UNbL1gP9JF3B4eM6pxsVkyKcjg55nHlqJPGiF_apoXd_i-xkN-a7mD2wM2gZLyZCxueZnwaFL9dmBHfrm5LtB3touroWVksJb6JFQWKtXu9kjNvIYPA10AEMqkUTnUIfPJYaSMkr7jg")
			.body(query)
		.when().log().all()
			.post("/learn/graphql")
		.then().log().all()
			.assertThat()
				.statusCode(200)
					.and()
						.body("data.users[0].name", equalTo("tui.glen"));
		
	}
}
