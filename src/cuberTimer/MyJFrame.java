package cuberTimer;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("all")
public class MyJFrame extends JFrame {
	JPanel up, down;
	JLabel str;
	JMenuBar menuBar;
	JMenu set, record;
	JMenuItem in, out, setting, exit;
	
	static String setup;
	
	public MyJFrame() {
		// TODO Auto-generated constructor stub
		setup = UpSet.setup();
		up = new JPanel();
		str = new JLabel(setup);
		str.setFont(new Font("微软雅黑", Font.BOLD, 20));
		up.add(str);
		down = new MyJPanel();
		menuBar = new JMenuBar();
		set = new JMenu("设置");
		record = new JMenu("成绩");
		in = new JMenuItem("导入成绩");
		out = new JMenuItem("导出成绩");
		setting = new JMenuItem("颜色设置");
		exit = new JMenuItem("退出");
		
		set.add(setting);
		set.add(exit);
		record.add(in);
		record.add(out);
		
		
		menuBar.add(set);
		menuBar.add(record);
		
		
		this.setJMenuBar(menuBar);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);//JFrame.EXIT_ON_CLOSE
		this.setLayout(new GridLayout(2, 1));
		this.add(up);
		this.add(down);
		this.setVisible(true);
	}
	
}
