import java.awt.Rectangle;
import CSLib.DrawingBox;
public class RectangleTester
{
	
	/**
	 * @author Amin Meyghani
	 * @date Jan.13.2011
	 * @param args
	 * Purpose: Draw and manipulate rectangle
	 */
	
    public static void main(String[] args)
    {
        DrawingBox myBoard;
        myBoard = new DrawingBox();
        myBoard.setVisible(true);
        Rectangle rectangleObject = new Rectangle(320,230,120,180);
        
       myBoard.drawRect(rectangleObject);
       
       //rectangleObject.grow(20,20);
       //myBoard.drawRect(rectangleObject);

       rectangleObject.translate(280,-50);
       myBoard.drawRect(rectangleObject);
       
       rectangleObject.setLocation(75,250);
       myBoard.drawRect(rectangleObject);
       
       rectangleObject.setSize(200,150);
       myBoard.drawRect(rectangleObject);

       

       
       
       
       
       
       
       
       
       
       
       //myBoard.drawRect(700,230,120,180);
        
    }
}
