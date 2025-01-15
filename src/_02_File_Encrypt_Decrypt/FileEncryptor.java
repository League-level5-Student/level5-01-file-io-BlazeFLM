package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	private String file;

	public static void main(String[] args) {
		FileEncryptor e = new FileEncryptor();

		String input = JOptionPane.showInputDialog("Message: ");
		int userKey = Integer.parseInt(JOptionPane.showInputDialog("Shift value: "));
		e.encryptToFile(input, userKey);
	}

	public FileEncryptor() {
		file = "src/_02_File_Encrypt_Decrypt/file.txt";
	}
	//so it works like this ill type a message, set a shift value which will move letters up or down the alphabet
	public void encryptToFile(String input, int key) {
		try {
			FileWriter w = new FileWriter(file);
			w.write(encrypt(input, key));
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String input, int key) {
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

		System.out.println(output);

		return output;
	}

}
//Copyright © 2025 Bryan Nguyen