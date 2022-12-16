package slimFish;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.*;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	JLabel yearAndMonth;
	JButton startOrPause;
	JButton next;
	JButton reset;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("\u6A21\u62DF\u9C7C\u7FA4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		yearAndMonth = new JLabel("2020_1_1");
		yearAndMonth.setHorizontalAlignment(SwingConstants.CENTER);
		yearAndMonth.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
		yearAndMonth.setBounds(0, 587, 624, 35);
		contentPane.add(yearAndMonth);
		
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				if(Run.board[0][0] == 0) {
					return;
				}
				for(int x = 0; x < Run.board.length; x ++) {
					for(int y = 0; y < Run.board[0].length; y++) {
						g.setColor(new Color(((Run.board[x][y] - 5) * 12.75f) / 255f, 176f / 255f, (255 - (Run.board[x][y] - 5) * 12.75f) / 255f));
						g.fillRect(y * 14, x * 14, 14, 14);
					}
				}
				g.setColor(Color.green);
				g.fillOval(Run.y * 14 + 5, Run.x * 14 + 5, 4, 4);
				if(Run.px != -1 && Run.py != -1) {
					g.setColor(Color.black);
					g.drawLine(Run.y * 14 + 7, Run.x * 14 + 7, Run.py * 14 + 7, Run.px * 14 + 7);
				}
			}
		};
		panel.setBackground(Color.WHITE);
		panel.setBounds(27, 15, 560, 560);
		contentPane.add(panel);
		
		JLabel longitude120 = new JLabel("120\u00B0");
		longitude120.setBounds(27, 0, 55, 18);
		contentPane.add(longitude120);
		
		JLabel longitude160 = new JLabel("160\u00B0");
		longitude160.setHorizontalAlignment(SwingConstants.RIGHT);
		longitude160.setBounds(532, 0, 55, 18);
		contentPane.add(longitude160);
		
		JLabel lattude1 = new JLabel("40.5\u00B0");
		lattude1.setHorizontalAlignment(SwingConstants.CENTER);
		lattude1.setFont(new Font("Dialog", Font.BOLD, 10));
		lattude1.setBounds(0, 15, 29, 18);
		contentPane.add(lattude1);
		
		JLabel lattude1_1 = new JLabel("0.5\u00B0");
		lattude1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lattude1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lattude1_1.setBounds(0, 557, 29, 18);
		contentPane.add(lattude1_1);
		
		JPanel downPanel = new JPanel();
		downPanel.setBounds(0, 621, 624, 50);
		contentPane.add(downPanel);
		downPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		startOrPause = new JButton("\u5F00\u59CB/\u6682\u505C");
		startOrPause.setFocusPainted(false);
		startOrPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Run.loop == false) {
					Run.loop = true;
					new Run().start();
				}else {
					Run.loop = false;
				}
				
			}
		});
		downPanel.add(startOrPause);
		
		next = new JButton("\u4E0B\u4E00\u6B65");
		next.setFocusPainted(false);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Run.loop = false;
				Run.oneStep();
			}
			
		});
		downPanel.add(next);
		
		reset = new JButton("\u91CD\u7F6E");
		reset.setFocusPainted(false);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Run.init();
			}
		});
		downPanel.add(reset);
		
	}
}
