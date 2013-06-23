/* Runs each of the methods in the Analyzer class in turn.
 * 
 */
public class Client {

	public static void main(String[] args) {
		Analyzer tester = new Analyzer();
		double min, max;
		double[] buyingData = new double[10];
		for(int i=0; i<buyingData.length; i++)
			buyingData[i]=((long)(100*(Math.random()*100)))/100.0;
		
		System.out.println("***PART 1 - numberCruncher");
		tester.numberCruncher();
        System.out.println("\n");
		
		min=9; max=50;
		System.out.println("###PART 2 - purchaseAnalyzer: min=" + min + "    max=" + max);
		tester.purchaseAnalyzer(buyingData, min, max);
        System.out.println("\n");
		
		min=8; max=85;
		System.out.println("^^^PART 3 - inDepthAnalyzer: min=" + min + "    max=" + max);
		tester.inDepthAnalyzer(buyingData, min, max);
		
		tester.printer(buyingData);
	}

}
