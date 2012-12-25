package classes;

import interfaces.IConfigureable;

public class Word implements IConfigureable {

private String _title;
	
	public Word(){
		
		_title = "Office Word";
	}

	public void configure(String cpu) {
		System.out.println("I am"+_title+" and I am configuerd and I am running on"+cpu);
		
	}


	
	
}
