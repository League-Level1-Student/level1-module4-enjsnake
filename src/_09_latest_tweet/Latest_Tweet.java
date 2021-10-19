package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Latest_Tweet implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel=new JPanel();
	JTextField textField=new JTextField(12);
	JButton button = new JButton();
	Latest_Tweet(){
		frame.setTitle("The Amazing Twitter Retriver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.add(textField);
		panel.add(button);
		button.setText("Search the Twitterverse");
		button.addActionListener(this);
		frame.add(panel);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Tweet, tweet");
		System.out.println(getLatestTweet(textField.getText()));
		
	}
	private String getLatestTweet(String searchingFor) {

	    Twitter twitter = new TwitterFactory().getInstance();

	    AccessToken accessToken = new AccessToken(
	        "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	        "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
	    twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	        "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
	    twitter.setOAuthAccessToken(accessToken);

	Query query = new Query(searchingFor);
	    try {
	        QueryResult result = twitter.search(query);
	        return result.getTweets().get(0).getText();
	    } catch (Exception e) {
	        System.err.print(e.getMessage());
	        return "What the heck is that?";
	    }
	}
}
