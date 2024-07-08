package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.*;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;


public class UserTests {

	Faker faker;	
	User userPayload;
	public Logger logger;

	@BeforeClass
	void setupData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setUsername(faker.name().username());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		//logs
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority=1)
	public void testPOSTUser() {
		logger.info("*************** Creating User *******************");
		Response response =UserEndPoints.createUser(userPayload);

		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************** User Created *******************");	

	}

	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("*************** Reading User Info *******************");			
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().log().all();
		logger.info("*************** User info is displayed *******************");	

	}

	@Test(priority=3)
	public void testUpdateUserByName() {
		logger.info("*************** Updating User *******************");	

		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());

		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().log().all();
		logger.info("*************** User Updated *******************");	

		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
	}
	@Test(priority=4)
	public void testDeleteUser() {
		logger.info("*************** Deleting User *******************");	

		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*************** User Deleted *******************");	

	}

}
