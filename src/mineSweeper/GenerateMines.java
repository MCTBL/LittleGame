package mineSweeper;

import java.util.Random;

/*
 *Author : Jackie-zhong
 *Time : 2022-12-08  ÏÂÎç10:31:10
 *
 */

public class GenerateMines {
	static int[][] mines;
	static int count = 10;
	static int size;

	public static void Generate(int x, int y) {
		mines = new int[y][x];
		size = x * y;
		// 0.0255ln(x) + 0.0082
//		count = (int) Math.round(x * y * (0.0255 * Math.log(x * y) + 0.0082));
		Random ra = new Random();
		for (int i = 0; i < count; i++) {
			do {
				int tempMine = ra.nextInt(size);
				if (mines[tempMine % y][(tempMine / y)] != 9) {
					mines[tempMine % y][(tempMine / y)] = 9;
					break;
				}
			} while (true);
		}
		for (int tempY = 0; tempY < mines.length; tempY++) {
			for (int tempX = 0; tempX < mines[0].length; tempX++) {
				int arround = 0;
				if (mines[tempY][tempX] == 9) {
					continue;
				}
				for (int z = -1; z <= 1; z++) {
					for (int q = -1; q <= 1; q++) {
						if(z == 0 && q == 0) {
							continue;
						}
						if (tempY + z >= 0 && tempY + z < mines.length && tempX + q >= 0 && tempX + q < mines[0].length
								&& mines[tempY + z][tempX + q] == 9) {
							arround++;
						}
					}
				}
				mines[tempY][tempX] = arround;
			}
		}
	}

}
