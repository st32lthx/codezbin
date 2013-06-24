import CSLib.DrawingBox;
public class NewClient 
{

	public static void main(String[] args)
	{
		DrawingBox myDrawingBox = new DrawingBox ();

		NewBlock defaultBox = new NewBlock();
		defaultBox.display(myDrawingBox);
		

		NewBlock nonDefaultBox = new NewBlock(100, 250);
		nonDefaultBox.display(myDrawingBox);
		
		
		defaultBox.setPosition(300, 175);
		defaultBox.display(myDrawingBox);

		nonDefaultBox.setPosition(200,400);
		nonDefaultBox.display(myDrawingBox);

		defaultBox.setPosition(700,200);
		defaultBox.setDimension(159, 90, 45);
		defaultBox.display(myDrawingBox);
		
		NewBlock [] blockArray = new NewBlock[5];
		
		DrawingBox newDrawingBox = new DrawingBox ();

		for(int i=0; i < blockArray.length;i++)
		{

			NewBlock newNonDefault = new NewBlock(100,100*(i+1));
			blockArray[i]=newNonDefault;
			newNonDefault.display(newDrawingBox);	
		}	
	}	
}