package mineSweeper;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *Author : Jackie-zhong
 *Time : 2022-12-08  下午8:17:43
 *
 */

public class GUI extends JFrame {

	/**
	 * 
	 */
	static JLabel left;
	private static final long serialVersionUID = 1L;
	public static Block[][] board;
	public static ImageIcon[] icon;
	static int x = 9;
	static int y = 9;
	static Font f = new Font(null, 0, 30);
	static JMenuItem restart;
	
	static {
		
		icon = new ImageIcon[14];
		for (int i = 0; i < icon.length; i++) {
//			icon[i] = new ImageIcon(
//					new ImageIcon("/" + i + ".png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
//			icon[i] = new ImageIcon(GUI.class.getResource("/" + i + ".png"));
			icon[i] = new ImageIcon(
					new ImageIcon(GUI.class.getResource("/" + i + ".png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			
		}
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// x16,y62
		setSize(x * 80 + 16, y * 80 + 62);
		setLocationRelativeTo(null);
		Block.mines = GenerateMines.count;

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu setting = new JMenu("Setting");
		setting.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(setting);

		restart = new JMenuItem("Restart");
		restart.setHorizontalAlignment(SwingConstants.CENTER);
		setting.add(restart);
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Block.countClick = 0;
				Block.open = 0;
				StartMineSweeper.gui.setVisible(false);
				StartMineSweeper.gui = new GUI();
			}
		});

		JMenuItem classic = new JMenuItem("Classic");
		classic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.x = 8;
				GUI.y = 8;
				GenerateMines.count = 9;
				restart.doClick();
			}
		});
		setting.add(classic);

		JMenuItem easy = new JMenuItem("Easy");
		easy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.x = 9;
				GUI.y = 9;
				GenerateMines.count = 10;
				restart.doClick();
			}
		});
		setting.add(easy);

		JMenuItem mid = new JMenuItem("Mid");
		mid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.x = 16;
				GUI.y = 16;
				GenerateMines.count = 40;
				restart.doClick();
			}
		});
		setting.add(mid);

		JMenuItem master = new JMenuItem("Master");
		master.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.x = 30;
				GUI.y = 16;
				GenerateMines.count = 99;
				restart.doClick();
			}
		});
		setting.add(master);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(x * 5, y * 8, x * 70, y * 70);

		board = new Block[y][x];
		for (int q = 0; q < y; q++) {
			for (int z = 0; z < x; z++) {
				board[q][z] = new Block(z, q);
				panel.add(board[q][z]);
			}
		}
		GenerateMines.Generate(x, y);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(y, x, 0, 0));

		JLabel text = new JLabel("剩余雷数");
		text.setFont(f);
		text.setBounds(x * 40 - 120, y * 7 - 50, 120, 50);
		getContentPane().add(text);
		

		left = new JLabel(String.valueOf(Block.mines));
		left.setFont(f);
		left.setBounds(x * 40, y * 7 - 50, 120, 50);
		getContentPane().add(left);

		setVisible(true);

	}
	
	public static void endDialog() {
		JOptionPane.showMessageDialog(null, "运气不太好，重来吧");
		restart.doClick();
	}
	
	public static void doneDialog() {
		JOptionPane.showMessageDialog(null, "恭喜通关，共计点击" + Block.countClick + "下鼠标");
		restart.doClick();
	}
}
