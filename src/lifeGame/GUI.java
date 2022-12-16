package lifeGame;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("all")
public class GUI extends JFrame {
	JPanel up, down;
	static MyJButton chessBoard[][], start, reset, nextStep, stop;
	MyActionListener linstener;
	int size = 100;
	
	public GUI() {
		// TODO Auto-generated constructor stub
		linstener = new MyActionListener();
		
		chessBoard = new MyJButton[size][size];
		
		start = new MyJButton("start", "开始/暂停", linstener);
//		stop = new MyJButton("stop", "暂停", linstener);
		nextStep = new MyJButton("nextStep", "下一步", linstener);
		reset = new MyJButton("reset", "重置棋盘", linstener);
		
		
		up = new JPanel();
		down = new JPanel(new GridLayout(size, size, 1, 1));
		
		
		up.add(start);
//		up.add(stop);
		up.add(nextStep);
		up.add(reset);
		
		for(int x = 0; x < size*size; x++) {
			chessBoard[(int)(x/size)][(x%size)] = new MyJButton("chess", linstener);
			down.add(chessBoard[(int)(x/size)][(x%size)]);
		}
		
		
		
		this.add(up, BorderLayout.SOUTH);
		this.add(down, BorderLayout.CENTER);
		
		
		this.setTitle("康威生命游戏");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(size*12, size*15);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
