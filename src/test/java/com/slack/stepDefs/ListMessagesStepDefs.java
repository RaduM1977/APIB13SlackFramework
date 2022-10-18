package com.slack.stepDefs;

import com.slack.utils.CommonUtils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ListMessagesStepDefs {

    Response response;

//    //SendMessageStepDefs sendMessageStepDefs = new SendMessageStepDefs();
//    public  String timeStamp =sendMessageStepDefs.timeStamp;
//    public String message = sendMessageStepDefs.message;


    @When("user list message")
    public void userListMessage() {
        // https://slack.com/api/conversations.history?channel=C044QH2SS3U

        RestAssured.basePath="";
        response = RestAssured.given().accept(ContentType.JSON)
                .header("Authorization", CommonUtils.readProp("token"))
                .queryParam("channel",CommonUtils.readProp("channel"))
                .when().get("api/conversations.history?channel=C044QH2SS3U")
                //.then().log().all().extract().response();
                .then().extract().response();
    }
    @Then("status code should be {int}")
    public void statusCodeShouldBe(Integer expectedStatusCode) {
          Integer actualStatusCode =response.getStatusCode();
          Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }

    @Then("user's message is in the list of messages")
    public void userSMessageIsInTheListOfMessages() {
        JsonPath parsedResponse = response.jsonPath();

        boolean isOk = parsedResponse.getBoolean("ok");
        Assert.assertTrue(isOk);

        List<Map<String,Object>> listOfMap = parsedResponse.getList("messages");
        for(Map<String,Object> map:listOfMap){

            if(map.get("ts").equals(SendMessageStepDefs.timeStamp)){
                Assert.assertEquals(SendMessageStepDefs.message,map.get("text"));
                System.out.println("GET the message: "+map.get("text")+" /ts: "+SendMessageStepDefs.timeStamp);

            }
        }

    }
}
