package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		
		list.run();
		
	}
	
	
	ArrayList<String> taskList;
	JFrame frame;
	JPanel panel;
	JButton addButton;
	JButton viewButton;
	JButton removeButton;
	JButton saveButton;
	JButton loadButton;
	
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
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		
		
		
	}
	
	public void addTask() {
		String task = JOptionPane.showInputDialog("Add a task...");
		taskList.add(task);
	}
	
	public String writeTasks() {
		String list = "";
		for(String s : taskList) {
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
		
		try {
			FileWriter w = new FileWriter(file);
			w.write(writeTasks());
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadList() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addButton)) {
			addTask();
		} else if(e.getSource().equals(viewButton)) {
			JOptionPane.showMessageDialog(null, writeTasks());
		} else if(e.getSource().equals(removeButton)) {
			removeTask();
		} else if(e.getSource().equals(saveButton)) {
			saveList();
		} else if(e.getSource().equals(loadButton)) {
			
		}
	}
	
	//debugging
	void printList() {
		for(String s : taskList) {
			System.out.println("___________");
			System.out.println(s);
		}
	}
}
