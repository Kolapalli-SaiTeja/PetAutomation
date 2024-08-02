package endPoints;

/*

In the Routes section we are gonna maintain all the URL's of the USER module

Swagger URI > https://petstore.swagger.io/
Create User (POST) -----> https://petstore.swagger.io/v2/user
Get User (GET) ----> https://petstore.swagger.io/v2/user/{username}
Update user (PUT) ----->https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) -----> https://petstore.swagger.io/v2/user/{username}

 */

public class Routes {


    // USER MODULE
    public static String Base_Url = "https://petstore.swagger.io/v2";
    public static String Post_Url = Base_Url + "/user";

    public static String Get_Url = Base_Url + "/user/{username}";

    public static String Update_Url = Base_Url + "/user/{username}";

    public static String Delete_Url = Base_Url + "/user/{username}";

}
