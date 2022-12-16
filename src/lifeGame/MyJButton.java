package lifeGame;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("all")
public class MyJButton extends JButton {
	String name, sate;
	
	public MyJButton(String name, ActionListener listener) {
		this.setFocusPainted(false);
		this.addActionListener(listener);
		this.setBackground(Color.GRAY);
		this.name = name;
		this.sate = "die";
	}
	
	public MyJButton(String name, String Text, ActionListener listener) {
		this.setFocusPainted(false);
		this.setText(Text);
		this.name = name;
		this.addActionListener(listener);
	}

}
