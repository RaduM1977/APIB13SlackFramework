# APIB13SlackFramework

Here you have the Create, Read, Update and Delete message in Slack using RestAssured methods POST,GET,UPDATE and DELETE in Cucumber.
In order to track the message from POST  I used the public static  String TimeStamp variable which it moves along in the project.
I created a branch called SlackCRUDMethods so we can review the code before adding it to the main branch. 
I did not push the utils package because I was thinking somebody else will do it so we can see if the code will work that way
(it should be the same or similar with mine)
As a side note when I tried to update the message and I use the POJO class it didn't work so I used the String for serialization of the new message.
Something it is wrong so maybe you can come up with a solution for this!!!

Note: the feature files needs to be run in specific order: first(Post) -> second(Get) -> third(Put) -> fourth(Delete) but I notice the files are run in
alphabetical order or ascending so that's why I named the last file starting with "Z".I checked with Ahmet if their is a way to prioritize the running of
the feature files like we have in TestNg but he said he doesn't know anything else beside this way! Maybe you guys have any suggestion or another way to
specify the priority of feature files 
