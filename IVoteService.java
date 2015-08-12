import java.util.ArrayList;
import java.util.HashMap;

public class IVoteService 
{
	private Question q;
	
	/* Stores each student's answer */
	private HashMap<Student, String> entries;
	
	/*List of all students that have submitted */
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	/*indices of this array match the answers indices
	value stored is the number of submissions for the index's
	Corresponding answer*/
	private int[] numEntriesAnswers;
	
	//Init the service
	public IVoteService(Question question)
	{
		q = question;
		entries = new HashMap<Student, String>();
		numEntriesAnswers = new int[q.getAnswerSet().length];
	}
	
	public void submitVote(Student student, String answer)
	{
		entries.put(student, answer);
		studentList.add(student);
	}
	
	/*prints out the results in a readable format to the console
	also clears the service of submissions*/
	public void collectResults()
	{
		String tempAns;
		char[] ansChars = q.getAnswerSet();
		numEntriesAnswers = new int[ansChars.length];
		//for every student that submitted, get their answer from the hashmap
		for(int i = 0; i < studentList.size(); i++)
		{
			//if the student submitted, get his submission
			if(entries.containsKey(studentList.get(i)) == true)
			{
				//retrieve the students answers
				tempAns = entries.get(studentList.get(i));
				//parse the students answers
				for(int j = 0; j < ansChars.length; j++)
				{
					if(tempAns.contains(ansChars[j] + ""))
					{
						numEntriesAnswers[j]++; //increment the number of submissions for this particular answer
						tempAns.replaceAll(ansChars[j] + "", ""); /*So that if a student types the same answer twice
																	it isn't counted twice.*/
					}
				}
			}
		}
		//reset the submissions
		this.resetSubmissions();
		//print the question
		q.print();
		
		//print the results
		String answerResult;
		for(int i = 0; i < numEntriesAnswers.length; i++)
		{
			answerResult = ansChars[i] + ": " + numEntriesAnswers[i];
			System.out.println(answerResult);
		}
	}
	
	private void resetSubmissions()
	{
		//clear out the map and list of students
		entries.clear();
		studentList.clear();
	}
}