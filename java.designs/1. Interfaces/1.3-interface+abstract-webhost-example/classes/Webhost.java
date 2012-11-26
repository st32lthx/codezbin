@author: Amin Meyghani
package classes;

import interfaces.IPlan;
import auxclasses.Business;
import auxclasses.Economy;

public class Webhost {

	private IPlan _plan;

	public Webhost(String plan) {

		_plan = (isBusiness(plan)) ? new Business() :new Economy();
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
