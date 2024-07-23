package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.response.Response;

public class userendpoints {
	
	public static Response createUser(User payload)
	{
		Response res=given()
						.contentType("application/json")
						.accept("application/json")
						.body(payload)
					.when()
						.post(routes.post_url);
		return res;
	}
	
	public static Response getUser(String user_name)
	{
		Response res=given()
						.pathParam("username", user_name)
					.when()
						.get(routes.get_url);
		return res;
	}
	
	public static Response updateUser(String user_name,User payload)
	{
		Response res=given()
						.contentType("application/json")
						.accept("application/json")
						.pathParam("username", user_name)
						.body(payload)
					.when()
						.put(routes.put_url);
		return res;
	}
	
	public static Response deleteUser(String user_name)
	{
		Response res=given()
						.pathParam("username", user_name)
					.when()
						.delete(routes.delete_url);
		return res;
	}
	
	
	

}
