import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class EncryptionUI extends JFrame{
	private Encryptor encryptor;
	Map<String, EncryptionStrategy>encryptionMap;
	
	public EncryptionUI() {
		encryptor = new Encryptor();
		encryptor.setEncryptionStrategy(new ReverseEncryptor());
		
		setSize(500,400);
		
		Box box = Box.createVerticalBox();
		add(box);
		
		JTextArea textAreaOriginal = new JTextArea();
		textAreaOriginal.setBorder(new TitledBorder("Original"));
		box.add(textAreaOriginal);
		
		JTextArea textAreaEncrypted = new JTextArea();
		textAreaEncrypted.setBorder(new TitledBorder("Encrypted"));
		box.add(textAreaEncrypted);
		
		
		JPanel panel = new JPanel();
		box.add(panel);
		
		JButton encryptButton = new JButton("encrypt");
		panel.add(encryptButton);
		
		encryptButton.addActionListener(e->{
			textAreaEncrypted.setText(encryptor.encrypt(textAreaOriginal.getText()));
		});
		
		JButton decryptButton = new JButton("decrypt");
		panel.add(decryptButton);
		
		decryptButton.addActionListener(e->{
			textAreaOriginal.setText(encryptor.decrypt(textAreaEncrypted.getText()));
		});
		
		
		
		encryptionMap = new HashMap<String, EncryptionStrategy>();
		encryptionMap.put("Copy", new CopyEncryptor());
		encryptionMap.put("Reverse", new ReverseEncryptor());
		
		JComboBox comboBox = new JComboBox(encryptionMap.keySet().toArray());
		panel.add(comboBox);
		comboBox.addActionListener(e->{
			encryptor.setEncryptionStrategy(encryptionMap.get(comboBox.getSelectedItem()));
		});	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EncryptionUI();
	}

}
