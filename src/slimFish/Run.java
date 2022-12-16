package slimFish;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Run extends Thread{
	
	static float[][] board;
	public static boolean loop = false;
	public static GUI gui;
	public static ReadData rd;
	public static int x;
	public static int px = -1;
	public static int y;
	public static int py = -1;
	public static int year;
	public static int month;
	public static int date;
	public static Random ran;
	public static double max;
	public static double min;
	public static double mid;
	
	public static void main(String[] args) {
		Scanner inPut = new Scanner(System.in);
		System.out.print("请输入最高适宜温度");
		max = inPut.nextDouble();
		System.out.print("请输入最低适宜温度");
		min = inPut.nextDouble();
		mid = (max + min) / 2;
		inPut.close();
		init();
	}
	
	public static void init() {
		loop = false;
		ran = new Random();
		board = new float[40][40];
		rd = new ReadData();
		rd.readData("数据/2020_1.csv");
		gui = gui == null ? new GUI() : gui;
		year = 2020;
		month = 1;
		date = 1;
		px = -1;
		py = -1;
		gui.setVisible(true);
		x = ran.nextInt(40);
		y = ran.nextInt(40);
		flush();
	}
	
	public static void flush() {
		gui.yearAndMonth.setText(year + "_" + month + "_" + date);
		gui.panel.repaint();
		gui.repaint();
	}
	
	public static void oneStep() {
		int l = 0;
		switch(month) {
		case 2:
			l = year % 4 == 0 ? 29 : 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			l = 31;
			break;
		default:
			l = 30;
			break;
		}
		if(date + 1 > l) {
			month ++;
			date = 1;
		}else {
			date ++;
		}
		if(month > 12) {
			year ++;
			month = 1;
		}
		if(year > 2021) {
			return;
		}
		rd.readData("数据/" + year + "_" + month + ".csv");
		/**
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 移动代号
		 */
		px = x;
		py = y;
		double min = 99999999;
		int minIndex = 0;
		ArrayList<Integer> temp = new ArrayList<>();
		if(x - 1 >= 0 && y - 1 >= 0) {//1
			if(board[x - 1][y - 1] >= min && board[x - 1][y - 1] <= max) {
				temp.add(1);
			}else {
				if(Math.pow((board[x - 1][y - 1] - mid), 2) < min) {
					minIndex = 1;
					min = Math.pow((board[x - 1][y - 1] - mid), 2);
				}
			}
		}
		if(x - 1 >= 0) {//2
			if(board[x - 1][y] >= min && board[x - 1][y] <= max) {
				temp.add(2);
			}else {
				if(Math.pow((board[x - 1][y] - mid), 2) < min) {
					minIndex = 2;
					min = Math.pow((board[x - 1][y] - mid), 2);
				}
			}
		}
		if(x - 1 >= 0 && y + 1 < 40) {//3
			if(board[x - 1][y + 1] >= min && board[x - 1][y + 1] <= max) {
				temp.add(3);
			}else {
				if(Math.pow((board[x - 1][y + 1] - mid), 2) < min) {
					minIndex = 3;
					min = Math.pow((board[x - 1][y + 1] - mid), 2);
				}
			}
		}
		if(y - 1 >= 0) {//4
			if(board[x][y - 1] >= min && board[x][y - 1] <= max) {
				temp.add(4);
			}else {
				if(Math.pow((board[x][y - 1] - mid), 2) < min) {
					minIndex = 4;
					min = Math.pow((board[x][y - 1] - mid), 2);
				}
			}
		}
		if(board[x][y] >= min && board[x][y] <= max) {
			temp.add(5);
		}else {
//			if(Math.pow((bored[x][y] - 20), 2) < min) {
//				minIndex = 5;
//				min = Math.pow((bored[x][y] - 20), 2);
//			}
		}
		if(y + 1 < 40) {//6
			if(board[x][y + 1] >= min && board[x][y + 1] <= max) {
				temp.add(6);
			}else {
				if(Math.pow((board[x][y + 1] - mid), 2) < min) {
					minIndex = 6;
					min = Math.pow((board[x][y + 1] - mid), 2);
				}
			}
		}
		if(x + 1 < 40 && y - 1 >= 0) {//7
			if(board[x + 1][y - 1] >= min && board[x + 1][y - 1] <= max) {
				temp.add(7);
			}else {
				if(Math.pow((board[x + 1][y - 1] - mid), 2) < min) {
					minIndex = 7;
					min = Math.pow((board[x + 1][y - 1] - mid), 2);
				}
			}
		}
		if(x + 1 < 40) {//8
			if(board[x + 1][y] >= min && board[x + 1][y] <= max) {
				temp.add(8);
			}else {
				if(Math.pow((board[x + 1][y] - mid), 2) < min) {
					minIndex = 8;
					min = Math.pow((board[x + 1][y] - mid), 2);
				}
			}
		}
		if(x + 1 < 40 && y + 1 < 40) {//9
			if(board[x + 1][y + 1] >= min && board[x + 1][y + 1] <= max) {
				temp.add(9);
			}else {
				if(Math.pow((board[x + 1][y + 1] - mid), 2) < min) {
					minIndex = 9;
					min = Math.pow((board[x + 1][y + 1] - mid), 2);
				}
			}
		}
		if(temp.size() == 0) {
			switch(minIndex) {
			case 1:
				x -= 1;
				y -= 1;
				break;
			case 2:
				x -= 1;
				break;
			case 3:
				x -= 1;
				y += 1;
				break;
			case 4:
				y -= 1;
				break;
			case 6:
				y += 1;
				break;
			case 7:
				x += 1;
				y -= 1;
				break;
			case 8:
				x += 1;
				break;
			case 9:
				x += 1;
				y += 1;
				break;
			default:
			}
		}else {
			switch(temp.get(ran.nextInt(temp.size()))) {
			case 1:
				x -= 1;
				y -= 1;
				break;
			case 2:
				x -= 1;
				break;
			case 3:
				x -= 1;
				y += 1;
				break;
			case 4:
				y -= 1;
				break;
			case 6:
				y += 1;
				break;
			case 7:
				x += 1;
				y -= 1;
				break;
			case 8:
				x += 1;
				break;
			case 9:
				x += 1;
				y += 1;
				break;
			default:
			}
		}
		flush();
	}
	
	@Override
	public void run() {
		while(loop) {
			oneStep();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
