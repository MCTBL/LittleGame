package mineSweeper;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.JButton;

/*
 *Author : Jackie-zhong
 *Time : 2022-12-08  ÏÂÎç10:14:28
 *
 */

public class Block extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int left;
	int right;
	static int mines;
	// 0null,1~8 arround,9mine
	int status;
	// 0null,1flag,2qm
	int x;
	int y;
	static int countClick = 0;
	static Stack<Block> list = new Stack<>();
	static int open = 0;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		this.status = 0;
		this.left = 0;
		this.right = 0;
		this.setIcon(GUI.icon[0]);
		this.setPressedIcon(GUI.icon[13]);
		this.setFocusPainted(false);
		this.setFont(new Font(TOOL_TIP_TEXT_KEY, 1, 25));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == 1 && right == 1) {
					leftAndRight();
					left = 0;
				} else if (e.getButton() == 3 && left == 1) {
					leftAndRight();
					right = 0;
				} else {
					if (e.getButton() == 1) {
						active();
						left = 0;
					} else {
						changeStatus();
						right = 0;
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 1) {
					left = 1;
				} else if (e.getButton() == 3) {
					right = 1;
				}
				countClick++;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

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
	}

	private void active() {
		if (this.status == 0) {
			int temp = GenerateMines.mines[this.y][this.x];
			if (temp != 0 && this.getIcon() == GUI.icon[0]) {
				this.setIcon(GUI.icon[temp]);
				if(temp == 9) {
					end();
					return;
				}
				open ++;
			} else if(temp == 0 && this.getIcon() == GUI.icon[0]) {
				this.setIcon(GUI.icon[13]);
				open ++;
				wave(this);
			}
			this.setPressedIcon(null);
		}
		if(open == GenerateMines.size - GenerateMines.count) {
			GUI.doneDialog();
		}
	}

	private void changeStatus() {
		if (this.getIcon() != GUI.icon[0] && this.getIcon() != GUI.icon[10] && this.getIcon() != GUI.icon[11]) {
			return;
		}
		switch (this.status) {
		case 0:
			this.status = 1;
			this.setIcon(GUI.icon[10]);
			Block.mines--;
			break;
		case 1:
			this.status = 2;
			this.setIcon(GUI.icon[11]);
			Block.mines++;
			break;
		case 2:
			this.status = 0;
			this.setIcon(GUI.icon[0]);
			break;
		}
		GUI.left.setText(String.valueOf(Block.mines));

	}

	private static void wave(Block s) {
		list.add(s);
		Block temp;
		while (!list.isEmpty()) {
			temp = list.pop();
			int tempY = temp.y;
			int tempX = temp.x;
			for (int z = -1; z <= 1; z++) {
				for (int q = -1; q <= 1; q++) {
					if (z == 0 && q == 0) {
						continue;
					}
					if (tempY + z >= 0 && tempY + z < GenerateMines.mines.length && tempX + q >= 0
							&& tempX + q < GenerateMines.mines[0].length) {
						if(GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[0]) {
							open++;
						}
						if (GenerateMines.mines[tempY + z][tempX + q] == 0
								&& GUI.board[tempY + z][tempX + q].getIcon() != GUI.icon[13]) {
							list.add(GUI.board[tempY + z][tempX + q]);
						}
						if (GenerateMines.mines[tempY + z][tempX + q] != 0) {
							GUI.board[tempY + z][tempX + q]
									.setIcon(GUI.icon[GenerateMines.mines[tempY + z][tempX + q]]);
						} else {
							GUI.board[tempY + z][tempX + q].setIcon(GUI.icon[13]);
						}
						GUI.board[tempY + z][tempX + q].setPressedIcon(null);
					}
				}
			}
		}
	}

	private void leftAndRight() {
		int tempX = this.x;
		int tempY = this.y;
		int count = GenerateMines.mines[tempY][tempX];
		int right = 0;
		int flag = 0;
		for (int z = -1; z <= 1; z++) {
			for (int q = -1; q <= 1; q++) {
				if (z == 0 && q == 0) {
					continue;
				}
				if (tempY + z >= 0 && tempY + z < GenerateMines.mines.length && tempX + q >= 0
						&& tempX + q < GenerateMines.mines[0].length) {
					if(GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[13]) {
						continue;
					}
					if (GenerateMines.mines[tempY + z][tempX + q] == 9
							&& GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[10]) {
						right++;
						flag++;
					}else if(GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[10]) {
						flag++;
					}
				}
			}
		}
		if(flag > count || (flag == count && right != count)) {
			end();
		}else if(flag == count && right == count) {
			for (int z = -1; z <= 1; z++) {
				for (int q = -1; q <= 1; q++) {
					if (z == 0 && q == 0) {
						continue;
					}
					if (tempY + z >= 0 && tempY + z < GenerateMines.mines.length && tempX + q >= 0
							&& tempX + q < GenerateMines.mines[0].length) {
						if(GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[13]) {
							continue;
						}
						if(GUI.board[tempY + z][tempX + q].getIcon() == GUI.icon[0]) {
							GUI.board[tempY + z][tempX + q].active();
						}
					}
				}
			}
		}
	}
	
	static void end() {
		for(int q = 0; q < GenerateMines.mines.length; q ++) {
			for(int z = 0; z < GenerateMines.mines[0].length; z ++) {
				if(GenerateMines.mines[q][z] == 9) {
					if(GUI.board[q][z].getIcon() == GUI.icon[10]) {
						GUI.board[q][z].setIcon(GUI.icon[12]);
					}else {
						GUI.board[q][z].setIcon(GUI.icon[9]);
					}
				}
			}
		}
		GUI.endDialog();
	}

}
