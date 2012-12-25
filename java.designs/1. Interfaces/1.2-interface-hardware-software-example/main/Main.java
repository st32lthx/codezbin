package main;

import interfaces.IConfigureable;
import classes.Angrybirds;
import classes.Hardware;
import classes.Word;

public class Main {
	public static void main(String[] args) {

		IConfigureable angry = new Angrybirds();
		IConfigureable word = new Word();
		Hardware hardware = new Hardware();
		
		hardware.run(angry);
		hardware.run(word);
		
	}
}
