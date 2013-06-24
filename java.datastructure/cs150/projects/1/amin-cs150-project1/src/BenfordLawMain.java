/*
 * @author: Amin Meyghani
 * @date: Jan.16.2011
 * a program that takes a file of statistics as input, computes how many of the numbers have x as a leading
 *  digit for all x 1-9, and then plots a bar graph showing the relative frequency of each of the digits when they lead off a number. 
 */
public class BenfordLawMain
{
	public static void main(String[] arags)
    {  
		BenfordLawFrequencyGrapher plot = new BenfordLawFrequencyGrapher();
		plot.grapher(4);
    }
}
