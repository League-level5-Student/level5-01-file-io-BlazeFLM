package _07_Checkpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener {
	private JFrame window;
	private JPanel panel;
	JButton saveButton;
	JButton loadButton;
	JTextArea textArea;
	private static final String file = "src/_07_Checkpoint/saved.dat";

	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		te.start();
	}

	public void start() {
		window = new JFrame();
		panel = new JPanel();
		textArea = new JTextArea();
		saveButton = new JButton("Save Work");
		loadButton = new JButton("Load Work");
		window.setVisible(true);
		window.setSize(500, 500);
		textArea.setSize(300, 400);
		loadButton.addActionListener(this);
		saveButton.addActionListener(this);
		panel.add(textArea);
		panel.add(saveButton);
		panel.add(loadButton);
		window.add(panel);

		// made GUI, start making save and load methods

	}

	void save() {
		try {
			FileOutputStream fos = new FileOutputStream(new File(file));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textArea.getText());
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load() {
		try {
			FileInputStream fis = new FileInputStream(new File(file));
			ObjectInputStream ois = new ObjectInputStream(fis);
			textArea.setText((String) ois.readObject());
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			textArea.setText("Type here...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(saveButton)) {
			save();
		} else if(e.getSource().equals(loadButton)) {
			load();
		}
	}
}
