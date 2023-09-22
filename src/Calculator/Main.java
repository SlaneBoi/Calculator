package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subtractButton, multiplicityButton, divisionButton;
	JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;
	JPanel panel;
	
	Font calcFont = new Font("Times New Roman", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Main(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(calcFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplicityButton = new JButton("*");
		divisionButton = new JButton("/");
		decimalButton = new JButton(".");
		equalButton = new JButton("=");
		deleteButton = new JButton("DEL");
		clearButton = new JButton("C");
		negativeButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subtractButton;
		functionButtons[2] = multiplicityButton;
		functionButtons[3] = divisionButton;
		functionButtons[4] = decimalButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = deleteButton;
		functionButtons[7] = clearButton;
		functionButtons[8] = negativeButton;
		
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(calcFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(calcFont);
			numberButtons[i].setFocusable(false);
		}
		
		negativeButton.setBounds(50, 420, 100, 50);
		deleteButton.setBounds(150, 420, 100, 50);
		clearButton.setBounds(250, 420, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
 
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subtractButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplicityButton);
		panel.add(decimalButton);
		panel.add(numberButtons[0]);
		panel.add(equalButton);
		panel.add(divisionButton);
		
		frame.add(panel);
		frame.add(negativeButton);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decimalButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subtractButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==multiplicityButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divisionButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equalButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clearButton) {
			textfield.setText("");
		}
		if(e.getSource()==deleteButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negativeButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}