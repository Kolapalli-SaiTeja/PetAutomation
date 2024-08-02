package test;

import Payload.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Dataproviders;

public class DDTests {

    User userpayload;


    @Test ( dataProvider = "Data", dataProviderClass = Dataproviders.class)
    public void testPOSTUser(String userId, String userName, String fname, String lname, String useremail, String pwd, String phn){


         userpayload = new User();

        userpayload.setId(Integer.parseInt(userId));
        userpayload.setUsername(userName);
        userpayload.setFirstName(fname);
        userpayload.setLastName(lname);
        userpayload.setEmail(useremail);
        userpayload.setPassword(pwd);
        userpayload.setPhone(phn);

        Response response = UserEndPoints.CreateUser(userpayload);

        response.then().log().body();

        Response responseAfterPost = UserEndPoints.ReadUser(this.userpayload.getUsername());

        responseAfterPost.then().log().body();


    }


    @Test (priority = 1, dataProvider = "UserNames", dataProviderClass = Dataproviders.class)
    public void testGetUserByName(String userName)
    {

       Response response = UserEndPoints.ReadUser(userName);

        response.then().log().body();

        Assert.assertEquals(response.statusCode(), 200);

    }



}
