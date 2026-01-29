package com.advancedSelenium.components.OAuthServices;

import com.advancedSelenium.Enums.GrantType;
import com.advancedSelenium.Enums.Scope;
import com.advancedSelenium.utilities.FrameWorkUtility;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class OAuthServiceRequestTokens {

    private String accessToken;
    private String refreshToken;
    private final String client_id = FrameWorkUtility.getValueFromConfigProperty("client_id");
    private final String client_Secret = FrameWorkUtility.getValueFromConfigProperty("client_secret");
    private final String url = "https://rahulshettyacademy.com/";
    private final String baseUri = "/oauthapi/oauth2/resourceOwner/token";


    public OAuthServiceRequestTokens() {
        setTokens();
    }

    private void tokenPostCall() {
        Response response = RestAssured.given()
                .spec(getSpecifications())
                .when().post(baseUri)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status Code MissMatch");
        accessToken = response.then().extract().body().path("access_token");
        refreshToken = response.then().extract().body().path("refresh_token");

    }

    public String getAccessToken() {
        if (accessToken != null) return accessToken;
        return "AccessToken is null";
    }

    public String getRequestToken() {
        if (refreshToken != null) return refreshToken;
        return "RefreshToken is null";
    }

    private void setTokens() {
        if (accessToken == null || refreshToken == null) {
            tokenPostCall();
        }
    }

    private RequestSpecification getSpecifications() {

        Map<String, String> formData = new LinkedHashMap<>();
        formData.put("client_id", client_id);
        formData.put("client_secret", client_Secret);
        formData.put("grant_type", GrantType.CLIENT_CREDENTIALS.getValue());
        formData.put("scope", Scope.TRUST.getValue());

        RequestSpecification specification =  new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeader("Content-Type", String.valueOf(ContentType.MULTIPART))
                .build();
        formData.forEach(specification::multiPart);
        return specification;
    }
}
