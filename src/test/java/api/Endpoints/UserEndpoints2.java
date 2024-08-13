package api.Endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Use this class to create API request methods for user module only
// For each separate module of API requests, we create a different class always to create API request methods for the same

public class UserEndpoints2 {
	
	// Creating a static ResourceBundle method named getURL() to read the URLs from the Routes.properties file
	static ResourceBundle getURL() {
		
		// Creating ResourceBundle object
		// Specify property file name i.e. here Routes inside getBundle method to access it directly from src/test/resources folder
		ResourceBundle routes = ResourceBundle.getBundle("Routes");    // We are loading proprty file here
		return routes;
		
	}

	// Declare methods
	// POST - Create user
	// The User payload object defined below as method parameter is the object of class User 
	public static Response createUser(User payload) {
		
		// Create a varible postUrl to fetch it and use it from Routes.properties file
		String postUrl = getURL().getString("post_url");

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

				// Specify the postUrl variable declared above where we will send the POST request
				.post(postUrl);

		return response;

	}

	// GET - Get User
	public static Response getUser(String userName) {
		
		// Create a varible getUrl to fetch it and use it from Routes.properties file
		String getUrl = getURL().getString("get_url");

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

				// Specify the getUrl variable declared above where we will send the GET request
				.get(getUrl);

		return response;

	}
	
	// PUT - Update User
	// The User payload object defined below as method parameter is the object of class User
	public static Response updateUser(String userName, User payload) {
		
		// Create a variable putUrl to fetch it and use it from Routes.properties file
	    String putUrl = getURL().getString("update_url");

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

				// Specify the putUrl variable declared above where we will send the PUT request
				.put(putUrl);

		return response;

		}
	
	// DELETE - Delete User
	public static Response deleteUser(String userName) {
		
		// Create a variable putUrl to fetch it and use it from Routes.properties file
	    String deleteUrl = getURL().getString("delete_url");

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

				// Specify the deleteUrl variable declared above where we will send the DELETE request
				.delete(deleteUrl);

		return response; 

		}

}
