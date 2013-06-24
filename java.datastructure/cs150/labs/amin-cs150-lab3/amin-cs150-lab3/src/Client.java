import CSLib.DrawingBox;
public class Client 
{

	public static void main(String[] args)
	{
		DrawingBox myDrawingBox = new DrawingBox ();

		Block defaultBox = new Block();
		defaultBox.display(myDrawingBox);
		
		Block nonDefaultBox = new Block(100, 250);
		nonDefaultBox.display(myDrawingBox);
		
		
		defaultBox.setPosition(300, 175);
		defaultBox.display(myDrawingBox);

		nonDefaultBox.setPosition(200,400);
		nonDefaultBox.display(myDrawingBox);

		defaultBox.setPosition(700,200);
		defaultBox.setDimension(159, 90, 45);
		defaultBox.display(myDrawingBox);
		
		Block [] blockArray = new Block[5];
		
		DrawingBox newDrawingBox = new DrawingBox ();

		for(int i=0; i < blockArray.length;i++)
		{
			Block newNonDefault = new Block(100,100*(i+1));
			blockArray[i]=newNonDefault;
			newNonDefault.display(newDrawingBox);
		}
		
		
		
	}
	
	
}

