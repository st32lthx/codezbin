import processing.core.*; 
import processing.xml.*; 

import twitter4j.*; 
import processing.serial.*; 
import cc.arduino.*; 

import twitter4j.conf.*; 
import twitter4j.internal.async.*; 
import twitter4j.internal.org.json.*; 
import twitter4j.internal.logging.*; 
import twitter4j.json.*; 
import twitter4j.internal.util.*; 
import twitter4j.management.*; 
import twitter4j.auth.*; 
import twitter4j.api.*; 
import twitter4j.util.*; 
import twitter4j.internal.http.*; 
import twitter4j.*; 
import twitter4j.internal.json.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class sketch_may05a extends PApplet {

//Government Vs People

// Importing libraries




//*****************************Instance Variables*************************//
Twitter myTwitter;
Arduino arduino;

ArrayList tweets;
int n=1;
String[] msg = new String[1000];

public void setup() {

  try {
    ConfigurationBuilder configBuilder = new ConfigurationBuilder();
    configBuilder.setDebugEnabled(true);
    configBuilder.setOAuthConsumerKey("W3pEODSSFiMz11a41qhrQ");
    configBuilder.setOAuthConsumerSecret("NbTHZtBFvLtxsV4w3ST60hCuXTMWKuS9U3WFTag73k");
    configBuilder.setOAuthAccessToken("283927064-ZftI7DJAdkughEEG7uH0PBx47b7nlp5epw8z9UTO");
    configBuilder.setOAuthAccessTokenSecret("PEo9M6vO3lqfTOZxhFSsmAqN385tVU0FyxOdrRuOIFo");
    //---------------------------------------------------------------------------------
    TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
    myTwitter = twitterFactory.getInstance();
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}



public void draw() {

  

  try {



  msg[0]="amin";
  
   
    
    Query query = new Query("#sex");


    query.setRpp(1);
    QueryResult result = myTwitter.search(query);

    tweets = (ArrayList) result.getTweets();




    Tweet newTweet = (Tweet) tweets.get(0); // get newest tweet

    String user = newTweet.getFromUser();
    msg[n] = newTweet.getText();
    Date dateAndTime = newTweet.getCreatedAt();

    String feed="Tweet by " + user + " at " + dateAndTime + ": " + msg;
    
    //println(msg[n-1]);
    boolean notEqual=!(msg[n].equals(msg[n-1]));
    if(notEqual==true){
    println(notEqual);
    println(feed);
    }
    
    
   n++; //check should happen here. here we check if the newest msg has changed. if the message has changed we print it otherwise we keep looking to see if the msg has been updated
     
    
  //  println(msg[n].equals(msg[n-1]));
    
  }









 catch(Exception e) {
    e.printStackTrace();
  }

//print(n);
delay(1000);


 
 
  
  
  
  
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#33ccdd", "--hide-stop", "sketch_may05a" });
  }
}
