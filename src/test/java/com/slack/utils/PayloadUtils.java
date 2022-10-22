package com.slack.utils;

public class PayloadUtils {




    public static String getSlackMessagePayload(String message,String channel){
      return "{\n" +
              "    \"channel\": \""+channel+"\",\n" +
              "    \"text\": \""+message+"\"\n" +
              "}";
    }

    public static String getSlackNewMessagePayload(String channel,String timeStamp,String newMessage){
        return "{\n" +
                "  \"channel\": \""+channel+"\",\n" +
                "  \"ts\": \""+timeStamp+"\",\n" +
                "  \"text\": \""+newMessage+"\"\n" +
                "}";
    }

    public static String getSlackDeletePayload(String channel,String timeStamp){
        return "{\n" +
                "  \"channel\": \""+channel+"\",\n" +
                "  \"ts\": \""+timeStamp+"\"\n" +
                "}";
    }
}
