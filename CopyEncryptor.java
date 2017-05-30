
public class CopyEncryptor implements EncryptionStrategy {

	@Override
	public String encrypt(String str) {
		return str;
	}

	@Override
	public String decrypt(String str) {
		return str;
	}

}
