package classes;

public class Box {

	private int _weight;
	private Marble _marble;

	public Box(Marble marble) {
		_weight = 5;
		_marble = marble;
	}

	public int weight() {
		return _weight + _marble.getWeight();
	}

}
