package cuberTimer;

import java.awt.*;

import javax.swing.JPanel;

import com.sun.org.apache.xerces.internal.util.Status;

@SuppressWarnings("all")
public class MyJPanel extends JPanel {
	private final static int SIZE = 23;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int x[][] = { { 4, 5, 3, 1, 3, 6, 6, 1, 3 }, { 6, 6, 1, 2, 6, 1, 3, 6, 5 }, { 3, 4, 5, 5, 1, 2, 4, 2, 4 },
				{ 2, 2, 1, 3, 5, 3, 5, 4, 2 }, { 5, 4, 1, 5, 2, 5, 6, 1, 2 }, { 1, 4, 2, 3, 4, 6, 6, 3, 4 } };
		drawCube(g, 400, 0, CuberTimer.a.status);
	}

	private void drawCube(Graphics g, int x, int y, int color[][]) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int z[] : color) {
			switch (count) {
			case 0:
				drawFace(g, x+3*SIZE, y+0, z);
				break;
			case 5:
				drawFace(g, x+3*SIZE, y+6*SIZE+6, z);
				break;
			default:
				drawFace(g, x+(count-1)*3*SIZE+3*(count-2), y+3+3*SIZE, z);
			}
			count++;
		}
	}

	private void drawFace(Graphics g, int x, int y, int color[]) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i : color) {
			switch (i) {
			case 1:
				g.setColor(Color.GREEN);
				break;
			case 2:
				g.setColor(Color.BLUE);
				break;
			case 3:
				g.setColor(Color.WHITE);
				break;
			case 4:
				g.setColor(Color.YELLOW);
				break;
			case 5:
				g.setColor(Color.RED);
				break;
			case 6:
				g.setColor(Color.ORANGE);
				break;
			}
			drawSqule(g, x + count % 3 * SIZE, y + count / 3 * SIZE);
			count++;
		}
	}

	private void drawSqule(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, SIZE, SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SIZE, SIZE);
	}
}
