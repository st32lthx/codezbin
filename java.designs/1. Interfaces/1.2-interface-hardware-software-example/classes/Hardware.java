package classes;

import interfaces.IConfigureable;

public class Hardware {
	
	private String _cpu;
	private IConfigureable _software;
	
	public Hardware(){
		
		_cpu = "intel";
	}
	
	public void run(IConfigureable angry){
		
		_software = angry;
		_software.configure(_cpu);
	}

}
