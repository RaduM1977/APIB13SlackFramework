package com.slack.stepDefs;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @Before
    public void setup(){
        //https://slack.com/api/conversations.history?channel=C044QH2SS3U

        //https://slack.com/api/chat.postMessage
        RestAssured.baseURI="https://slack.com";
        RestAssured.basePath="api/chat.postMessage";

    }
}
