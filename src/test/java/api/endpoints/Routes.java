package api.endpoints;

/* Swagger url :  https://petstore.swagger.io/
 * 
 * base url:  https://petstore.swagger.io/v2/
 * 
 * User Module
 * -----------
 * 
 * create user: https://petstore.swagger.io/v2/user 
 * get user: https://petstore.swagger.io/v2/user/{username}
 * update user: https://petstore.swagger.io/v2/user/{username}
 * delete user: https://petstore.swagger.io/v2/user/{username}  
 * 	
*/

// Routes class contain only url's of all the available modules of the project
//------------------------------------------------------------------------------
public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module
	
	public static String user_post_url = base_url+"/user";
	public static String user_get_url = base_url+"/user/{username}";
	public static String user_update_url = base_url+"/user/{username}";
	public static String user_delete_url = base_url+"/user/{username}";
	
	//Store module
	
	public static String store_post_url = base_url+"/store/order";
	public static String store_get_url = base_url+"/store/order/{orderId}";
//	public static String store_post_url = base_url+"/store/order";
	public static String store_delete_url = base_url+"/store/order/{orderId}";
	
	//Pet module
	//write Pet module url's
	

	
			
}


