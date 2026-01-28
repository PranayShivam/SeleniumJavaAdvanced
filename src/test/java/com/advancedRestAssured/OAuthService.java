package com.advancedRestAssured;

import com.advancedSelenium.components.OAuthServices.GetCourseDetails;
import com.advancedSelenium.components.OAuthServices.OAuthServiceRequestTokens;
import org.testng.annotations.Test;

public class OAuthService {

    @Test
    public void getAccessToken() {

        OAuthServiceRequestTokens requestToken = new OAuthServiceRequestTokens();
        System.out.println(requestToken.getRequestToken());
        String accessToken = requestToken.getAccessToken();

        GetCourseDetails.setAccessToken(accessToken);
        GetCourseDetails details = new GetCourseDetails();
        details.getResponse().prettyPrint();



    }
}
