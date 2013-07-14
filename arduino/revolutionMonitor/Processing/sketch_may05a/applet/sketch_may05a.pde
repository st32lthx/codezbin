//Government Vs People

// Importing libraries
import twitter4j.*;
import processing.serial.*;
import cc.arduino.*;

//*****************************Instance Variables*************************//
Twitter myTwitter;
Arduino arduino;

ArrayList tweets;
int n=1;
String[] msg = new String[1000];

void setup() {

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



void draw() {

  

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

