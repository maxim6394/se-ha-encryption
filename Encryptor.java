
public class Encryptor {
	private EncryptionStrategy strategy;
	
	public void setEncryptionStrategy(EncryptionStrategy s) {
		this.strategy = s;
	}
	
	public String decrypt(String str) {
		return strategy.decrypt(str);
	}
	
	public String encrypt(String str) {
		return strategy.encrypt(str);
	}
}
