package classes;

import interfaces.IPlaceholder;

public class Cube implements IPlaceholder{

	
	private int _weight;
	
	public Cube(){
		_weight = 2;
	}
	
	public int getWeight(){
		return _weight;
	}

}
