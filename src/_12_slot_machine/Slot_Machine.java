package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slot_Machine implements ActionListener {
	JFrame frame = new JFrame();
	int firstNum;
	int secondNum;
	int thirdNum;
	JPanel panel = new JPanel();
	JLabel firstPanel=new JLabel();
	JLabel secondPanel=new JLabel();
	JLabel thirdPanel= new JLabel();
	Random ran = new Random();
	JButton button = new JButton();
	Slot_Machine(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
		button.setText("SPIN");
		panel.add(firstPanel);
		panel.add(secondPanel);
		panel.add(thirdPanel);
		panel.add(button);
		setImages();
		frame.add(panel);
		frame.pack();
	}
	private Icon createLabelImage(String fileName) {
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return null;
	}
	Icon icon = new ImageIcon(imageURL);
	return icon;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setImages();
	}
	public void setImages() {
		firstNum=ran.nextInt(3);
		secondNum=ran.nextInt(3);
		thirdNum=ran.nextInt(3);
		if(firstNum==0) {
			
				firstPanel.setIcon(createLabelImage("Cherry.png"));
			
			
		}
		else if(firstNum==1) {
			
				firstPanel.setIcon(createLabelImage("lime.png"));
			
		}
		else if(firstNum==2) {
		
				firstPanel.setIcon(createLabelImage("orange.jpg"));
			
		}
		if(secondNum==0) {
			secondPanel.setIcon(createLabelImage("Cherry.png"));
		}
		else if(secondNum==1) {
			secondPanel.setIcon(createLabelImage("lime.png"));
		}
		else if(secondNum==2) {
			secondPanel.setIcon(createLabelImage("orange.jpg"));
		}
		if(thirdNum==0) {
			thirdPanel.setIcon(createLabelImage("Cherry.png"));
		}
		else if(thirdNum==1) {
			thirdPanel.setIcon(createLabelImage("lime.png"));
		}
		else if(thirdNum==2) {
			thirdPanel.setIcon(createLabelImage("orange.jpg"));
		}
		if(firstNum==secondNum&&secondNum==thirdNum) {
			JOptionPane.showMessageDialog(null, "You win!");
		}
		
		frame.pack();
	}

}
