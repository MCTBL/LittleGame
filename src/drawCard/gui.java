package drawCard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class gui extends JFrame{
	JButton once,tenth;
	JPanel jp1,jp2;
	JLabel jl,ans[];
	int count=0;
	int temp,plus;
	final int DEFULTTHREE=40,DEFULTFOUR=90,DEFULTFIVE=98,DEFULTSIX=100;
	JComboBox<?> lang;
	
	listener ls=new listener();
	
	
	final String TREE[]= {"��","���","����","õ��ɯ","���տ�","���","�׸�³","�ߵ�","����˿","�����ж�","����","ܽ��","������","ʷ������","����","�ձ�","�¼�ҹ"};
	final String FOUR[]= {"ҹ��","Զɽ","������","������","����","����","÷","��ѩ","���ȶ�","Ѷʹ","�����","�춹","�ҽ���","�ű�","����","˪Ҷ","��˿���","Ľ˹","��","����","ĩҩ","��ά��","������","����ʦ","�Ƿ�","������","����","����","�ɫ","����","��ɣ","����","�Է�"};
	final String FIVE[]= {"�����^","΢��","�ݶ�","�¿���˹","έ��","ʫ����","ܽ����","�׿�","��������","������","���忨","�Ǽ�","����","�׽�","�Һ�","����","������","�����","���","����","÷��","��Ĭ","������","����","�ٹ�","��","��","����","����","����","����","����","������˹","������","����","ѩ��","��ѩ","����","���Ϳ�˹","��","ʨЫ","ʳ����","����","ҹħ","������"};
	final String SIX[]= {"����ʹ","��","�ƽ�֮��","��ܽ����","Ī˹����","���ŷ���","�̶��","��������","������","��","����","ҹݺ","����","�����","��","����","��","��","������","˹����"};
	
	String tempSix="����˹����\r\n"
			+ "Skadi the Corrupting Heart\r\n"
			+ "����ϣ\r\n"
			+ "Kal'tsit\r\n"
			+ "���ٵ��\r\n"
			+ "Gladiia\r\n"
			+ "���\r\n"
			+ "Passenger\r\n"
			+ "�ҽ�\r\n"
			+ "Ash\r\n"
			+ "Ϧ\r\n"
			+ "Dusk\r\n"
			+ "�϶�\r\n"
			+ "Saga\r\n"
			+ "����\r\n"
			+ "Archetto\r\n"
			+ "ɽ\r\n"
			+ "Mountain\r\n"
			+ "�Ե���\r\n"
			+ "Rosmontis\r\n"
			+ "����\r\n"
			+ "Mudrock\r\n"
			+ "覹�\r\n"
			+ "Blemishine\r\n"
			+ "ʷ���ض�\r\n"
			+ "Surtr\r\n"
			+ "ɭ��\r\n"
			+ "Eunectes\r\n"
			+ "����\r\n"
			+ "Thorns\r\n"
			+ "����\r\n"
			+ "Suzuran\r\n"
			+ "��¶\r\n"
			+ "������\r\n"
			+ "W\r\n"
			+ "W\r\n"
			+ "�µ�\r\n"
			+ "Weedy\r\n"
			+ "��Ӱ\r\n"
			+ "Phantom\r\n"
			+ "���\r\n"
			+ "Bagpipe\r\n"
			+ "�̶��\r\n"
			+ "Ceobe\r\n"
			+ "��\r\n"
			+ "Nian\r\n"
			+ "��\r\n"
			+ "Aak\r\n"
			+ "��\r\n"
			+ "Blaze\r\n"
			+ "Ī˹����\r\n"
			+ "Mostima\r\n"
			+ "������\r\n"
			+ "Magallan\r\n"
			+ "������\r\n"
			+ "Hellagur\r\n"
			+ "��\r\n"
			+ "Schwarz\r\n"
			+ "��\r\n"
			+ "Ch'en\r\n"
			+ "˹����\r\n"
			+ "Skadi\r\n"
			+ "����\r\n"
			+ "SilverAsh\r\n"
			+ "�����\r\n"
			+ "Saria\r\n"
			+ "����\r\n"
			+ "Hoshiguma\r\n"
			+ "ҹݺ\r\n"
			+ "Nightingale\r\n"
			+ "����\r\n"
			+ "Shining\r\n"
			+ "��������\r\n"
			+ "Angelina\r\n"
			+ "���ŷ���\r\n"
			+ "Eyjafjalla\r\n"
			+ "��ܽ����\r\n"
			+ "Ifrit\r\n"
			+ "�ƽ�֮��\r\n"
			+ "Siege\r\n"
			+ "����ʹ\r\n"
			+ "Exusiai\r\n";
	String tempFive="�ඬ\r\n"
			+ "Akafuyu\r\n"
			+ "��Ȫ\r\n"
			+ "Toddifons\r\n"
			+ "����\r\n"
			+ "Heavyrain\r\n"
			+ "˪��\r\n"
			+ "Frost\r\n"
			+ "����\r\n"
			+ "Blitz\r\n"
			+ "ս��\r\n"
			+ "Tachanka\r\n"
			+ "����\r\n"
			+ "Mr.Nothing\r\n"
			+ "��������\r\n"
			+ "Lava the Purgatory\r\n"
			+ "ͼҮ\r\n"
			+ "Tuye\r\n"
			+ "����˿\r\n"
			+ "Iris\r\n"
			+ "����\r\n"
			+ "Kafka\r\n"
			+ "�ޱ�\r\n"
			+ "Robin\r\n"
			+ "�����(����)\r\n"
			+ "Amiya\r\n"
			+ "����\r\n"
			+ "Whisperain\r\n"
			+ "��˹��\r\n"
			+ "Aosta\r\n"
			+ "����\r\n"
			+ "Whislash\r\n"
			+ "����\r\n"
			+ "April\r\n"
			+ "����\r\n"
			+ "Mint\r\n"
			+ "��ʯ\r\n"
			+ "Flint\r\n"
			+ "������\r\n"
			+ "Tomimi\r\n"
			+ "������\r\n"
			+ "Andreana\r\n"
			+ "��ά\r\n"
			+ "Chiave\r\n"
			+ "����\r\n"
			+ "Beeswax\r\n"
			+ "ϡ��\r\n"
			+ "Scene\r\n"
			+ "����\r\n"
			+ "Ayerscarpe\r\n"
			+ "��Ҷ\r\n"
			+ "Folinic\r\n"
			+ "��������\r\n"
			+ "Leonhardt\r\n"
			+ "�బ\r\n"
			+ "Absinthe\r\n"
			+ "�º�\r\n"
			+ "Tsukinogi\r\n"
			+ "ʯ��\r\n"
			+ "Asbestos\r\n"
			+ "����\r\n"
			+ "Elysium\r\n"
			+ "����\r\n"
			+ "Shamare\r\n"
			+ "����\r\n"
			+ "Sideroca\r\n"
			+ "��ɰ\r\n"
			+ "Sesa\r\n"
			+ "���\r\n"
			+ "Bibeak\r\n"
			+ "����\r\n"
			+ "Leizi\r\n"
			+ "��\r\n"
			+ "Hung\r\n"
			+ "ѩ��\r\n"
			+ "Snowsant\r\n"
			+ "�Һ�\r\n"
			+ "GreyThroat\r\n"
			+ "���忨\r\n"
			+ "Broca\r\n"
			+ "έ��\r\n"
			+ "Reed\r\n"
			+ "����\r\n"
			+ "Waai Fu\r\n"
			+ "����\r\n"
			+ "Bison\r\n"
			+ "΢��\r\n"
			+ "Breeze\r\n"
			+ "������\r\n"
			+ "Executor\r\n"
			+ "�׿�\r\n"
			+ "Flamebringer\r\n"
			+ "�Ǽ�\r\n"
			+ "Astesia\r\n"
			+ "���Ϳ�˹\r\n"
			+ "Glaucus\r\n"
			+ "����\r\n"
			+ "Ceylon\r\n"
			+ "ʫ����\r\n"
			+ "Swire\r\n";
	String tempFour="����\r\n"
			+ "Beanstalk\r\n"
			+ "�ɹ�\r\n"
			+ "Pinecone\r\n"
			+ "�ܿ�\r\n"
			+ "Jackie\r\n"
			+ "����\r\n"
			+ "Bubble\r\n"
			+ "��͡\r\n"
			+ "Arene\r\n"
			+ "����\r\n"
			+ "Aciddrop\r\n"
			+ "��\r\n"
			+ "Jaye\r\n"
			+ "����\r\n"
			+ "Click\r\n"
			+ "���ǿ�\r\n"
			+ "Podenco\r\n"
			+ "�̵�\r\n"
			+ "Cutter\r\n"
			+ "������\r\n"
			+ "Conviction\r\n"
			+ "��\r\n"
			+ "Utage\r\n"
			+ "����\r\n"
			+ "Purestream\r\n"
			+ "���ȶ�\r\n"
			+ "Ambriel\r\n"
			+ "÷\r\n"
			+ "May\r\n"
			+ "��ɣ\r\n"
			+ "Ethan\r\n"
			+ "����\r\n"
			+ "Vermeil\r\n"
			+ "����\r\n"
			+ "Dur-nar\r\n"
			+ "�ҽ���\r\n"
			+ "Myrtle\r\n"
			+ "������\r\n"
			+ "Sussurro\r\n"
			+ "������\r\n"
			+ "Greyy\r\n"
			+ "�Է�\r\n"
			+ "Beehunter\r\n"
			+ "����\r\n"
			+ "Shaw\r\n"
			+ "����\r\n"
			+ "Earthspirit\r\n"
			+ "�ɫ\r\n"
			+ "Deepcolor\r\n"
			+ "����\r\n"
			+ "�����\r\n"
			+ "������\r\n"
			+ "Cuora\r\n"
			+ "�Ƿ�\r\n"
			+ "Matterhorn\r\n"
			+ "����ʦ\r\n"
			+ "Perfumer\r\n"
			+ "��ά��\r\n"
			+ "Gavial\r\n"
			+ "ĩҩ\r\n"
			+ "Myrrh\r\n"
			+ "����\r\n"
			+ "Rope\r\n"
			+ "��\r\n"
			+ "Gravel\r\n"
			+ "Ľ˹\r\n"
			+ "Mousse\r\n"
			+ "��˿���\r\n"
			+ "Estelle\r\n"
			+ "˪Ҷ\r\n"
			+ "Frostleaf\r\n"
			+ "����\r\n"
			+ "Matoimaru\r\n"
			+ "�ű�\r\n"
			+ "Dobermann\r\n"
			+ "�춹\r\n"
			+ "Vigna\r\n"
			+ "�����\r\n"
			+ "Scavenger\r\n"
			+ "Ѷʹ\r\n"
			+ "Courier\r\n"
			+ "��ѩ\r\n"
			+ "ShiraYuki\r\n"
			+ "����\r\n"
			+ "Meteor\r\n"
			+ "������\r\n"
			+ "Jessica\r\n"
			+ "Զɽ\r\n"
			+ "Gitano\r\n"
			+ "ҹ��\r\n"
			+ "Haze\r\n";
	String tempThree="�ߵ�\r\n"
			+ "Spot\r\n"
			+ "���տ�\r\n"
			+ "Popukar\r\n"
			+ "�¼�ҹ\r\n"
			+ "Midnight\r\n"
			+ "�ձ�\r\n"
			+ "Catapult\r\n"
			+ "����\r\n"
			+ "Orchid\r\n"
			+ "ʷ������\r\n"
			+ "Steward\r\n"
			+ "������\r\n"
			+ "Ansel\r\n"
			+ "ܽ��\r\n"
			+ "Hibiscus\r\n"
			+ "����\r\n"
			+ "Lava\r\n"
			+ "�����ж�\r\n"
			+ "Adnachiel\r\n"
			+ "����˿\r\n"
			+ "Kroos\r\n"
			+ "�׸�³\r\n"
			+ "Beagle\r\n"
			+ "���\r\n"
			+ "Cardigan\r\n"
			+ "õ��ɯ\r\n"
			+ "Melantha\r\n"
			+ "����\r\n"
			+ "Plume\r\n"
			+ "���\r\n"
			+ "Vanilla\r\n"
			+ "��\r\n"
			+ "Fang\r\n";
	
	final String newSix[]=tempSix.split("[\\r\\n]");
	final String newFive[]=tempFive.split("[\\r\\n]");
	final String newFour[]=tempFour.split("[\\r\\n]");
	final String newThree[]=tempThree.split("[\\r\\n]");
	final String language[]= {"����","Ӣ��"};
	
	
	Random ra=new Random();
	
	gui(){
		once = new JButton("��ȡһ��");
		tenth = new JButton("��ȡʮ��");
		jl = new JLabel("�Ѿ�����"+count+"��û�������ˣ������",SwingConstants.CENTER);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(2,5));
		lang=new JComboBox<Object>(language) ;
		
		ans = new JLabel[10];
		for(int i=0;i<10;i++) {
			ans[i]=new JLabel("",SwingConstants.CENTER);
			jp2.add(ans[i]);
		}
		
		once.addActionListener(ls);
		tenth.addActionListener(ls);
		
		jp1.add(lang);
		jp1.add(jl);
		jp1.add(once);
		jp1.add(tenth);
		
		
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setTitle("ŷ�ʷ���ģ����");
		this.setSize(600,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	String drawCard(){
		temp = (int)(Math.random()*100)+1;
		if(count<=50) {
			if(temp<DEFULTTHREE) {//3
				count++;
				return "<font color=blue>"+TREE[ra.nextInt(17)]+"<font>";
//				return "����";
			}else if(temp<DEFULTFOUR) {//4
				count++;
				return "<font color=black>"+FOUR[ra.nextInt(33)]+"<font>";
//				return "����";
			}else if(temp<DEFULTFIVE) {//5
				count++;
				return "<font color=yellow>"+FIVE[ra.nextInt(45)]+"<font>";
//				return "����";
			}else if(temp<=DEFULTSIX) {//6
				count=0;
				return "<font color=orange>"+SIX[ra.nextInt(20)]+"<font>";
//				return "����";
			}
			
		}else {
			plus=count-50;
			if(temp<DEFULTTHREE-plus*2) {//3
				count++;
				return "<font color=blue>"+TREE[ra.nextInt(17)]+"<font>";
//				return "����";
			}else if(temp<DEFULTFOUR-plus*2) {//4
				count++;
				return "<font color=black>"+FOUR[ra.nextInt(33)]+"<font>";
//				return "����";
			}else if(temp<DEFULTFIVE-plus*2) {//5
				count++;
				return "<font color=yellow>"+FIVE[ra.nextInt(45)]+"<font>";
//				return "����";
			}else if(temp<=DEFULTSIX) {//6
				count=0;
				return "<font color=orange>"+SIX[ra.nextInt(20)]+"<font>";
//				return "����";
			}
			
		}
		return null;
	}
	
	class listener implements ActionListener{
		
		
//		StringBuffer sb=new StringBuffer(),sb2=new StringBuffer();

		@Override
		public void actionPerformed(ActionEvent x) {
			// TODO Auto-generated method stub
			if(x.getSource()==once) {
//				ans.setText("<html><font size=60>"+drawCard()+"<font><html>");
//				jl.setText("�Ѿ�����"+count+"��û�������ˣ������");
				ans[2].setText("<html><font size=6>"+drawCard()+"<font><html>");
				jl.setText("�Ѿ�����"+count+"��û�������ˣ������");
				
			}else if(x.getSource()==tenth) {
//				for(int i=0;i<5;i++) {
////					sb.append(drawCard()+" ");
//					
//					
//				}
//				for(int i=0;i<5;i++) {
////					sb2.append(drawCard()+" ");
//					
//					
//				}
//				ans.setText("<html><font size=30>"+sb.toString()+"<br/>"+sb2.toString()+"<font><html>");
//				jl.setText("�Ѿ�����"+count+"��û�������ˣ������");
//				sb.delete(0, sb.length()-1);
//				sb2.delete(0, sb2.length()-1);
				for(JLabel i:ans) {
					i.setText("<html><font size=6>"+drawCard()+"<font><html>");
				}
				jl.setText("�Ѿ�����"+count+"��û�������ˣ������");
				
				
			}
			
		}
	}
}
