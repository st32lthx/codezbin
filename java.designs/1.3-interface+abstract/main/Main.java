package main;

import classes.Webhost;

public class Main {

	public static void main(String[] args) {

		Webhost hostEconomyService = new Webhost("economy");
		Webhost hostBusinessService = new Webhost("business");
		printInformationFor(hostEconomyService);
		printInformationFor(hostBusinessService);
	}

	// static helper
	private static void printInformationFor(Webhost host) {
		System.out.println(host);
	}
}
