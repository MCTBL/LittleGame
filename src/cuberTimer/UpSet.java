package cuberTimer;

import java.util.Random;

public class UpSet {
	
	private static String STEP[] = {"R", "L", "U", "D", "F", "B"};
	private static String set[], ans;
	private static Random a = new Random();
	private static int dou, rev, len, index;
	
	public static String setup() {
		len = a.nextInt(2);
		set = new String[20+len];
		for(int i = 0; i < set.length; i++) {
			dou = a.nextInt(10);
			rev = a.nextInt(2);
			if(i == 0) {
				index = a.nextInt(6);
				set[i] = STEP[index];
				if(dou <= 3) {
					set[i] = set[i]+"2";
				}else {
					if(rev == 1) {
						set[i] = set[i]+"'";
					}else {
						set[i] = set[i]+" ";
					}
				}
			}else {
				if(index == 0 || index == 1) {
					index = a.nextInt(4)+2;
				}else if(index == 2 || index == 3) {
					index = a.nextInt(4);
					if(index >= 2) {
						index += 2;
					}
				}else {
					index = a.nextInt(4);
				}
				set[i] = STEP[index];
				if(dou <= 3) {
					set[i] = set[i]+"2";
				}else {
					if(rev == 1) {
						set[i] = set[i]+"'";
					}else {
						set[i] = set[i]+" ";
					}
				}
			}
		}
		
		ans = "";
		for(String temp : set) {
			ans += temp+" ";
		}
		return ans;
	}
	
}
