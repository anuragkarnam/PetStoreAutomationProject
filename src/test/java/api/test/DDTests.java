package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider = "Data", dataProviderClass=DataProviders.class)
	public void testPostuser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone) {
	User userPayload = new User();
	
	userPayload.setId(Integer.parseInt(UserID));
	userPayload.setUsername(UserName);
	userPayload.setFirstName(FirstName);
	userPayload.setLastName(LastName);
	userPayload.setEmail(Email);
	userPayload.setPassword(Password);
	userPayload.setPhone(Phone);
	
	Response response =UserEndPoints.createUser(userPayload);
	//response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	@Test(priority=2, dataProvider = "UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}	
	
	
}
