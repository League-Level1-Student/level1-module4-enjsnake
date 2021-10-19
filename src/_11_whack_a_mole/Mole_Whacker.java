package _11_whack_a_mole;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mole_Whacker implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random ran = new Random();
	JButton moleButton = new JButton();
	Date timeAtStart= new Date();
	int score=0;
	Mole_Whacker(){
		makeButtons();
	}
	void makeButtons() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Whack a Button for Fame and Glory!");
		frame.setSize(400,700);
		moleButton.addActionListener(this);
		frame.add(panel);
		panel.setLayout(new GridLayout(8,3));
		
		int moleNum=ran.nextInt(24);
		for(int i=0;i<moleNum;i++) {
			JButton button = new JButton();
			button.setSize(100,50);
			button.addActionListener(this);
			panel.add(button);
		}
		moleButton.setText("Mole!");
		panel.add(moleButton);
		for(int i=moleNum+1;i<24;i++) {
		JButton button = new JButton();
		button.addActionListener(this);
		panel.add(button);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==moleButton) {
			score++;
			
			if(score>=10) {
				endGame(timeAtStart,score);
			}
			else {
				
			}
			playNoise("creepy-noise.wav");
		}
		else {
			speak("Incorrect");
		}
		frame.dispose();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeButtons();
		frame.add(panel);
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
	 private void playNoise(String soundFile) {
			
				File sound = new File("src/_11_whack_a_mole/"+soundFile);
				if (sound.exists()) {
					new Thread(() -> {
					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(sound));
						clip.start();
						Thread.sleep(clip.getMicrosecondLength()/1000);
					}
					catch (Exception e) {
						System.out.println("Could not play this sound");
					}}).start();
		 		}
				else {
					System.out.println("File does not exist");
				}
			
		}


}
