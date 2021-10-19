package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Suprise implements ActionListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton trickButton = new JButton();
	static JButton treatButton = new JButton();

	
	
		public void setup() {
		// TODO Auto-generated method stub
			frame.add(panel);
			panel.add(trickButton);
			panel.add(treatButton);
			trickButton.addActionListener(this);
			trickButton.setText("Trick");
			treatButton.setText("Treat");
			treatButton.addActionListener(this);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
	}
	private void showPictureFromTheInternet(String imageUrl) {
		    try {
		        URL url = new URL(imageUrl);
		        Icon icon = new ImageIcon(url);
		        JLabel imageLabel = new JLabel(icon);
		        JFrame frame = new JFrame();
		        frame.add(imageLabel);
		        frame.setVisible(true);
		        frame.pack();
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == trickButton) {
			showPictureFromTheInternet("https://www.gannett-cdn.com/presto/2020/03/17/USAT/c0eff9ec-e0e4-42db-b308-f748933229ee-XXX_ThinkstockPhotos-200460053-001.jpg?crop=1170%2C658%2Cx292%2Cy120&width=1200");
		}
		else if(buttonPressed == treatButton) {
			showPictureFromTheInternet("https://i.ytimg.com/vi/71Mp5lNyHzI/maxresdefault.jpg");
		}
		
	}
}
	