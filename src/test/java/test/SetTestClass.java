package test;


import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SetTestClass {

    final static String email = "tatuka1001@yandex.ru";
    final static String password = "1234567";
    final static String name = "naske";

    public static String createUser() {
        User user = new User(email, password, name);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
        response.
                then().assertThat().statusCode(200)
                .and()
                .assertThat().body("success", equalTo(true));
        String token = new JSONObject(response.getBody().asString()).get("accessToken").toString().substring(7);
        return token;

    }

    public static String loginUser() {
        User user = new User(email, password);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then().extract().response();
        response.then().assertThat().statusCode(200)
                .and()
                .assertThat().body("success", equalTo(true));
        String token = new JSONObject(response.getBody().asString()).get("accessToken").toString().substring(7);
        return token;
    }

    public static void deleteUser(String token) {

        given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2(token)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then().assertThat().statusCode(202);
    }

    private static class User {

        private String email;
        private String password;
        private String name;


        public User(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }

        public User(String email, String password) {
            this.email = email;
            this.password = password;
            this.name = null;
        }

        public User() {

        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
