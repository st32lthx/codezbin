#include <Servo.h>
Servo myServo;


int position = 0 ;

void setup(){
	myServo.attach(9);
}

void loop(){
	
	for(position = 0 ; position < 180 ; position+=1){
		
		myServo.write(position);
		delay(15);  
		
	}
	
}
