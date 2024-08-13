package api.Endpoints;

// Use this class to maintain only URLs of all the modules and we won't create any methods inside this class
public class Routes {

	// Create public static string variable to store base URL which is common for
	// all API endpoints
	public static String baseUrl = "https://petstore.swagger.io/v2";

	// User module URL's
	// POST Request - Create user
	public static String postUrl = baseUrl + "/user";

	// POST Request - GET user
	public static String getUrl = baseUrl + "/user/{username}";

	// PUT Request - Update user
	public static String putUrl = baseUrl + "/user/{username}";

	// DELETE Request - Delete user
	public static String deleteUrl = baseUrl + "/user/{username}";
	
	
	// We can specify below the URLs for other modules
	// Pet module URL's
	
	
	
	
	// Store module URL's
	
	
	
	

}
