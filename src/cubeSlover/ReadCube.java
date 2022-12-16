package cubeSlover;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCube {
	
	public static  Cube read() {
		int[][] status = new int[6][9];
		try {
			BufferedReader read = new BufferedReader(new FileReader("cube.txt"));
			for(int i = 0; i < 6; i ++) {
				char[] temp = read.readLine().toUpperCase().toCharArray();
				for(int x = 0; x < 9; x ++) {
					switch(temp[x]) {
					case 'W':
						status[i][x] = 3;
						break;
					case 'O':
						status[i][x] = 6;
						break;
					case 'G':
						status[i][x] = 1;
						break;
					case 'R':
						status[i][x] = 5;
						break;
					case 'B':
						status[i][x] = 2;
						break;
					case 'Y':
						status[i][x] = 4;
						break;
					}
				}
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Cube(status);
	}
	
	
}
