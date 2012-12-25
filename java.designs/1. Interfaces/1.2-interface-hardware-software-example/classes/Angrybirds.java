package classes;

import interfaces.IConfigureable;

public class Angrybirds implements IConfigureable {

	private String _title;
	
	public Angrybirds(){
		
		_title = "Angry Birds";
	}
	public void configure() {
	
	
		
	}
	
	public void configure(String cpu) {
		System.out.println("I am"+_title+" and I am configuerd and I am running on"+cpu);
		
	}

}
