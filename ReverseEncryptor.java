
public class ReverseEncryptor implements EncryptionStrategy {

	@Override
	public String encrypt(String str) {
		return getReversed(str);
	}

	@Override
	public String decrypt(String str) {
		// TODO Auto-generated method stub
		return getReversed(str);
	}
	
	private String getReversed(String str) {
		String output = "";
		
		for(char c : str.toCharArray()) {
			output = c+output;
		}
		// TODO Auto-generated method stub
		return output;
	}

}
