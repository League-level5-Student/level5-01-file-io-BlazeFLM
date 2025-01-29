package _07_Checkpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public void start() {
		window = new JFrame();
		panel = new JPanel();
		textArea = new JTextArea();
		saveButton = new JButton();
		loadButton = new JButton();
		loadButton.addActionListener(this);
		saveButton.addActionListener(this);
		panel.add(textArea);
		panel.add(saveButton);
		panel.add(loadButton);

		//made GUI, start making save and load methods
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
