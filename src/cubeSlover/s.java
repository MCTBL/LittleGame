package cubeSlover;

public class s {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Cube temp = ReadCube.read();
		
		Cube s = (Cube) temp.clone();
		temp.move.add("x");
		System.out.println(s.move);
	}

}
