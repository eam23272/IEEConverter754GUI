import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class UserInterface implements ActionListener
{
	private JFrame userInterFace;
	private JLabel titleLabel;
	private JTextField userInput;
	private JPanel titlePanel,textFieldPanel, buttonsPanel, labelsPanel;
	private JLabel decimalNumberAnswer,singlePrecisionAnswer,doublePrecisionAnswer;
	private JLabel decimalNumberLabel, singlePrecisionLabel, doublePrecisionLabel;
	private JButton singlePrecisionToDecimalNumber,singlePrecisionConvert,doublePrecisionConvert,reset,doublePrecisionToDecimalNumber ;
	
	public void startingTheGUI()
	{
		userInterFace = new JFrame("UserInterface");
		userInterFace.setLayout(new GridLayout(4,1));
		
		titleLabel = new JLabel("Welcome to the Conversion World of Binarys and Decimals");
		titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(titleLabel);
		
		userInput = new JTextField(30);
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());
		textFieldPanel.add(userInput);
		
		
		singlePrecisionToDecimalNumber = new JButton("Single Precision to Decimal Number");
		doublePrecisionToDecimalNumber = new JButton("Double Precision to Decimal Number");
		singlePrecisionConvert = new JButton("Convert to 32 bit");
		doublePrecisionConvert = new JButton("Convert to 64 bit");
		reset = new JButton("Reset");
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.add(singlePrecisionToDecimalNumber);
		buttonsPanel.add(doublePrecisionToDecimalNumber);
		buttonsPanel.add(singlePrecisionConvert);
		buttonsPanel.add(doublePrecisionConvert);
		buttonsPanel.add(reset);
		
		
		decimalNumberLabel = new JLabel("Decimal Number: ");
		singlePrecisionLabel = new JLabel("Single Convert: ");
		doublePrecisionLabel = new JLabel("Double Convert:");
		decimalNumberAnswer = new JLabel();
		singlePrecisionAnswer = new JLabel();
		doublePrecisionAnswer = new JLabel();
		labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridLayout(3,3));
		labelsPanel.add(decimalNumberLabel);
		labelsPanel.add(decimalNumberAnswer);
		labelsPanel.add(singlePrecisionLabel);
		labelsPanel.add(singlePrecisionAnswer);
		labelsPanel.add(doublePrecisionLabel);
		labelsPanel.add(doublePrecisionAnswer);
		
		userInterFace.add(titlePanel);
		userInterFace.add(textFieldPanel);
		userInterFace.add(buttonsPanel);
		userInterFace.add(labelsPanel);
		
		singlePrecisionToDecimalNumber.addActionListener(this);
		doublePrecisionToDecimalNumber.addActionListener(this);
		singlePrecisionConvert.addActionListener(this);
		doublePrecisionConvert.addActionListener(this);
		reset.addActionListener(this);
		userInterFace.setVisible(true);
		userInterFace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInterFace.setSize(500, 500);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String answer = userInput.getText();
		if(arg0.getSource() == singlePrecisionConvert)
		{
			if(answer.equals(""))
			{ 
				JOptionPane.showMessageDialog(null, "Invalid Input");
			}
			else
			{
				singlePrecisionAnswer.setText(Conversions.decimalNumberTo32Bit(answer));
			}
			
		}
		else if(arg0.getSource() == reset)
		{
			singlePrecisionAnswer.setText("");
			doublePrecisionAnswer.setText("");
			decimalNumberAnswer.setText("");
			userInput.setText("");
		}
		else if(arg0.getSource() == doublePrecisionConvert)
		{
			if(answer.equals(""))
			{ 
				JOptionPane.showMessageDialog(null, "Invalid Input");
			}
			else
			{
				doublePrecisionAnswer.setText(Conversions.decimalNumberTo64Bit(answer));
			}
		}
		else if(arg0.getSource() == singlePrecisionToDecimalNumber)
		{
			decimalNumberAnswer.setText(Conversions.binaryToFloat(singlePrecisionAnswer.getText()) + "");
		}
		else if(arg0.getSource() == doublePrecisionToDecimalNumber)
		{
			decimalNumberAnswer.setText(Conversions.binaryToDouble(doublePrecisionAnswer.getText()) + "");
		}
		
		
		
	}

}
