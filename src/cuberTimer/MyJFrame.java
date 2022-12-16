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
		str.setFont(new Font("΢���ź�", Font.BOLD, 20));
		up.add(str);
		down = new MyJPanel();
		menuBar = new JMenuBar();
		set = new JMenu("����");
		record = new JMenu("�ɼ�");
		in = new JMenuItem("����ɼ�");
		out = new JMenuItem("�����ɼ�");
		setting = new JMenuItem("��ɫ����");
		exit = new JMenuItem("�˳�");
		
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
