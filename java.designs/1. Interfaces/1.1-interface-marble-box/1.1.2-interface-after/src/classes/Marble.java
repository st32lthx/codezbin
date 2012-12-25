package classes;

import interfaces.IPlaceholder;

public class Marble implements IPlaceholder {

	private int _weight;
	
	public Marble(){
		_weight = 1;
	}
	
	public int getWeight(){
		return _weight;
	}

}
