package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class datadriventest {
	
	@Test(priority = 1,dataProvider="data",dataProviderClass=Dataproviders.class)
	public void testmultplepostuserreq(String id,String usrName,String fname,String lname,String email,String pwd,String ph)
	{
		User payload=new User();
		payload.setId(Integer.parseInt(id));
		payload.setUsername(usrName);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		Response response=userendpoints.createUser(payload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2,dataProvider="usernames",dataProviderClass=Dataproviders.class)
	public void testdeletemultiuser(String usrname)
	{
		Response response=userendpoints.deleteUser(usrname);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
