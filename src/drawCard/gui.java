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
	
	
	final String TREE[]= {"芬","香草","翎羽","玫兰莎","泡普卡","卡缇","米格鲁","斑点","克洛丝","安德切尔","炎熔","芙蓉","安赛尔","史都华德","梓兰","空爆","月见夜"};
	final String FOUR[]= {"夜烟","远山","格雷伊","杰西卡","流星","红云","梅","白雪","安比尔","讯使","清道夫","红豆","桃金娘","杜宾","缠丸","霜叶","艾丝黛尔","慕斯","砾","暗索","末药","嘉维尔","苏苏洛","调香师","角峰","蛇屠箱","古米","坚雷","深海色","地灵","伊桑","阿消","猎蜂"};
	final String FIVE[]= {"白面鸮","微风","凛冬","德克萨斯","苇草","诗怀雅","芙兰卡","炎客","拉普兰德","幽灵鲨","布洛卡","星极","蓝毒","白金","灰喉","陨星","送葬人","阿米娅","天火","惊蛰","梅尔","赫默","华法琳","锡兰","临光","吽","红","槐琥","雷蛇","可颂","拜松","火神","普罗旺斯","守林人","崖心","雪雉","初雪","真理","格劳克斯","空","狮蝎","食铁兽","暴行","夜魔","格拉尼"};
	final String SIX[]= {"能天使","黑","推进之王","伊芙利特","莫斯提马","艾雅法拉","刻俄柏","安洁莉娜","麦哲伦","阿","闪灵","夜莺","星熊","塞雷娅","年","银灰","陈","煌","赫拉格","斯卡蒂"};
	
	String tempSix="浊心斯卡蒂\r\n"
			+ "Skadi the Corrupting Heart\r\n"
			+ "凯尔希\r\n"
			+ "Kal'tsit\r\n"
			+ "歌蕾蒂娅\r\n"
			+ "Gladiia\r\n"
			+ "异客\r\n"
			+ "Passenger\r\n"
			+ "灰烬\r\n"
			+ "Ash\r\n"
			+ "夕\r\n"
			+ "Dusk\r\n"
			+ "嵯峨\r\n"
			+ "Saga\r\n"
			+ "空弦\r\n"
			+ "Archetto\r\n"
			+ "山\r\n"
			+ "Mountain\r\n"
			+ "迷迭香\r\n"
			+ "Rosmontis\r\n"
			+ "泥岩\r\n"
			+ "Mudrock\r\n"
			+ "瑕光\r\n"
			+ "Blemishine\r\n"
			+ "史尔特尔\r\n"
			+ "Surtr\r\n"
			+ "森蚺\r\n"
			+ "Eunectes\r\n"
			+ "棘刺\r\n"
			+ "Thorns\r\n"
			+ "铃兰\r\n"
			+ "Suzuran\r\n"
			+ "早露\r\n"
			+ "Роса\r\n"
			+ "W\r\n"
			+ "W\r\n"
			+ "温蒂\r\n"
			+ "Weedy\r\n"
			+ "傀影\r\n"
			+ "Phantom\r\n"
			+ "风笛\r\n"
			+ "Bagpipe\r\n"
			+ "刻俄柏\r\n"
			+ "Ceobe\r\n"
			+ "年\r\n"
			+ "Nian\r\n"
			+ "阿\r\n"
			+ "Aak\r\n"
			+ "煌\r\n"
			+ "Blaze\r\n"
			+ "莫斯提马\r\n"
			+ "Mostima\r\n"
			+ "麦哲伦\r\n"
			+ "Magallan\r\n"
			+ "赫拉格\r\n"
			+ "Hellagur\r\n"
			+ "黑\r\n"
			+ "Schwarz\r\n"
			+ "陈\r\n"
			+ "Ch'en\r\n"
			+ "斯卡蒂\r\n"
			+ "Skadi\r\n"
			+ "银灰\r\n"
			+ "SilverAsh\r\n"
			+ "塞雷娅\r\n"
			+ "Saria\r\n"
			+ "星熊\r\n"
			+ "Hoshiguma\r\n"
			+ "夜莺\r\n"
			+ "Nightingale\r\n"
			+ "闪灵\r\n"
			+ "Shining\r\n"
			+ "安洁莉娜\r\n"
			+ "Angelina\r\n"
			+ "艾雅法拉\r\n"
			+ "Eyjafjalla\r\n"
			+ "伊芙利特\r\n"
			+ "Ifrit\r\n"
			+ "推进之王\r\n"
			+ "Siege\r\n"
			+ "能天使\r\n"
			+ "Exusiai\r\n";
	String tempFive="赤冬\r\n"
			+ "Akafuyu\r\n"
			+ "熔泉\r\n"
			+ "Toddifons\r\n"
			+ "暴雨\r\n"
			+ "Heavyrain\r\n"
			+ "霜华\r\n"
			+ "Frost\r\n"
			+ "闪击\r\n"
			+ "Blitz\r\n"
			+ "战车\r\n"
			+ "Tachanka\r\n"
			+ "乌有\r\n"
			+ "Mr.Nothing\r\n"
			+ "炎狱炎熔\r\n"
			+ "Lava the Purgatory\r\n"
			+ "图耶\r\n"
			+ "Tuye\r\n"
			+ "爱丽丝\r\n"
			+ "Iris\r\n"
			+ "卡夫卡\r\n"
			+ "Kafka\r\n"
			+ "罗宾\r\n"
			+ "Robin\r\n"
			+ "阿米娅(近卫)\r\n"
			+ "Amiya\r\n"
			+ "絮雨\r\n"
			+ "Whisperain\r\n"
			+ "奥斯塔\r\n"
			+ "Aosta\r\n"
			+ "鞭刃\r\n"
			+ "Whislash\r\n"
			+ "四月\r\n"
			+ "April\r\n"
			+ "薄绿\r\n"
			+ "Mint\r\n"
			+ "燧石\r\n"
			+ "Flint\r\n"
			+ "特米米\r\n"
			+ "Tomimi\r\n"
			+ "安哲拉\r\n"
			+ "Andreana\r\n"
			+ "贾维\r\n"
			+ "Chiave\r\n"
			+ "蜜蜡\r\n"
			+ "Beeswax\r\n"
			+ "稀音\r\n"
			+ "Scene\r\n"
			+ "断崖\r\n"
			+ "Ayerscarpe\r\n"
			+ "亚叶\r\n"
			+ "Folinic\r\n"
			+ "莱恩哈特\r\n"
			+ "Leonhardt\r\n"
			+ "苦艾\r\n"
			+ "Absinthe\r\n"
			+ "月禾\r\n"
			+ "Tsukinogi\r\n"
			+ "石棉\r\n"
			+ "Asbestos\r\n"
			+ "极境\r\n"
			+ "Elysium\r\n"
			+ "巫恋\r\n"
			+ "Shamare\r\n"
			+ "铸铁\r\n"
			+ "Sideroca\r\n"
			+ "慑砂\r\n"
			+ "Sesa\r\n"
			+ "柏喙\r\n"
			+ "Bibeak\r\n"
			+ "惊蛰\r\n"
			+ "Leizi\r\n"
			+ "吽\r\n"
			+ "Hung\r\n"
			+ "雪雉\r\n"
			+ "Snowsant\r\n"
			+ "灰喉\r\n"
			+ "GreyThroat\r\n"
			+ "布洛卡\r\n"
			+ "Broca\r\n"
			+ "苇草\r\n"
			+ "Reed\r\n"
			+ "槐琥\r\n"
			+ "Waai Fu\r\n"
			+ "拜松\r\n"
			+ "Bison\r\n"
			+ "微风\r\n"
			+ "Breeze\r\n"
			+ "送葬人\r\n"
			+ "Executor\r\n"
			+ "炎客\r\n"
			+ "Flamebringer\r\n"
			+ "星极\r\n"
			+ "Astesia\r\n"
			+ "格劳克斯\r\n"
			+ "Glaucus\r\n"
			+ "锡兰\r\n"
			+ "Ceylon\r\n"
			+ "诗怀雅\r\n"
			+ "Swire\r\n";
	String tempFour="豆苗\r\n"
			+ "Beanstalk\r\n"
			+ "松果\r\n"
			+ "Pinecone\r\n"
			+ "杰克\r\n"
			+ "Jackie\r\n"
			+ "泡泡\r\n"
			+ "Bubble\r\n"
			+ "芳汀\r\n"
			+ "Arene\r\n"
			+ "酸糖\r\n"
			+ "Aciddrop\r\n"
			+ "孑\r\n"
			+ "Jaye\r\n"
			+ "卡达\r\n"
			+ "Click\r\n"
			+ "波登可\r\n"
			+ "Podenco\r\n"
			+ "刻刀\r\n"
			+ "Cutter\r\n"
			+ "断罪者\r\n"
			+ "Conviction\r\n"
			+ "宴\r\n"
			+ "Utage\r\n"
			+ "清流\r\n"
			+ "Purestream\r\n"
			+ "安比尔\r\n"
			+ "Ambriel\r\n"
			+ "梅\r\n"
			+ "May\r\n"
			+ "伊桑\r\n"
			+ "Ethan\r\n"
			+ "红云\r\n"
			+ "Vermeil\r\n"
			+ "坚雷\r\n"
			+ "Dur-nar\r\n"
			+ "桃金娘\r\n"
			+ "Myrtle\r\n"
			+ "苏苏洛\r\n"
			+ "Sussurro\r\n"
			+ "格雷伊\r\n"
			+ "Greyy\r\n"
			+ "猎蜂\r\n"
			+ "Beehunter\r\n"
			+ "阿消\r\n"
			+ "Shaw\r\n"
			+ "地灵\r\n"
			+ "Earthspirit\r\n"
			+ "深海色\r\n"
			+ "Deepcolor\r\n"
			+ "古米\r\n"
			+ "Гум\r\n"
			+ "蛇屠箱\r\n"
			+ "Cuora\r\n"
			+ "角峰\r\n"
			+ "Matterhorn\r\n"
			+ "调香师\r\n"
			+ "Perfumer\r\n"
			+ "嘉维尔\r\n"
			+ "Gavial\r\n"
			+ "末药\r\n"
			+ "Myrrh\r\n"
			+ "暗索\r\n"
			+ "Rope\r\n"
			+ "砾\r\n"
			+ "Gravel\r\n"
			+ "慕斯\r\n"
			+ "Mousse\r\n"
			+ "艾丝黛尔\r\n"
			+ "Estelle\r\n"
			+ "霜叶\r\n"
			+ "Frostleaf\r\n"
			+ "缠丸\r\n"
			+ "Matoimaru\r\n"
			+ "杜宾\r\n"
			+ "Dobermann\r\n"
			+ "红豆\r\n"
			+ "Vigna\r\n"
			+ "清道夫\r\n"
			+ "Scavenger\r\n"
			+ "讯使\r\n"
			+ "Courier\r\n"
			+ "白雪\r\n"
			+ "ShiraYuki\r\n"
			+ "流星\r\n"
			+ "Meteor\r\n"
			+ "杰西卡\r\n"
			+ "Jessica\r\n"
			+ "远山\r\n"
			+ "Gitano\r\n"
			+ "夜烟\r\n"
			+ "Haze\r\n";
	String tempThree="斑点\r\n"
			+ "Spot\r\n"
			+ "泡普卡\r\n"
			+ "Popukar\r\n"
			+ "月见夜\r\n"
			+ "Midnight\r\n"
			+ "空爆\r\n"
			+ "Catapult\r\n"
			+ "梓兰\r\n"
			+ "Orchid\r\n"
			+ "史都华德\r\n"
			+ "Steward\r\n"
			+ "安赛尔\r\n"
			+ "Ansel\r\n"
			+ "芙蓉\r\n"
			+ "Hibiscus\r\n"
			+ "炎熔\r\n"
			+ "Lava\r\n"
			+ "安德切尔\r\n"
			+ "Adnachiel\r\n"
			+ "克洛丝\r\n"
			+ "Kroos\r\n"
			+ "米格鲁\r\n"
			+ "Beagle\r\n"
			+ "卡缇\r\n"
			+ "Cardigan\r\n"
			+ "玫兰莎\r\n"
			+ "Melantha\r\n"
			+ "翎羽\r\n"
			+ "Plume\r\n"
			+ "香草\r\n"
			+ "Vanilla\r\n"
			+ "芬\r\n"
			+ "Fang\r\n";
	
	final String newSix[]=tempSix.split("[\\r\\n]");
	final String newFive[]=tempFive.split("[\\r\\n]");
	final String newFour[]=tempFour.split("[\\r\\n]");
	final String newThree[]=tempThree.split("[\\r\\n]");
	final String language[]= {"中文","英文"};
	
	
	Random ra=new Random();
	
	gui(){
		once = new JButton("抽取一次");
		tenth = new JButton("抽取十次");
		jl = new JLabel("已经抽了"+count+"次没出六星了，你真惨",SwingConstants.CENTER);
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
		
		this.setTitle("欧皇非酋模拟器");
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
//				return "三星";
			}else if(temp<DEFULTFOUR) {//4
				count++;
				return "<font color=black>"+FOUR[ra.nextInt(33)]+"<font>";
//				return "四星";
			}else if(temp<DEFULTFIVE) {//5
				count++;
				return "<font color=yellow>"+FIVE[ra.nextInt(45)]+"<font>";
//				return "五星";
			}else if(temp<=DEFULTSIX) {//6
				count=0;
				return "<font color=orange>"+SIX[ra.nextInt(20)]+"<font>";
//				return "六星";
			}
			
		}else {
			plus=count-50;
			if(temp<DEFULTTHREE-plus*2) {//3
				count++;
				return "<font color=blue>"+TREE[ra.nextInt(17)]+"<font>";
//				return "三星";
			}else if(temp<DEFULTFOUR-plus*2) {//4
				count++;
				return "<font color=black>"+FOUR[ra.nextInt(33)]+"<font>";
//				return "四星";
			}else if(temp<DEFULTFIVE-plus*2) {//5
				count++;
				return "<font color=yellow>"+FIVE[ra.nextInt(45)]+"<font>";
//				return "五星";
			}else if(temp<=DEFULTSIX) {//6
				count=0;
				return "<font color=orange>"+SIX[ra.nextInt(20)]+"<font>";
//				return "六星";
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
//				jl.setText("已经抽了"+count+"次没出六星了，你真惨");
				ans[2].setText("<html><font size=6>"+drawCard()+"<font><html>");
				jl.setText("已经抽了"+count+"次没出六星了，你真惨");
				
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
//				jl.setText("已经抽了"+count+"次没出六星了，你真惨");
//				sb.delete(0, sb.length()-1);
//				sb2.delete(0, sb2.length()-1);
				for(JLabel i:ans) {
					i.setText("<html><font size=6>"+drawCard()+"<font><html>");
				}
				jl.setText("已经抽了"+count+"次没出六星了，你真惨");
				
				
			}
			
		}
	}
}
