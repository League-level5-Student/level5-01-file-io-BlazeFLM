package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	private String file;

	public FileDecryptor() {
		file = "src/_02_File_Encrypt_Decrypt/file.txt";
	}
	
	public static void main(String[] args) {
		FileDecryptor e = new FileDecryptor();
		int userKey = Integer.parseInt(JOptionPane.showInputDialog("Shift value: "));
		e.decrypt(userKey);
	}

	public void decrypt(int key) {
		String input = fileReader(file);
		key *= -1;
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isUpperCase(c)) {
				c += key;
				if (c > 'Z') {
					c -= 26;
				}
				if (c < 'A') {
					c += 26;
				}
			} else if (Character.isLowerCase(c)) {
				c += key;
				if (c > 'z') {
					c -= 26;
				}
				if (c < 'a') {
					c += 26;
				}
			}

			output += c;
		}

		JOptionPane.showMessageDialog(null, "Decrypted message: " + output);
	}

	
	public String fileReader(String file) {
		String output = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			output += line;
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
}
