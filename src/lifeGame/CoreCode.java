	package lifeGame;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;


public class CoreCode  extends Thread{
	
	static private Queue<MyJButton> dieList = new LinkedList<MyJButton>();
	static private Queue<MyJButton> aliveList = new LinkedList<MyJButton>();
	
	static boolean loop = false;
	
	public void run() {
		CoreCode.loop = true;
		while(CoreCode.loop) {
			oneStep();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static public void oneStep() {
		int count = 0;
		Queue<MyJButton> temp = null;
		for(int y = 0; y < GUI.chessBoard.length; y++) {
			for(int x = 0; x < GUI.chessBoard[0].length; x++) {
				if(GUI.chessBoard[y][x].sate.equals("alive")) {
					temp = dieList;
				}else {
					temp = aliveList;
				}
				for(int i = -1; i <=1; i++) {
					for(int c = -1; c <=1; c++) {
						if(i == 0 && c == 0) {
							continue;
						}
						if(y+i >= 0 && y+i < GUI.chessBoard.length && x+c >= 0 && x+c < GUI.chessBoard[0].length) {
							if(GUI.chessBoard[y+i][x+c].sate.equals("alive")) {
								count++;
							}
						}
					}
				}
				if(count <2) {
					if(temp == dieList) {
						temp.add(GUI.chessBoard[y][x]);
					}
				}else if(count == 3) {
					if(temp == aliveList) {
						temp.add(GUI.chessBoard[y][x]);
					}
				}else if(count >3) {
					if(temp == dieList) {
						temp.add(GUI.chessBoard[y][x]);
					}
				}
				count = 0;
				temp = null;
			}
		}
		dispose();
	}
	
	private static void dispose() {
		MyJButton temp;
		while(!dieList.isEmpty()) {
			temp = dieList.poll();
			temp.sate = "die";
			temp.setBackground(Color.GRAY);
		}
		while(!aliveList.isEmpty()) {
			temp = aliveList.poll();
			temp.sate = "alive";
			temp.setBackground(Color.WHITE);
		}
	}
	
}
