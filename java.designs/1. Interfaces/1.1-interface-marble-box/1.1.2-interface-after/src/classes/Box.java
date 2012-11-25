package classes;

import interfaces.IPlaceholder;

public class Box {

	private int _weight;
	private IPlaceholder _thing;
	
	public Box(IPlaceholder thing){
		_weight = 5;
		_thing = thing;
	}
	
	public int weight(){
		return _weight +_thing.getWeight();
	}

}
