import java.awt.Rectangle;
import CSLib.DrawingBox;
import CSLib.OutputBox;
import CSLib.Timer;
public class RectangleAllTogether 
{

	/**
	 * @author Amin Meyghani
	 * @date Jan.13.2011
	 * Purpose: Draw and manipulate rectangles
	 */
	

	public static void main(String[] args)
    {

		CreateAndDrawRect1AndRect2();
		Timer.pause(1000);
		DoTheRectanglesIntersect();
		Timer.pause(1200);
		DoesBoundingBoxContainsBothRectangles();
		Timer.pause(1200);
		DrawOneCurve();
		
    }	
	
	
	private static void CreateAndDrawRect1AndRect2()
	{
		DrawingBox myDrawingBox = new DrawingBox ();
		myDrawingBox.setVisible(true);
		Rectangle Rect1 = new Rectangle(50,180,120,180);
		Rectangle Rect2 = new Rectangle(100,240,150,200);
		myDrawingBox.drawRect(Rect1);
		myDrawingBox.drawRect(Rect2);
	}
	
	
	private static void DoTheRectanglesIntersect()
		{
		Rectangle Rect1 = new Rectangle(50,180,120,180);
		Rectangle Rect2 = new Rectangle(100,240,150,200);
		OutputBox  myOutPutBox = new OutputBox ();

			if (Rect1.intersects(Rect2))
			{
			myOutPutBox.println("The two rectangles intersect");
			}else{
			myOutPutBox.println("The two rectangles do not intersect");
			}			
		}
		
	
	private static void DoesBoundingBoxContainsBothRectangles()
	{
		OutputBox  myOutPutBox = new OutputBox ();
		DrawingBox myDrawingBox = new DrawingBox ();
		Rectangle Rect1 = new Rectangle(50,180,120,180);
		Rectangle Rect2 = new Rectangle(100,240,150,200);
		myDrawingBox.drawRect(Rect2);
		myDrawingBox.drawRect(Rect1);
		myDrawingBox.drawRect(Rect1.union(Rect2));
		
			if (Rect1.intersects(Rect2))
			{    
			myOutPutBox.println("The bounding box contains both rectangles");
			}else{
			myOutPutBox.println("The bounding box does not contains both rectangles");
			}
	}	
	

	private static void DrawOneCurve()
	{
		int xIncrement;
		int yIncrement;
		
		DrawingBox myDrawingBox = new DrawingBox ();
		myDrawingBox.setVisible(true);
		Rectangle myRectangles = new Rectangle(20,500,2,2);
		myDrawingBox.drawRect(myRectangles);
			
			for(xIncrement = 0 ; xIncrement<=50; xIncrement ++)
			{
			myRectangles.translate(xIncrement, 0);
			myDrawingBox.drawRect(myRectangles);
			}
		
			for(yIncrement = 0 ; yIncrement<=50; yIncrement --)
			{
			myRectangles.translate(-10, yIncrement);
			myDrawingBox.drawRect(myRectangles);
			}
			
		}

}
