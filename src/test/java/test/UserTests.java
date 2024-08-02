package test;

import Payload.User;
import com.github.javafaker.Faker;
import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {


    Faker faker;

    User userPayload;

   @BeforeClass
    public void SetupData() {


        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.number().randomDigitNotZero());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().phoneNumber());
        userPayload.setUserStatus(faker.number().numberBetween(1,100));

    }

    @Test
    public void testPostUser(){


      Response response = UserEndPoints.CreateUser(userPayload);

        response.then().log().all();

        Assert.assertEquals(response.statusCode(),200);


        Response responseAfterPost = UserEndPoints.ReadUser(this.userPayload.getUsername());

        responseAfterPost.then().log().body();

    }


   @Test (priority = 1)
    public void testReadUser(){


        Response response = UserEndPoints.ReadUser(this.userPayload.getUsername());

        response.then().log().all();


        Assert.assertEquals(response.statusCode(),200);


    }

    @Test(priority = 2)
    public void testUpdateUser(){


        Response response = UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);

        response.then().log().all().extract().path("username", "password");

        Assert.assertEquals(response.statusCode(),200);

//update user
        Response responseAfterUpdate = UserEndPoints.ReadUser(this.userPayload.getUsername());

        responseAfterUpdate.then().log().body();

    }


    @Test (priority = 3)
    public void testDeleteUser(){


        Response response = UserEndPoints.ReadUser(this.userPayload.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.statusCode(),200);

        Response responseAfterDelete = UserEndPoints.ReadUser(this.userPayload.getUsername());

        responseAfterDelete.then().log().body();


    }

}
