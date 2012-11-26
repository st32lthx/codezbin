#1.3 Webhost example
In this example a webhost is abstracted that provides a business and economy plan. The business plan costs 400 and economy costs 200. The client instantiates a webhost with a either a business or economy plan and prints the information regarding the service:

`Main.java`

        Webhost hostEconomyService = new Webhost("economy");
        printInformationFor(hostEconomyService);

---
The `IPlan` interface sits between the webhost and the plans. It makes it possible to configure the webhost with any plan. This makes the code more flexible. Each plan is an abstract class that textend the abstract `APlan` class. Each plan (`Economy`and `Business`) interfaces with the `IPlan` interface:


`Economy.java`

        public class Economy extends APlan implements IPlan

---
The `Webhost.java` class keeps a reference of a plan using the instance variable `_plan`. Each plan that is instantiated implements the `IPlan` interface:

`Webhost.java`

        private IPlan _plan;
        private final IPlan _business;
        private final IPlan _economy;
        
	public Webhost(String plan) {
		_business = new Business();
		_economy = new Economy();
		_plan = (isBusiness(plan)) ? _business : _economy;
	}







    

