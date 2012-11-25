package main;

import classes.Box;
import classes.Marble;

public class Main {

	public static void main(String[] args) {
		Marble marble = new Marble();
		Box box = new Box(marble);

		System.out.println(box.weight());

	}
}
