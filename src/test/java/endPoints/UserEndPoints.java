package endPoints;
import Payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*UserEndPoints
                  <----------CRUD--------------->
//Created to perform Create, Read, Update, Delete requests for the User API
*/
public class UserEndPoints {

    static RequestSpecification requestSpecification;

    static Response response;

    public static Response CreateUser(User payload) {

        requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON).accept(ContentType.JSON);

        requestSpecification.body(payload);

        response = requestSpecification.when().post(Routes.Post_Url);

        return response;

    }

    public static Response ReadUser(String UserName) {

        requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON).accept(ContentType.JSON);
        requestSpecification.pathParam("username", UserName);

        response = requestSpecification.when().get(Routes.Get_Url);

        return response;

    }

    public static Response UpdateUser(String UserName, User payload) {

        requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON).accept(ContentType.JSON);
        requestSpecification.pathParam("username", UserName);

        requestSpecification.body(payload);

        response = requestSpecification.when().put(Routes.Update_Url);

        return response;


    }


    public static Response DeleteUser(String UserName) {

        requestSpecification = RestAssured.given();

        requestSpecification.contentType(ContentType.JSON).accept(ContentType.JSON);
        requestSpecification.pathParam("username", UserName);

        response = requestSpecification.when().delete(Routes.Delete_Url);

        return response;

    }
}
