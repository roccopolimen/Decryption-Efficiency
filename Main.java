import java.util.*;

public class Main
{

	public static double mean(ArrayList<Integer> list)
	{
		int sum = 0;
		for(Integer i: list)
			sum += i;
		return sum*1.0 / list.size();
	}


	public static double standardDeviation(ArrayList<Integer> list)
	{
		double mean = mean(list);
		double numerator = 0;
		for(Integer i: list)
			numerator += Math.pow(i - mean, 2);
		return Math.pow(numerator / (list.size()-1), .5);
	}

	public static void main(String [] args)
	{
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> bruteForceTrials = new ArrayList<Integer>();
		ArrayList<Integer> frequencyAnalysisTrials = new ArrayList<Integer>();
		ArrayList<String> messages = new ArrayList<String>();
		int iterations = 0;
		do
		{
			System.out.println("Enter a Sentence or Type 'exit' to end program.\n");
			String message = scanner.nextLine();
			if(message.equals("exit"))
				break;
			Encryption encrypter = new Encryption(message);
			BruteForce bruteForce = new BruteForce(message, encrypter.getEncryptedMessage());
			FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis(message, encrypter.getEncryptedMessage());
			System.out.println("/////////////////////////");
			System.out.println("\n\n\n\n");
			System.out.println("Encryption\n");
			System.out.println(encrypter);
			System.out.println("\n\t. . .\n");
			System.out.println("Decryption\n");
			System.out.println(bruteForce);
			System.out.println();
			System.out.println(frequencyAnalysis);
			System.out.println("\n\n\n\n");
			System.out.println("/////////////////////////");
			bruteForceTrials.add(bruteForce.trials);
			frequencyAnalysisTrials.add(frequencyAnalysis.trials);
			messages.add(message);
			iterations++;
		}
		while(true);

		System.out.println("Number of trials: "+messages.size());
		System.out.println("Data from Brute Force Algorithm:");
		System.out.println("Mean: "+mean(bruteForceTrials));
		System.out.println("Standard Deviation: "+standardDeviation(bruteForceTrials));
		System.out.println("Data Points: ");
		for(Integer i: bruteForceTrials)
			System.out.print(i+"     ");
		System.out.println();
		System.out.println("Data from Frequency Analysis Algorithm:");
		System.out.println("Mean: "+mean(frequencyAnalysisTrials));
		System.out.println("Standard Deviation: "+standardDeviation(frequencyAnalysisTrials));
		System.out.println("Data Points: ");
		for(Integer i: frequencyAnalysisTrials)
			System.out.print(i+"     ");

		System.out.println();
	}
}