package api.Endpoints;

import static io.restassured.RestAssured.*;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Use this class to create API request methods for user module only
// For each separate module of API requests, we create a different class always to create API request methods for the same

public class UserEndpoints {

	// Declare methods
	// POST - Create user
	// The User payload object defined below as method parameter is the object of class User 
	public static Response createUser(User payload) {

		// The below snippet is a replica of swagger curl response where
		// accept defines, what content type is accepted. Here json
		// contentType defines what content we are sending with request. Here json
		// and body is the payload body

		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				// Now we send the POST request on a URL
				.when()

				// Specify the postUrl variable declared inside Routes.java class in which we
				// have stored the URL where we send the POST request
				.post(Routes.postUrl);

		return response;

	}

	// GET - Get User
	public static Response getUser(String userName) {

		// The below snippet is a replica of swagger curl response where
		// accept defines, what content type is accepted. Here json
		// We don't define contentType here, because there is no request body being sent
		// path parameter is the parameter to be sent to the URL for getting the data

		Response response = given()
				.accept(ContentType.JSON)
				// username in double quotes is from URL defined in Routes.java as variable named getUrl
				.pathParam("username", userName)

				// Now we send the GET request on a URL
				.when()

				// Specify the getUrl variable declared inside Routes.java class in which we
				// have stored the URL where we send the GET request
				.get(Routes.getUrl);

		return response;

	}
	
	// PUT - Update User
	// The User payload object defined below as method parameter is the object of class User
	public static Response updateUser(String userName, User payload) {

		// The below snippet is a replica of swagger curl response where
		// accept defines, what content type is accepted. Here json
		// contentType defines what content we are sending with request. Here json
		// and body is the payload body

		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				// username in double quotes is from URL defined in Routes.java as variable named getUrl
				.pathParam("username", userName)
				
				.body(payload)

				// Now we send the GET request on a URL
				.when()

				// Specify the putUrl variable declared inside Routes.java class in which we
				// have stored the URL where we send the PUT request
				.put(Routes.putUrl);

		return response;

		}
	
	// DELETE - Delete User
	public static Response deleteUser(String userName) {

		// The below snippet is a replica of swagger curl response where
		// accept defines, what content type is accepted. Here json
		// We don't define contentType here, because there is no request body being sent
		// path parameter is the parameter to be sent to the URL for getting the data

		Response response = given()
				.accept(ContentType.JSON)
				// username in double quotes is from URL defined in Routes.java as variable named getUrl
				.pathParam("username", userName)

				// Now we send the GET request on a URL
				.when()

				// Specify the deleteUrl variable declared inside Routes.java class in which we
				// have stored the URL where we send the DELETE request
				.delete(Routes.deleteUrl);

		return response; 

		}

}
