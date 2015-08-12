import java.util.Random;

public class Student 
{
	//ID must be of length 10
	private String ID;
	
	//Generates a new student with a random ID
	public Student()
	{
		ID = "";
		Random rand = new Random();
		
		for(int i = 0; i < 11; i++)
		{
			ID += rand.nextInt() % 10;
		}
	}
	
	//Generates a new Student with a pre-determined ID
	public Student(String newID)
	{
		if(ID.length() == 10)
		{
			ID = newID;
		}
		/*if the ID is too short, add zeros
		to the front until the correct length*/
		else if(ID.length() <10)
		{
			while(newID.length() < 10)
			{
				newID = "0" + newID;
			}
			ID = newID;
		}
		/*if the ID is too long, remove numbers
		from the from the front until the correct length*/
		else
		{
			while(newID.length() > 10)
			{
				newID = newID.substring(1);
			}
			ID = newID;
		}
	}
	
	//Getters and Setters
	public String getID()
	{
		return ID;
	}
	/*uses the same method as the constructor above to
	set the new ID*/
	public void setID(String newID)
	{
		if(ID.length() == 10)
		{
			ID = newID;
		}
		/*if the ID is too short, add zeros
		to the front until the correct length*/
		else if(ID.length() <10)
		{
			while(newID.length() < 10)
			{
				newID = "0" + newID;
			}
			ID = newID;
		}
		/*if the ID is too long, remove numbers
		from the from the front until the correct length*/
		else
		{
			while(newID.length() > 10)
			{
				newID = newID.substring(1);
			}
			ID = newID;
		}
	}
}
