package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestBasicApi {

    String authToken = "04a21f03cf60ea16e30589ff97237dfc1100c61255c0cca2f848e90aa18c434d";

    @Test
    public void apiTest() {


        RequestSpecification reqSpec = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + authToken).
                addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter())).
                build();

        String endPointUsers = "/public-api/users/{userId}";
        String endPointPostUser = "/public-api/users/";
        String endPointPosting = "/public-api/posts";
        String endPointPosts = "/public-api/posts/{postId}";

        Map user = new HashMap<>();
        user.put("name", "Testavimo Exam00200");
        user.put("email", "TestavimoExam00200@email.com");
        user.put("gender", "male");
        user.put("status", "inactive");


        int userId = given().spec(reqSpec).
                body(user).
                when().
                post(endPointPostUser).
                then().
                assertThat().
                body("code", is(201)).
                extract().path("data.id");

        Map post = new HashMap<>();
        post.put("user", user.get("name"));
        post.put("user_id", userId);
        post.put("title", "ExamTitle");
        post.put("body", "BodyOfPost at Exam");

        given().spec(reqSpec).
                pathParam("userId", userId).
                log().all().
                when().
                get(endPointUsers).
                then().
                assertThat().
                body("code", is(200)).
                body("data.name", is("Testavimo Exam00200")).
                body("data.email", is("TestavimoExam00200@email.com")).
                body("data.gender", is("male")).
                body("data.status", is("inactive")).
                log().all();

        //given().spec(reqSpec).body("").when().post(endPointPosting).then().assertThat().body("code", is(201)).extract().path("data.id");

       int postId = given().spec(reqSpec).
                body(post).
                when().
                post(endPointPosting).
                then().
                assertThat().
                body("code", is(201)).
                extract().path("data.id");




       given().spec(reqSpec).
                pathParam("postId", postId).
                log().all().
                when().
                get(endPointPosts).
                then().
                assertThat().
                body("code", is(200)).
                body("data.user_id", is(userId)).
                body("data.title", is("ExamTitle")).
                body("data.body", is("BodyOfPost at Exam")).
                log().all();

        given().spec(reqSpec).
                pathParam("postId", postId).
                when().
                delete(endPointPosts).
                then().
                log().all().
                assertThat().
                body("code", is(204));


        given().spec(reqSpec).
                pathParam("postId", postId).
                when().
                delete(endPointPosts).
                then().
                log().all().
                assertThat().
                body("code", is(404));



    }
}
