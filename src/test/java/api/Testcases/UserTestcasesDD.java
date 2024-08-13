package api.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.UserEndpoints;
import api.Payload.User;
import api.Utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestcasesDD {

	// First we will create a method to setup and generate fake data for API payload
	// We will set the test annotation @Beforeclass to set up the payload data first
	// before executing any test case


	// For this, we will create a method and call the create user method inside it
	// defined in the UserEndpoints.java class
	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(int userId, String userName, String firstName, String lastName, String email,
			String password, String phone) {
		
		// Creating User class object
		User userPayload = new User();
		
		userPayload.setId(userId); // Generates unique id everytime
		userPayload.setUsername(userName); // Generates unique username everytime
		userPayload.setFirstName(firstName); // Generates unique firstname everytime
		userPayload.setLastName(lastName); // Generates unique lastname everytime
		userPayload.setEmail(email); // Generates unique and safe email address everytime
		userPayload.setPassword(password); // Generates unique and safe password everytime
		userPayload.setPhone(phone); // Generates unique phonenumber everytime

		Response response = UserEndpoints.createUser(userPayload);

		System.out.println("Create User Data");

		// Log the response received from server
		response.then().log().all();

		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUser(String userName) {
		Response response = UserEndpoints.getUser(userName);
		
		System.out.println("Read User Data");
		
		// Log the response received from server
		response.then().log().all();
		
		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	@Test(priority = 3, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testdeleteUser(String userName) {
		Response response = UserEndpoints.deleteUser(userName);

		System.out.println("Delete User Data");

		// Log the response received from server
		response.then().log().all();

		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
