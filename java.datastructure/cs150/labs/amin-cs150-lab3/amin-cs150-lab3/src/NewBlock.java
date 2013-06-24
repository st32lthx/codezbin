import java.awt.Rectangle;
import CSLib.DrawingBox;
public class NewBlock
{
	private Rectangle face ;
	private int depth;
	
	public NewBlock()
	{
		face = new Rectangle(100,100,50,50);
		depth = 25;
	}

	public NewBlock(int x,int y)
	{
		face = new Rectangle(x,y,50,50);
		depth=25;		
	}

	public int getWidth() {
		return face.width;
	}
	
	public int getHeight() {
		return face.height;
	}
	public int getXcoordinate() {
		return face.x;
	}
	public int getYcoordinate() {
		return face.y;
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	public void setPosition(int xcoordinate, int ycoordinate)
	{
		this.face.x = xcoordinate;
		this.face.y = ycoordinate;

	}
	

	public void setDimension(int width, int height, int depth)
	{
		
		this.face.width = width;
		this.face.height = height;
		this.depth = depth;	
		
	}
	

	public void display(DrawingBox box)
	{
		box.setVisible(true);
	    Rectangle rectangleOne = new Rectangle(face.x, face.y, face.width, face.height);
	    for(int i=0; i<depth; i++)
	    {
	    box.drawRect(rectangleOne);
	    rectangleOne.translate(-2, -2);
	    }

	}
	
	
}
