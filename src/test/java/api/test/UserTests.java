package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	//creating objects for faker and user defined  POJO class
	
	Faker faker;
	User payload;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		payload=new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5,10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		
	}
		
		@Test(priority =1)
		public void testPostUser()
		{
			logger.info("***********Before creating user****");
			Response response=userendpoints.createUser(payload);
			response.then().log().body();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("***********user is created*********");
		}
		
		@Test(priority = 2)
		public void testGetUser()
		{
			logger.info("***********Before reading user****");
			Response response=userendpoints.getUser(this.payload.getUsername());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("***********user info is displayed*********");
		}
		
		@Test(priority =3)
		public void testUpdateUser()
		{
			logger.info("***********Before updating the user*********");
			payload.setFirstName(faker.name().firstName());
			payload.setLastName(faker.name().lastName());
			payload.setEmail(faker.internet().safeEmailAddress());
			
			Response response=userendpoints.updateUser(this.payload.getUsername(),payload);
			response.then().log().body();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("***********user is updated*********");
			
			//checking data after updating.....
			Response responseafterupdate=userendpoints.getUser(this.payload.getUsername());		               
			Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		}
		
		@Test(priority = 4)
		public void testDeleteUser()
		{
			logger.info("***********Before deleting the user*********");
			Response response=userendpoints.deleteUser(this.payload.getUsername());
			
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			
			logger.info("***********user is deleted*********");
		}
		
		
		
	}
	
	
	
	


