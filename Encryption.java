public class Encryption
{
	private String message, eMessage, alphabet, cipher;
	private int key;

	public Encryption(String message)
	{
		this.message = message.toLowerCase();
		key = (int)(Math.random()*24)+1;
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		cipher = getCipherAlphabet();
		eMessage = this.message;
		encryptedWord();
	}

	public String getCipherAlphabet()
	{
		return alphabet.substring(key) + alphabet.substring(0, key);
	}

	public void encryptedWord()
	{
		for(int i = 0; i < eMessage.length(); i++)
		{
			if(alphabet.indexOf(eMessage.substring(i, i+1)) > -1)
			{
				int index = alphabet.indexOf(eMessage.substring(i, i+1));
				String newLetter = cipher.substring(index, index+1);
				eMessage = eMessage.substring(0, i) + newLetter + eMessage.substring(i+1);
			}
		}
	}

	public String getEncryptedMessage()
	{
		return eMessage;
	}

	public String toString()
	{
		return "Message: \""+message+"\"\n"
		+"key: "+key+"\n"
		+"Cipher Alphabet: \""+cipher+"\"\n"
		+"Encrypted Text: \""+eMessage+"\"";
	}
}