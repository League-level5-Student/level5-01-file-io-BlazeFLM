package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public static void main(String[] args) {
		ToDoList list = new ToDoList();

		list.run();

	}

	
	private final String configFile = "src/_03_To_Do_List/last_used_file.txt";
	
	ArrayList<String> taskList;
	JFrame frame;
	JPanel panel;
	JButton addButton;
	JButton viewButton;
	JButton removeButton;
	JButton saveButton;
	JButton loadButton;
	String defaultFile;

	public ToDoList() {
		taskList = new ArrayList<String>();
		frame = new JFrame();
		panel = new JPanel();
		addButton = new JButton("Add Task");
		viewButton = new JButton("View Tasks");
		removeButton = new JButton("Remove Task");
		saveButton = new JButton("Save List");
		loadButton = new JButton("Load List");
		
	}

	public void run() {
		loadLastUsedFile();
		
		frame.setVisible(true);

		panel.add(addButton);
		addButton.addActionListener(this);

		panel.add(viewButton);
		viewButton.addActionListener(this);

		panel.add(removeButton);
		removeButton.addActionListener(this);

		panel.add(saveButton);
		saveButton.addActionListener(this);

		panel.add(loadButton);
		loadButton.addActionListener(this);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}

	public void addTask() {
		String task = JOptionPane.showInputDialog("Add a task...");
		taskList.add(task);
	}

	public String writeTasks() {
		String list = "";
		for (String s : taskList) {
			list = list + s + "\n";
		}

		return list;
	}

	public void removeTask() {
		String task = JOptionPane.showInputDialog("Remove a task...");
		try {
			taskList.remove(task);
		} catch (Exception NullPointerException) {
			JOptionPane.showMessageDialog(null, "Task does not exist");
		}
	}

	public void saveList() {
	    String file = "src/_03_To_Do_List/tasks.txt";
	    
	    try (FileWriter w = new FileWriter(file)) {
	        w.write(writeTasks());
	        saveLastUsedFile(file); 
	    } catch (IOException e) {
	        System.out.println("Didn't save");
	    }
	}

	public void loadList() {
		String filePath = "src/_03_To_Do_List/";
		String input = JOptionPane.showInputDialog("Name the file - case specific");
		String file = filePath + input + ".txt";
		taskList.clear();

		try (BufferedReader r = new BufferedReader(new FileReader(file))){
			String line = r.readLine();
			while (line != null) {
				taskList.add(line);
				line = r.readLine();
			}
			saveLastUsedFile(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addButton)) {
			addTask();
		} else if (e.getSource().equals(viewButton)) {
			JOptionPane.showMessageDialog(null, writeTasks());
		} else if (e.getSource().equals(removeButton)) {
			removeTask();
		} else if (e.getSource().equals(saveButton)) {
			saveList();
		} else if (e.getSource().equals(loadButton)) {
			loadList();
		}
	}

	
	private void saveLastUsedFile(String filePath) {
	    try (FileWriter writer = new FileWriter(configFile)) {
	        writer.write(filePath);
	    } catch (IOException e) {
	        System.out.println("Couldn't save last used file");
	    }
	}
	
	private String getLastUsedFile() {
	    try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
	        return reader.readLine();
	    } catch (IOException e) {
	        return null; 
	    }
	}

	private void loadLastUsedFile() {
	    String lastUsedFile = getLastUsedFile();
	    if (lastUsedFile != null) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(lastUsedFile))) {
	            taskList.clear();
	            String line = reader.readLine();
	            while (line != null) {
	                taskList.add(line);
	                line = reader.readLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Failed to load last file");
	        }
	    } else {
	        System.out.println("No file found");
	    }
	}
	
	// debugging
	void printList() {
		for (String s : taskList) {
			System.out.println("___________");
			System.out.println(s);
		}
	}
}
