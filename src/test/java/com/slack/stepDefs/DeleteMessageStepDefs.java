package com.slack.stepDefs;

import com.slack.utils.CommonUtils;
import com.slack.utils.PayloadUtils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class DeleteMessageStepDefs {
    Response response;
    @When("user sends delete to slack channel")
    public void userSendsDeleteToSlackChannel() {
        RestAssured.basePath ="";
        response= RestAssured.given().accept(ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", CommonUtils.readProp("token"))
                .body(PayloadUtils.getSlackDeletePayload(CommonUtils.readProp("channel"),SendMessageStepDefs.timeStamp))
                .when().post("api/chat.delete");
    }
    @Then("delete status code is {int}")
    public void deleteStatusCodeIs(Integer expectedStatusCode) {
        Integer actualStatusCode =response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }
    @Then("validate the message was deleted")
    public void validateTheMessageWasDeleted() {
        JsonPath parsedResponse = response.jsonPath();
        Assert.assertTrue(parsedResponse.getBoolean("ok"));
        Assert.assertEquals(SendMessageStepDefs.timeStamp,parsedResponse.getString("ts"));
        Assert.assertEquals(CommonUtils.readProp("deleteMessage"),parsedResponse.getString("warning"));

        System.out.println("DELETE message: "+parsedResponse.getString("warning")+" /ts: "+parsedResponse.getString("ts"));
    }
}
