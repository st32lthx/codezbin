
public abstract  class Vehicle
{

	protected int distance;
	private String label;
	
	//sublcasses will define the impl of the class
	
	/**
	 * Creates a vehicle.
	 *
	 * @param newLabel the name of the vehicle
	 */
	public Vehicle (String newLabel)
	{
		distance = 0;
		label = newLabel;
	
	}

	/**
	 * Gets the distance the vehicle has traveled.
	 * @return the distance traveled.
	 */
	public int getDistance()
	{
		return distance;
	}

	/**
	 * Gets the vehicle's label.
	 * @return the label.
	 */
	public String getLabel()
	{
		return label;
		
	}

public abstract void move();
	
	public void drawDistance()
	{
		String string="";
		for(int i=0; i<distance; i++){
			System.out.print("*");
		}
		string+=getLabel();
		System.out.println(" :"+string);
	}
}
