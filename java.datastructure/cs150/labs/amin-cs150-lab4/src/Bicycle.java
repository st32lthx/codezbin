import java.util.Random;

public class Bicycle extends Vehicle
{
private Random randomizer;
	
	
	/**
	 * Creates a bicycle.
	 * @param newLabel the name of the bicycle.
	 */
	public Bicycle(String newLabel) {
		super(newLabel);
	}

	/**
	 * Moves forward a random distance.
	 */
	public void move()
	{
	  // DELETE THIS COMMENT:
	  //
		randomizer = new Random();
		boolean flip =randomizer.nextBoolean();
		if(flip==true)
		{

			String label="";
			label+=getLabel();
			System.out.println("Bike"+label+" is resting");
		}
		else
		{
			String label="";
			label+=getLabel();
			distance++;
			System.out.println("Bike"+label+" moved.");
		}
	  // Flip a coin.  If heads, print to System.out that the bike rider is
	  // resting.  If tails, print that the bicycle moved this turn and
	  // increase distance traveled by one.
	}


}
