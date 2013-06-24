import java.awt.Rectangle;
import CSLib.DrawingBox;
import CSLib.OutputBox;
public class RectangleNoIntersect 
{

	/**
	 * @author Amin Meyghani
	 * @date Jan.13.2011
	 * Purpose: Draw and manipulate rectangle, making two rectangles that don't intersect
	 */
	
	
	public static void main(String[] args)
    {
        
		twoRectanglesDontIntersect();
  	
     }
	
	public static void twoRectanglesDontIntersect()
	{
		DrawingBox myDrawingBox = new DrawingBox ();
		myDrawingBox.setVisible(true);
        Rectangle Rect1 = new Rectangle(50,180,120,180);
        Rect1.translate(1000, 0);
        Rectangle Rect2 = new Rectangle(100,240,150,200);
        myDrawingBox.drawRect(Rect1);
        myDrawingBox.drawRect(Rect2);
        OutputBox  myOutPutBox = new OutputBox ();
        
        if (Rect1.intersects(Rect2)){
        	myOutPutBox.println("The two rectangles intersect");
        	}else{
            	myOutPutBox.println("The two rectangles do not intersect");
            	}
	}
 
}
