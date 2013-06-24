import java.awt.Rectangle;
import CSLib.DrawingBox;
public class Block 

{
	private int width;
	private int height;
	private int depth;
	private int xcoordinate;
	private int ycoordinate;


	public Block()
	{
		width= 50;
		height = 50;
		depth = 25;
		xcoordinate = 100;
		ycoordinate = 100;
	}


	public Block(int xcoordinate, int ycoordinate)
	{
		
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		width= 50;
		height = 50;
		depth = 25;	
	}


		public int getWidth() {
			return width;
		}
		
		
		public int getHeight() {
			return height;
		}
		
		
		public int getDepth() {
			return depth;
		}
		
		public int getYcoordinate() {
			return ycoordinate;
		}
		
		public int getXcoordinate() {
			return xcoordinate;
		}
		
		
		public void setPosition(int xcoordinate, int ycoordinate)
		{
			this.xcoordinate = xcoordinate;
			this.ycoordinate = ycoordinate;

		}
		
		public void setDimension(int width, int height, int depth)
		{
			
			this.width = width;
			this.height = height;
			this.depth = depth;	
			
		}
		

public void display(DrawingBox box)
{
	box.setVisible(true);
    Rectangle rectangleOne = new Rectangle(xcoordinate, ycoordinate, width, height);
    for(int i=0; i<depth; i++)
    {
    box.drawRect(rectangleOne);
    rectangleOne.translate(-2, -2);
    }
}

}

