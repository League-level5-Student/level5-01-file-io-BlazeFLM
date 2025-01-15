package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		/*
		 * JFileChooser jfc = new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); int returnVal =
		 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
		 * File directory = jfc.getSelectedFile(); File[] files = directory.listFiles();
		 * if (files != null) { for (File f : files) {
		 * System.out.println(f.getAbsolutePath()); } } }
		 */
		DirectoryIterator d = new DirectoryIterator();
		d.FolderIterator();
		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */

	}

	public void FolderIterator() {
		File directory = new File("src");
		Stack<File> directories = new Stack<File>();
		directories.add(directory);
		while (!directories.isEmpty()) {
			directory = directories.pop();
			if (directory.isDirectory()) {
				File[] files = directory.listFiles();
				if (files != null) {
					for (File f : files) {
						System.out.println(f.getName());
						if (f.isDirectory()) {
							directories.push(f);
						} else if (f.getName().endsWith(".java")) {
							System.out.println(f.getName());
							try {
								FileWriter w = new FileWriter(f.getPath(), true); //Original mistake: used getName instead of getPath  
								w.append("//Copyright © 2025 Bryan Nguyen");      //      -getPath is accurate because we need the whole path to the file
								w.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					}
				}
			}
		}

	}
}
//Copyright © 2025 Bryan Nguyen