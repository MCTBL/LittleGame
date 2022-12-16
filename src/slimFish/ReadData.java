package slimFish;

import java.io.*;

public class ReadData {
	
	BufferedReader reader;

	public void readData(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String line;
		try {
			int lineCount = 0;
			while(true) {
				line = reader.readLine();
				String lines[] = line.split(",");
				for(int i = 0; i < 40; i ++) {
					Run.board[lineCount][i] = Float.parseFloat(lines[i]);
				}
				lineCount++;
				if(lineCount == 40) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
