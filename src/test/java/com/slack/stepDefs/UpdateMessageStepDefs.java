package com.slack.stepDefs;

import com.slack.utils.CommonUtils;
import com.slack.utils.PayloadUtils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class UpdateMessageStepDefs {
    Response response;

    @When("user sends a new message to slack channel")
    public void userSendsANewMessageToSlackChannel() {

       SlackPojo slackPojo = new SlackPojo();
        slackPojo.setChannel(CommonUtils.readProp("channel"));
        slackPojo.setTs(SendMessageStepDefs.timeStamp);
        slackPojo.setTs(SendMessageStepDefs.timeStamp);
        slackPojo.setText(CommonUtils.readProp("newMessage"));

        RestAssured.basePath ="";
        response= RestAssured.given().accept(ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", CommonUtils.readProp("token"))
               //.body(slackPojo)
                .body(PayloadUtils.getSlackNewMessagePayload(CommonUtils.readProp("channel"),SendMessageStepDefs.timeStamp,CommonUtils.readProp("newMessage")))
                .when().post("api/chat.update");
                //.then().extract().response();
    }
    @Then("new message status code is {int}")
    public void newMessageStatusCodeIs(Integer expectedStatusCode) {
        Integer actualStatusCode =response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }

    @Then("new message is successfully delivered")
    public void newMessageIsSuccessfullyDelivered() {
        JsonPath parsedResponse = response.jsonPath();

        Assert.assertTrue(parsedResponse.getBoolean("ok"));
        Assert.assertEquals(CommonUtils.readProp("newMessage"),parsedResponse.getString("text"));
        Assert.assertEquals(SendMessageStepDefs.timeStamp,parsedResponse.getString("ts"));

        System.out.println("PUT new message: "+parsedResponse.getString("text")+" /ts: "+parsedResponse.getString("ts"));

    }
}
