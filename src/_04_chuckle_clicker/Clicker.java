package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Clicker implements ActionListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton jokeButton = new JButton();
	static JButton lineButton = new JButton();
	Clicker(){
		lineButton.addActionListener(this);
		jokeButton.addActionListener(this);
		jokeButton.setText("joke");
		lineButton.setText("punchline");
		panel.add(jokeButton);
		panel.add(lineButton);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	static void makeButtons(){
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jokeButton) {
			JOptionPane.showMessageDialog(null,"What do you get if when you cross a vampire with a snowman?");
		}
		else if(e.getSource()==lineButton) {
			JOptionPane.showMessageDialog(null, "Frostbite!");
		}
		
	}
}
