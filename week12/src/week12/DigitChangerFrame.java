package week12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class DigitChangerFrame extends JFrame {
	JTextField src = new JTextField(10); 
	JTextField dest = new JTextField(10); 
	JRadioButton radio [] = new JRadioButton [4]; 
	String [] text = {"10진수", "2진수", "8진수", "16진수"};
	
	DigitChangerFrame() {
		super("진법 변환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup(); 
		MyItemListener listener = new MyItemListener(); 
		
		dest.setEditable(false);
		
		c.add(src);
		c.add(new JLabel(" == > "));
		c.add(dest);
		
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]); 
			radio[i].addItemListener(listener); 
			c.add(radio[i]); 
			g.add(radio[i]); 
		}
		
		setSize(300, 150);
		setVisible(true);
		
	}
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
		
			if(e.getStateChange() != ItemEvent.SELECTED)
				return;

			int n;
			String text = ((JRadioButton)e.getItem()).getText();
			try {
				switch(text) {		
					case "10진수":
						n = Integer.parseInt(src.getText());
						dest.setText(Integer.toString(n)); 
						break;
					case "2진수" :
						n = Integer.parseInt(src.getText());
						dest.setText(Integer.toBinaryString(n)); 
						break;				
					case "8진수" :
						n = Integer.parseInt(src.getText());
						dest.setText(Integer.toOctalString(n)); 
						break;						
					case "16진수" :
						n = Integer.parseInt(src.getText());
						dest.setText(Integer.toHexString(n)); 
						break;				
				}
			} catch(NumberFormatException exp) {
				dest.setText("변환할 수 없습니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		new DigitChangerFrame();
	}

}

