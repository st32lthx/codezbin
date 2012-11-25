package main;

import interfaces.IPlaceholder;
import classes.Box;
import classes.Cube;
import classes.Marble;

public class Main {

	public static void main(String[] args) {
		IPlaceholder marble = new Marble();
		IPlaceholder cube = new Cube();
		Box box = new Box(marble);
		Box box1 = new Box(cube);
		System.out.println(box.weight());
		System.out.println(box1.weight());
	}
}
