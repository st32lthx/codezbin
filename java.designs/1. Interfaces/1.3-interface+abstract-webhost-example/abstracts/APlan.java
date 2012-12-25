package abstracts;

public abstract class APlan {

	private String _type;
	private int _price;

	public APlan(String type, int price) {

		_type = type;
		_price = price;
	}

	public String getType() {

		return _type;

	}

	public int getPrice() {
		return _price;
	}
}
