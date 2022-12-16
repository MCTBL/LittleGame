package lifeGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
	String sate = "stop";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyJButton temp = (MyJButton) e.getSource();
		switch (temp.name) {
		case "chess":
			if(temp.getBackground() == Color.GRAY) {
				temp.setBackground(Color.WHITE);
				temp.sate = "alive";
			}else {
				temp.setBackground(Color.GRAY);
				temp.sate = "die";
			}
		break;
		case "start":
			if(sate.equals("stop")) {
				new CoreCode().start();
				sate = "start";
			}else {
				CoreCode.loop = false;
				sate = "stop";
			}
			
		break;
		case "nextStep":
			CoreCode.loop = false;
			sate = "stop";
			CoreCode.oneStep();
		break;
//		case "stop":
//			CoreCode.loop = false;
//		break;
		case "reset":
			CoreCode.loop = false;
			for(MyJButton[] x : GUI.chessBoard) {
				for(MyJButton y : x) {
					y.sate = "die";
					y.setBackground(Color.GRAY);
				}
			}
		break;
		}
	}

}
