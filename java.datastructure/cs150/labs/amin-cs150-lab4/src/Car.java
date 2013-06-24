import java.util.Random;
public class Car extends Vehicle {
	private Random randomizer;
	private int gas;

	/**
	 * Creates a car with 15 units of gas.
	 * 
	 * @param newLabel
	 *            the name of the car.
	 */
	public Car(String newLabel) {
	super(newLabel);
	gas=15;
	}


	/**
	 * Moves the car forward a random amount, if the car has gas left.
	 */
	public void move() {

		if(gas!=0){
			
			randomizer = new Random();
			boolean flip = randomizer.nextBoolean();
			
			if(flip==true)
			{
				idle();
			}
			else
			{
				String label="";
				label+=getLabel();
				distance+=2;
				System.out.println("Car "+ label +" has moved and the remining gas is " + gas);
				if(gas==0)
				{
					System.out.println("No gass has remained");
				}
			}
		}
		
	}

	/**
	 * Idles the car, using one unit of gas without going anywhere.
	 */
	private void idle() {
	    String label = "";
	    label+=getLabel();
		gas-=1;
		System.out.println("car "+label+" is idling and the amound of remaining gas is " + gas);
	}
	

}
