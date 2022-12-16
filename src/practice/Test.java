package practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/*
 *Author : Jackie-zhong
 *Time : 2022-12-08  ÏÂÎç7:50:11
 *
 */

public class Test extends JFrame{
	
	JButton t;
	static int left = 0;
	static int right = 0;

	public static void main(String[] args) {
//		Test x = new Test();
		System.out.println(Math.round(81 * (0.0255 * Math.log(81) + 0.0082)));
	}
	
	public Test() {
		this.setSize(500, 600);
		t = new JButton();
		t.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1 && right == 1) {
					System.out.println("haha");
					left = 0;
				} else if(e.getButton() == 3 && left == 1) {
					System.out.println("haha");
					right = 0;
				}else {
					if(e.getButton() == 1) {
						
						left = 0;
					}else {
						right = 0;
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == 1) {
					left = 1;
				} else if(e.getButton() == 3) {
					right = 1;
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(t, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
