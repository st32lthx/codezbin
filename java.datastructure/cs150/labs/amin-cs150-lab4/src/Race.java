/**
 * Race sets up a dynamic array of vehicles and races them.
 * 
 * @author Chris Fernandes (with slight mods by Aaron Cass)
 * @version 1/16/08
 */
import javabook.*;

public class Race
{
    final static int FINISHLINE=10; // vehicle wins when it travels this much
    
    public static void main(String[] args)
    {
        InputBox in = new InputBox();
        int numVehicles = in.getInteger("How many vehicles to race?");
        Vehicle[] racers = new Vehicle[4];
        
        for (int i=0; i<=1; i++) {  
           racers[i] = new Car("C"+i);  
	   // 1st car has label "C0", 2nd has label "C1", etc.
        }
        
        
        for (int k=2; k<=3; k++) {  
            racers[k] = new Bicycle("B"+k);  
 	   // 1st Bike has label "B0", 2nd has label "B1", etc.
         }
        
        boolean done=false;
        while (!done)
        {
            // move them all (so we can see text all at once)
            for (int j=0; j<numVehicles; j++) {
                racers[j].move();
            }
            
            System.out.println();
            
            // show all distances (so we can see bar graphs all at once)
            for (int k=0; k<numVehicles; k++) {
                racers[k].drawDistance();
                if (racers[k].getDistance() >= FINISHLINE) {
                    done=true;
                    
                }
            }
            
            System.out.println();
        }
        System.exit(1);
    }
}