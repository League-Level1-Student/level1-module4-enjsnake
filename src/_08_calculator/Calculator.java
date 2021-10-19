package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel opPanel = new JPanel();
	JButton multiButton=new JButton();
	JButton addButton = new JButton();
	JButton divButton = new JButton();
	JButton subButton = new JButton();
	JTextField firstField=new JTextField(8);
	JTextField secondField = new JTextField(8);
	String response;
	
	Calculator(){
		frame.setTitle("Simple Calculator");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		opPanel.add(firstField);
		opPanel.add(secondField);
		opPanel.add(addButton);
		opPanel.add(subButton);
		opPanel.add(multiButton);
		opPanel.add(divButton);
		divButton.setText("div");
		divButton.addActionListener(this);
		multiButton.setText("mul");
		multiButton.addActionListener(this);
		addButton.setText("add");
		addButton.addActionListener(this);
		subButton.setText("sub");
		subButton.addActionListener(this);
		frame.add(opPanel);
		frame.setSize(250,150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int firstNum = Integer.parseInt(firstField.getText());
		int secondNum = Integer.parseInt(secondField.getText());
		if(e.getSource()==divButton) {
			JOptionPane.showMessageDialog(null,"The answer is " + divide(firstNum,secondNum));
			}
		else if(e.getSource() ==multiButton) {
			JOptionPane.showMessageDialog(null,"The answer is "+multiply(firstNum,secondNum));
		}
		else if(e.getSource()==subButton) {
			JOptionPane.showMessageDialog(null, "The answer is "+subtract(firstNum,secondNum));
		}
		else if(e.getSource()==addButton) {
			JOptionPane.showMessageDialog(null,"The answer is "+add(firstNum,secondNum));
		}
	}
	
	String divide(int firstNum,int secondNum) {
		return firstNum/secondNum+" remainder " + firstNum%secondNum;
	}
	int multiply(int firstNum,int secondNum) {
		return firstNum*secondNum;
	}
	int subtract(int firstNum,int secondNum) {
		return firstNum-secondNum;
	}
	int add(int firstNum,int secondNum) {
		return firstNum+secondNum;
	}
	
}
