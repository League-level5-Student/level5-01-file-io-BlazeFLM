package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	private String file;
	
	
	public FileRecorder() {
		file = "src/_01_File_Recorder/message.txt";
	}
	 
	void writeFile(String input) {
		try {
			FileWriter w = new FileWriter(file);
			w.write(input);
			w.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter message here...");
		FileRecorder r = new FileRecorder();
		r.writeFile(input);
	}
	
}
//Copyright © 2025 Bryan Nguyen