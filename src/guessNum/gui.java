package guessNum;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class gui extends JFrame{
	JLabel jl1;
	JButton jb[],test;
	JLabel num[];
	JPanel jp1,jp2;
	private int nums[]=new int[4],temp,temp2[];
	action a=new action();
	
	public gui() {
		do {
			temp=(int)(Math.random()*10000);
			nums[0]=temp/1000;
			nums[1]=temp%1000/100;
			nums[2]=temp%100/10;
			nums[3]=temp%10;
			if(nums[0]!=nums[1]&&nums[0]!=nums[2]&&nums[0]!=nums[3]&&nums[1]!=nums[2]&&nums[1]!=nums[3]&&nums[2]!=nums[3]) {
				break;
			}
		}while(true);
		temp2=new int[4];
		for(int i=0;i<4;i++) {
			temp2[i]=0;
		}
		
		//jl1=new JLabel(nums[0]+""+nums[1]+""+nums[2]+""+nums[3]);
		jl1=new JLabel();
		jb=new JButton[8];
		for(int i=0;i<8;i++) {
			if(i<4) {
				jb[i]=new JButton("¡ü");
			}else {
				jb[i]=new JButton("¡ý");
			}
			jb[i].addActionListener(a);
		}
		test=new JButton("³¢ÊÔ");
		test.addActionListener(a);
		num=new JLabel[4];
		for(int i=0;i<4;i++) {
			num[i]=new JLabel("             "+temp2[i]);
		}
		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.setLayout(new GridLayout(3,4,10,10));
		for(int i=0;i<4;i++) {
			jp1.add(jb[i]);
		}
		for(int i=0;i<4;i++) {
			jp1.add(num[i]);
		}
		for(int i=4;i<8;i++) {
			jp1.add(jb[i]);
		}
		jp2.setLayout(new GridLayout(2,1,0,20));
		jp2.add(test);
		jp2.add(jl1);
		
		
		this.add(jp1,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setSize(400,500);
		this.setLocation(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent x) {
			// TODO Auto-generated method stub
			if(x.getSource()==jb[0]) {
				temp2[0]++;
				if(temp2[0]==10) {
					temp2[0]=0;
				}
				num[0].setText("             "+temp2[0]);
			}else if(x.getSource()==jb[1]){
				temp2[1]++;
				if(temp2[1]==10) {
					temp2[1]=0;
				}
				num[1].setText("             "+temp2[1]);
			}else if(x.getSource()==jb[2]){
				temp2[2]++;
				if(temp2[2]==10) {
					temp2[2]=0;
				}
				num[2].setText("             "+temp2[2]);
			}else if(x.getSource()==jb[3]){
				temp2[3]++;
				if(temp2[3]==10) {
					temp2[3]=0;
				}
				num[3].setText("             "+temp2[3]);
			}else if(x.getSource()==jb[4]){
				temp2[0]--;
				if(temp2[0]==-1) {
					temp2[0]=9;
				}
				num[0].setText("             "+temp2[0]);
			}else if(x.getSource()==jb[5]){
				temp2[1]--;
				if(temp2[1]==-1) {
					temp2[1]=9;
				}
				num[1].setText("             "+temp2[1]);
			}else if(x.getSource()==jb[6]){
				temp2[2]--;
				if(temp2[2]==-1) {
					temp2[2]=9;
				}
				num[2].setText("             "+temp2[2]);
			}else if(x.getSource()==jb[7]){
				temp2[3]--;
				if(temp2[3]==-1) {
					temp2[3]=9;
				}
				num[3].setText("             "+temp2[3]);
			}else if(x.getSource()==test) {
				if(nums[0]==temp2[0]) {
					num[0].setForeground(Color.GREEN);
				}else if(temp2[0]==nums[1]||temp2[0]==nums[2]||temp2[0]==nums[3]) {
					num[0].setForeground(Color.GRAY);
				}else {
					num[0].setForeground(Color.RED);
				}
				if(nums[1]==temp2[1]) {
					num[1].setForeground(Color.GREEN);
				}else if(temp2[1]==nums[2]||temp2[1]==nums[3]) {
					num[1].setForeground(Color.GRAY);
				}else {
					num[1].setForeground(Color.RED);
				}
				if(nums[2]==temp2[2]) {
					num[2].setForeground(Color.GREEN);
				}else if(temp2[2]==nums[3]) {
					num[2].setForeground(Color.GRAY);
				}else {
					num[2].setForeground(Color.RED);
				}
				if(nums[3]==temp2[3]) {
					num[3].setForeground(Color.GREEN);
				}else {
					num[3].setForeground(Color.RED);
				}
				if(nums[0]==temp2[0]&&nums[1]==temp2[1]&&nums[2]==temp2[2]&&nums[3]==temp2[3]) {
					jl1.setText("ÕýÈ·");
				}
			}
		}
		
	}
	
}