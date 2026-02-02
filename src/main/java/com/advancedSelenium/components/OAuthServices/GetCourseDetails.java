package com.advancedSelenium.components.OAuthServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

public class GetCourseDetails {

    @Getter
    private Response response;

    @Setter
    private static String accessToken;

    private final String url = "https://rahulshettyacademy.com/";
    private final String baseUri = "/oauthapi/getCourseDetails";

    private void courseDetailsGetCall() {
        response = RestAssured.given()
                .baseUri(url)
                .queryParam("access_token", accessToken)
                .when().get(baseUri)
                .then().extract().response();
    }

    public GetCourseDetails() {
        courseDetailsGetCall();
    }

}
