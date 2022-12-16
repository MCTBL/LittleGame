package cuberTimer;

public class CuberTimer {
	public static Cube a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		a = new Cube("L F2 U' B2 D F2 D' L2 D2 B2 L2 D R' B' D L F U2 L D R'");
//		a = new Cube("R U' R U R U R U' R' U' R R");
		new MyJFrame();
		a = new Cube(MyJFrame.setup);

		
	}

}
