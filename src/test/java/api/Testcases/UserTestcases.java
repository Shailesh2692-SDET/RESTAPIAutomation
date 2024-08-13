package api.Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Payload.User;
import io.restassured.response.Response;

public class UserTestcases {
	
	// Defining Faker class object from Java Faker dependency
	Faker faker;
	
	// Creating User class object
	User userPayload;
	
	// Creating a logger class object for generating logs
	public static Logger logger;
	
	// First we will create a method to setup and generate fake data for API payload
	// We will set the test annotation @Beforeclass to set up the payload data first before executing any test case
	
	@BeforeClass
	public void generateTestData() {
		
		faker = new Faker();
		
		userPayload = new User();
		
		// Now we will start setting the payload data
		  
		userPayload.setId(faker.idNumber().hashCode());    // Generates unique id everytime
		userPayload.setUsername(faker.name().username());    // Generates unique username everytime
		userPayload.setFirstName(faker.name().firstName());    // Generates unique firstname everytime
		userPayload.setLastName(faker.name().lastName());    // Generates unique lastname everytime 
		userPayload.setEmail(faker.internet().safeEmailAddress());    // Generates unique and safe email address everytime
		userPayload.setPassword(faker.internet().password(5, 10));    // Generates unique and safe password everytime
		userPayload.setPhone(faker.phoneNumber().cellPhone());    // Generates unique phonenumber everytime
		
		
		// Obtain logger i.e. setup logger
		logger = LogManager.getLogger("RestAssuredAPIAutomation");    // Give the name of the project folder inside the bracket	
		
	}
	
	// Below we write the test cases where our first test case is to create user
	// For this, we will create a method and call the create user method inside it defined in the UserEndpoints.java class
	@Test(priority = 1)
	public void testCreateUser() {
		Response response = UserEndpoints.createUser(userPayload);
		
		System.out.println("Create User Data");
		
		// Log the response received from server
		response.then().log().all();
		
		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Create log
		logger.info("Create User Executed...");
		
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		Response response = UserEndpoints.getUser(this.userPayload.getUsername());
		
		System.out.println("Read User Data");
		
		// Log the response received from server
		response.then().log().all();
		
		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Create log
		logger.info("Get User Data Executed...");
		
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		// We are only updating first name of the user
		userPayload.setFirstName(faker.name().firstName());
		
		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		
		// Log the response received from server
		response.then().log().all();
		
		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Get updated user data
		Response responsePostUpdate = UserEndpoints.getUser(this.userPayload.getUsername());

		System.out.println("Update User Data");
		
		responsePostUpdate.then().log().all();
		
		// Create log
		logger.info("Update User Executed...");
		
	}
	
	@Test(priority = 4)
	public void testdeleteUser() {		
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		
		System.out.println("Delete User Data");
		
		// Log the response received from server
		response.then().log().all();
		
		// Validation part
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Create log
		logger.info("Delete User Executed...");
		
	}

}
