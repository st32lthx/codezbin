package classes;

import interfaces.IPlan;
import auxclasses.Business;
import auxclasses.Economy;

public class Webhost {

	private IPlan _plan;
	private final IPlan _business;
	private final IPlan _economy;

	public Webhost(String plan) {
		_business = new Business();
		_economy = new Economy();
		_plan = (isBusiness(plan)) ? _business : _economy;
	}

	public int getPrice() {

		return _plan.getPrice();
	}

	public String toString() {
		String information = "";
		information += "Plan: " + _plan.getType() + "\n" + "Plan's Price:"
				+ _plan.getPrice() + "\n";
		return information;
	}

	// helper
	private boolean isBusiness(String plan) {
		return plan.equals("business");
	}

}
