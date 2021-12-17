import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class restAssuredTest {

   RequestSpecification requestSpec;

    @BeforeTest
    void yap(){
                 requestSpec = RestAssured.given()
                         .baseUri("https://imdb8.p.rapidapi.com")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .header("x-rapidapi-key", "ccb105c1demsh7a7301702dcf3c5p1f7d1djsn86504e7cdfdc");

    }

    @Test
    void basarili_giris(){

        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get("/actors/get-known-for?nconst=nm0001667")
                .then()
                .statusCode(200);


    }



    @Test
    void rayting_kontrolu(){

        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get("/actors/get-known-for?nconst=nm0001667")
                .then()
                .body("imdbRating[0]",equalTo(7.4F));


    }

    @Test
    void odul_ismi_arama(){

        RestAssured.given()
                .spec(requestSpec)
                .when()
                .get("/actors/get-awards?nconst=nm0001667")
                .then()
                .statusCode(200)
                .body("resource.awards.awardName[0]",equalTo("ALFS Award"));
              //  .log().all();

    }
@Test
    void aktorlerin_meslek_kontrolu(){
     RestAssured.given()
                .spec(requestSpec)
                .when()
                .get("/actors/get-interesting-jobs?nconst=nm0001667")
                .then()
                .statusCode(200)
                .body("",hasItems("actor","producer", "soundtrack"));
    }

    @Test
    void isim_kontrolü(){
        RestAssured.given()
                .spec(requestSpec)
                .when()
                .get("/title/get-seasons?tconst=tt0944947")
                .then()
                .statusCode(200)
                .body("episodes[0].title[0]",containsString("Winter"));
    }

}
