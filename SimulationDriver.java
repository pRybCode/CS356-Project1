import java.util.Random;
import java.util.Scanner;


public class SimulationDriver 
{
	public static void main(String[] args) 
	{
		//RNG
		Random rand = new Random();
		//Vars for inputs:
		Scanner scan = new Scanner(System.in);
		String inputSTRING;	int inputINT; char inputCHAR = '0';
		//Vars:
		Student[] Students; char[] answers; String question;
		IVoteService iVote; Question q; String answerGen;
		
		//Prompt for number of people in class
		System.out.println("Please enter the number of students in the class: ");
		inputINT = scan.nextInt();
		scan.nextLine();
		Students = new Student[inputINT];
		//populate the class
		for(int i = 0; i < inputINT; i++)
		{
			Students[i] = new Student();
		}
		//input the question
		System.out.println("Enter a question: ");
		question = scan.nextLine();
		System.out.println("How many answers are possible? ");
		inputINT = scan.nextInt();
		scan.nextLine();
		answers = new char[inputINT];
		System.out.println("Enter the character for each answer in order: ");
		for(int i = 0; i < answers.length; i++)
		{
			answerGen = scan.nextLine();
			inputCHAR = answerGen.charAt(0);
			answers[i] = inputCHAR;
		}
		//Init the question and voting service
		q = new Question(question, answers);
		iVote = new IVoteService(q);
		//Each student submits a random answer
		for(int i = 0; i < Students.length; i++)
		{
			inputINT = rand.nextInt(answers.length);
			answerGen = "" + answers[inputINT];
			iVote.submitVote(Students[i], answerGen);
		}
		//print out the results
		iVote.collectResults();
	}
}