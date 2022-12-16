package cubeSlover;

import java.util.*;

public class test {

	static Set<String> cubeSet = new HashSet<>();
	static Queue<Cube> wait = new LinkedList<>();
	static int count = 0;
	static int min = 0;

	public static void main(String[] args) throws CloneNotSupportedException {
		Cube temp = ReadCube.read();
		Cube tempC = null;
		wait.add(temp);
		min = temp.countValue();
		cubeSet.add(temp.toString());
		while (!wait.isEmpty()) {
			temp = wait.poll();
			// UU'DD'FF'BB'LL'RR'\
			if(temp.countValue() < min - 6) continue;
			String lastMove = temp.move.isEmpty() ? "" : temp.move.getLast();
			for (int i = 0; i < 12; i++) {
				tempC = (Cube) temp.clone();
				switch (i) {
				case 0:
					if (lastMove.equals("U'")) {
						break;
					} else {
						tempC.U();

						tempC.move.add("U");
					}
					break;
				case 1:
					if (lastMove.equals("U")) {
						break;
					} else {
						tempC.dU();

						tempC.move.add("U'");
					}
					break;
				case 2:
					if (lastMove.equals("D'")) {
						break;
					} else {
						tempC.D();
						tempC.move.add("D");
					}
					break;
				case 3:
					if (lastMove.equals("D")) {
						break;
					} else {
						tempC.dD();
						tempC.move.add("D'");
					}
					break;
				case 4:
					if (lastMove.equals("F'")) {
						break;
					} else {
						tempC.F();
						tempC.move.add("F");
					}
					break;
				case 5:
					if (lastMove.equals("F")) {
						break;
					} else {
						tempC.dF();
						tempC.move.add("F'");
					}
					break;
				case 6:
					if (lastMove.equals("B'")) {
						break;
					} else {
						tempC.B();
						tempC.move.add("B");
					}
					break;
				case 7:
					if (lastMove.equals("B")) {
						break;
					} else {
						tempC.dB();
						tempC.move.add("B'");
					}
					break;
				case 8:
					if (lastMove.equals("L'")) {
						break;
					} else {
						tempC.L();
						tempC.move.add("L");
					}
					break;
				case 9:
					if (lastMove.equals("L")) {
						break;
					} else {
						tempC.dL();
						tempC.move.add("L'");
					}
					break;
				case 10:
					if (lastMove.equals("R'")) {
						break;
					} else {
						tempC.R();
						tempC.move.add("R");
					}
					break;
				case 11:
					if (lastMove.equals("R")) {
						break;
					} else {
						tempC.dR();
						tempC.move.add("R");
					}
					break;
				default:
				}
				if (tempC.sloved()) {
					System.out.println("已解决，解法为：");
					for (String x : tempC.move) {
						System.out.print(x + " ");
					}
					return;
				}
				
				if (!cubeSet.contains(tempC.toString()) && tempC.move.size() <= 20 && tempC.countValue() > min - 6) {
					cubeSet.add(tempC.toString());
					if (tempC.countValue() > min) {
						min = tempC.countValue();
					}
					wait.add(tempC);
				}

			}
		}
		System.out.println("无");

	}

}
