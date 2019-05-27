public class FrequencyAnalysis
{
	private String eMessage, message, alphabet, frequencyList;
	protected int trials;

	public FrequencyAnalysis(String message, String eMessage)
	{
		this.message = message.toLowerCase();
		this.eMessage = eMessage;
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		frequencyList = "etaoinsrhdlucmfywgpbvkxqjz";
		trials = 0;
		decrypt();
	}

	public void decrypt()
	{
		String frqLet = mostFrequentLetter();
		int frqLetLocation = alphabet.indexOf(frqLet);

		for(int k = 0; k < 26; k++)
		{
			String test = eMessage;
			String currentFrqLetter = frequencyList.substring(k, k+1);
			int currentLocation = alphabet.indexOf(currentFrqLetter);
			int shiftKey = frqLetLocation - currentLocation;
			if(shiftKey < 0)
				shiftKey = 26 + shiftKey;

			String newAlphabet = alphabet.substring(shiftKey) + alphabet.substring(0, shiftKey);

			for(int i = 0; i < test.length(); i++)
			{
				if(alphabet.indexOf(test.substring(i, i+1)) > -1)
				{
					int index = newAlphabet.indexOf(test.substring(i, i+1));
					String newLetter = alphabet.substring(index, index+1);
					test = test.substring(0, i) + newLetter + test.substring(i+1);

				}
			}
			trials++;
			if(test.equals(message))
				break;	
		}
	}

	public String mostFrequentLetter()
	{
		int [] letterCounter = new int [26];

		for(int i = 0; i < eMessage.length(); i++)
			if(alphabet.indexOf(eMessage.substring(i, i+1)) > -1)
				letterCounter[alphabet.indexOf(eMessage.substring(i, i+1))]++;

		int max = letterCounter[0];
		String letter = "a";

		for(int j = 1; j < 26; j++)
		{
			if(letterCounter[j] > max)
			{
				max = letterCounter[j];
				letter = alphabet.substring(j, j+1);
			}
		}

		return letter;
	}

	public String toString()
	{
		return "Frequency Analysis Attack\n"+
		"Attempts needed to Crack: "+trials;
	}
}