package AutomationFramework;

import java.util.Random;

public class FunctionUtils {

	public int GenerateRandomNumber(int withinBound)
	{
		Random random = new Random();
		return random.nextInt(withinBound);	 
	}
	
	public static int RandomNumber(int withinBound)
	{
		Random random = new Random();
		return random.nextInt(withinBound);	 
	}
}
