
//******************************************************************************************
//*                                                                                        *      
//*                             THE REVOLUTION MONITORING MACHINE                          *
//*                                                                                        *
//******************************************************************************************


//--------------------------------LIBRARIES-----------------------------------------------------

import twitter4j.*; import processing.serial.*; import cc.arduino.*; 

//---------------------------INSTANCE VARIABLES--------------------------------------------

Twitter myTwitter;
Arduino arduino;
ArrayList tweets; int n=1; ArrayList msgs; String msg; int buttonState = 0;
PFont font;
String feed2;
String twitterMsg;
String twitterUser;
Date twitterTime;
void setup() { 
    //Initialize PFont
  font = loadFont("CourierNewPS-BoldMT-25.vlw");
  textFont(font, 25);
     size(1024, 768);
    
  
      arduino = new Arduino(this, Arduino.list()[0], 57600); 
      arduino.pinMode(12, Arduino.OUTPUT);
      arduino.pinMode(10, Arduino.OUTPUT);       
      arduino.pinMode(3, Arduino.INPUT); 
      
msgs = new ArrayList(); msgs.add("amin"); //initialize the arrayList of messages

//---------------------------Setting up Twitter API---------------------------

  try {
    ConfigurationBuilder configBuilder = new ConfigurationBuilder();
    configBuilder.setDebugEnabled(true);
    configBuilder.setOAuthConsumerKey("W3pEODSSFiMz11a41qhrQ");
    configBuilder.setOAuthConsumerSecret("NbTHZtBFvLtxsV4w3ST60hCuXTMWKuS9U3WFTag73k");
    configBuilder.setOAuthAccessToken("283927064-ZftI7DJAdkughEEG7uH0PBx47b7nlp5epw8z9UTO");
    configBuilder.setOAuthAccessTokenSecret("PEo9M6vO3lqfTOZxhFSsmAqN385tVU0FyxOdrRuOIFo");
    
    TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
    myTwitter = twitterFactory.getInstance();
  }
  //---------------------------------------------------------------------------------
  catch(Exception e) {
    e.printStackTrace();
  }
  

}
//---------------------------------------------------------------------------------
void draw() {

  
  try {

    Query query = new Query("#iranelection");
    query.setRpp(1);
    QueryResult result = myTwitter.search(query);
    tweets = (ArrayList) result.getTweets();
    Tweet newTweet = (Tweet) tweets.get(0); // get newest tweet
    String user = newTweet.getFromUser();
    
    msgs.add ( newTweet.getText());
    
    Date dateAndTime = newTweet.getCreatedAt();
    String feed="Tweet by " + user + " at " + dateAndTime+"\n" + ": " + msgs.get(n);
    feed2 = feed;
    twitterUser = (String)user;
    twitterTime = dateAndTime;
    twitterMsg = (String)msgs.get(n);
    
    boolean isThereNewTweet=!(msgs.get(n).equals(msgs.get(n-1)));
    println(isThereNewTweet);
 //-------------------------LOGIC FOR NEW TWEETS------------------------------   
   if(isThereNewTweet==true){
   println(feed);
   
  // 

   
   arduino.digitalWrite(10, Arduino.HIGH); // will go up if red is on the left : high
   delay(1000);
   arduino.digitalWrite(12, Arduino.HIGH);
   delay(1000); 
   arduino.digitalWrite(12, Arduino.LOW);
   delay(1000);  
   }// end of if statement for if there is a new feed.
 //-------------------------------------------------------------------------------
  n++;  // go to the next feed.
  }
  
 catch(Exception e) {
   e.printStackTrace();
  }
 //------------------------SWITCH-------------------------------------------------
 
  if (arduino.digitalRead(3) == Arduino.HIGH) {     
  // make motor go down:      
    
    arduino.digitalWrite(10, Arduino.LOW); // will go down ( red wire is on the left )
    delay(3000); // how long it will take for the motor before moving down.
    arduino.digitalWrite(12, Arduino.HIGH);
    delay(8000); //duration of lowering
    arduino.digitalWrite(12, Arduino.LOW);
    delay(500);  
  } 

  //--------------------------------------------------------------------------
delay(1000); // search every 1 second.
  background(210,25,25);
  
  fill(255,255,255);
  text(twitterMsg+"\n"+twitterUser+"\n"+twitterTime, 12, height/2);
  delay(1000);

}

