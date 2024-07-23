package api.endpoints;

/* Swagger https://petstore.swagger.io/
 * Post   :https://petstore.swagger.io/v2/user
 * Get	  :https://petstore.swagger.io/v2/user/{username}
 * put    :https://petstore.swagger.io/v2/user/{username}
 * delete :https://petstore.swagger.io/v2/user/{username}
 */

public class routes {
	
	public static String base_url="https://petstore.swagger.io/v2";

		//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store module
	public static String store_post_url=base_url+"/store";
	public static String store_get_url=base_url+"/store/{username}";
	public static String store_put_url=base_url+"/store/{username}";
	public static String store_delete_url=base_url+"/store/{username}";
	
	
	
}
