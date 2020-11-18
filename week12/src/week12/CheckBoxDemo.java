package week12;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CheckBoxDemo extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	JCheckBox[] buttons = new JCheckBox[4];
	String[] fruits = { "�������� ��ȯ", "�ڵ����ӱ���ϱ�ȯ", "���������ͱ�ȯ", "Ÿ�̾� ��ȯ"};
	int[] prices = { 45000, 80000, 30000, 100000 };
	int money=0;
	JLabel label;
	JPanel panel;
	
	public CheckBoxDemo() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		panel = new JPanel();
		for (int i = 0; i < 4; i++) {
			buttons[i] = new JCheckBox(fruits[i]);
			buttons[i].addItemListener(this);
		}
		for (int i = 0; i < 4; i++)
			panel.add(buttons[i]);
		label = new JLabel("��������� ������ "+money+"�� �Դϴ�.");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30)); 
		panel.setOpaque(true); 
		panel.add(label);
		add(panel);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		for (int i = 0; i < 4; i++) {
			if (source == buttons[i]) {
				if (e.getStateChange() == ItemEvent.DESELECTED)
					money -= prices[i];
				else
					money += prices[i];
				String str = String.format("%,d", money);
				label.setText("��������� ������ "+str+"�� �Դϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		 new CheckBoxDemo();
	}
}