
public class Question 
{
	private String question;
	private char[] answers;
	
	//Creates an empty question
	public Question()
	{
		question = "";
		answers = new char[1];
		answers[0] = '~';
	}
	
	//Creates a question with a predetermined
	//question and answer
	public Question(String newQuestion, char[] newAnswers)
	{
		question = newQuestion;
		answers = newAnswers;
	}
	
	//getters and setters
	public String getQuestion()
	{
		return question;
	}
	public char[] getAnswerSet()
	{
		return answers;
	}
	//Should only be used for fixing input errors
	public void setQuestion(String newQuestion)
	{
		question = newQuestion;
	}
	public void setAnswers(char[] newAnswers)
	{
		answers = newAnswers;
	}
	//prints the question out to the console
	public void print() 
	{
		System.out.println(question);
	}
}
