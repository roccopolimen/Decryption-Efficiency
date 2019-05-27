public class BruteForce
{
	private String eMessage, message, alphabet;
	protected int trials;

	public BruteForce(String message, String eMessage)
	{
		this.message = message.toLowerCase();
		this.eMessage = eMessage;
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		trials = 0;
		decrypt();
	}

	public void decrypt()
	{
		for(int k = 1; k < 26; k++)
		{
			String test = eMessage;
			String predictedCipher = alphabet.substring(k) + alphabet.substring(0, k);

			for(int i = 0; i < test.length(); i++)
			{
				if(alphabet.indexOf(test.substring(i, i+1)) > -1)
				{
					int index = predictedCipher.indexOf(test.substring(i, i+1));
					String newLetter = alphabet.substring(index, index+1);
					test = test.substring(0, i) + newLetter + test.substring(i+1);

				}
			}
			trials++;
			if(test.equals(message))
				break;		
		}
	}

	public String toString()
	{
		return "Brute Force Attack\n"+
		"Attempts needed to Crack: "+trials;
	}
}